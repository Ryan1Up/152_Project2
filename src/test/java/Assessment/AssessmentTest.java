package Assessment;

import Professor.Grader;
import Student.Assignee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


class AssessmentTest {

    @Mock
    private List<Assignee> roster;

    @Mock
    private IQuestion questions;

    @Mock
    private static Grader grader;

    @Mock
    private static Assignee assignee;

    @Mock
    private IQuestionBuilder builder;

    @Captor
    ArgumentCaptor<Assessment> assessmentArgumentCaptor;

    @Captor
    ArgumentCaptor<IQuestion> questionArgumentCaptor;

    @Captor
    ArgumentCaptor<Assignee> assigneeArgumentCaptor;

    private Assessment underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new Assessment(roster, questions, grader);
    }

    @ParameterizedTest
    @MethodSource
    void itShouldNotifyRoster(List<Assignee> testRoster) {
        // Given
        underTest = new Assessment(testRoster, questions, grader);
        doNothing().when(assignee).notify(underTest);
        // When
        underTest.notifyRoster();
        // Then

        if(roster.size() > 0){
            verify(assignee).notify(assessmentArgumentCaptor.capture());

            assertThat(underTest).usingRecursiveComparison().isEqualTo(assessmentArgumentCaptor.getValue());
        }
        verify(assignee, times(roster.size())).notify(underTest);
    }
    static Stream<Arguments> itShouldNotifyRoster(){
        assignee = mock(Assignee.class);
        return Stream.of(
                Arguments.of(List.of(assignee, assignee, assignee)),
                Arguments.of(List.of())
        );
    }

    @Test
    void itShouldGetQuestions() {
        // Given
        /* Assessment is Expected to Return a Deep Copy, aka a Clone of Questions*/
        given(questions.clone()).willReturn(questions);
        // When
        IQuestion expected = underTest.getQuestions();
        // Then
        assertThat(expected).usingRecursiveComparison().isEqualTo(questions);
        verify(questions, times(1)).clone();
    }

    @Test
    void itShouldSendToGrader() {
        // Given
        String source = "Name";
        doNothing().when(grader).gradeAssessment(questions, source);

        // When
        underTest.sendToGrader(source, questions);
        // Then
        verify(grader).gradeAssessment(questionArgumentCaptor.capture(), anyString());
        verifyNoMoreInteractions(grader);
        assertThat(questions).usingRecursiveComparison().isEqualTo(questionArgumentCaptor.getValue());

    }

    @Test
    void itShouldSubscribe() {
        // Given
        doReturn(true).when(roster).add(assignee);
        doReturn(false).when(roster).contains(assignee);
        // When
        underTest.subscribe(assignee);
        // Then
        verify(roster).add(assigneeArgumentCaptor.capture());
        verify(roster, times(1)).contains(assignee);
        verifyNoMoreInteractions(roster);

        assertThat(assigneeArgumentCaptor.getValue()).usingRecursiveComparison().isEqualTo(assignee);
    }

    @Test
    void itShouldThrowOnReSubscribe(){
        // Given
        doReturn(true).when(roster).contains(assignee);
        // When
        Exception e = assertThrows(IllegalStateException.class,
                            () -> underTest.subscribe(assignee));
        // Then
        assertThat(e)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Assignee already subscribed!");
    }

    @Test
    void itShouldSetGrader() {
        // Given
        Assessment freshAssessment = new Assessment(questions);
        String someSource = "SomeSource";
        doNothing().when(grader).gradeAssessment(eq(questions), eq(someSource));

        // When
        freshAssessment.setGrader(grader);
        freshAssessment.sendToGrader(someSource, questions);
        // Then
        verify(grader, times(1)).gradeAssessment(eq(questions), eq(someSource));
        verifyNoMoreInteractions(grader);

    }

    @Test
    void itShouldSetQuestions() {
        // Given
        Assessment freshAssessment = new Assessment(null, grader);
        given(questions.clone()).willReturn(questions);
        // When
        freshAssessment.setQuestions(questions);
        // Then
        IQuestion actual = freshAssessment.getQuestions();
        assertThat(actual).usingRecursiveComparison().isEqualTo(questions);
    }

    @Test
    void itShouldGetBuilder(){
        given(questions.getBuilder()).willReturn(builder);

        IQuestionBuilder actual = underTest.getQuestionBuilder();

        assertEquals(builder, actual);
    }
}