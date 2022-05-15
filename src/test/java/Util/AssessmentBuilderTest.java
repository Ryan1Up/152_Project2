package Util;

import Assessment.IAssessment;
import Assessment.IQuestion;
import Assessment.IQuestionBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AssessmentBuilderTest {

    private AssessmentBuilder underTest;

    @Mock
    private IQuestionBuilder builder;

    @Mock
    private IQuestion question;

    @Mock
    private IAssessment assessment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new AssessmentBuilder();
    }

    @ParameterizedTest
    @MethodSource
    void itShouldFillAssessmentQuestionsFromList(Set<String> questions, Integer expectedCalls) {
        // Given


        given(builder.build()).willReturn(question);
        doReturn(question).when(assessment).getQuestions();
        doNothing().when(assessment).setQuestions(question);
        doReturn(builder).when(builder).addQuestion(any());
        doReturn(builder).when(assessment).getQuestionBuilder();
        // When
        IAssessment actual = underTest.fillAssessmentQuestionsFromList(assessment, questions);
        // Then
        verify(builder, times(expectedCalls)).addQuestion(any());
        verify(builder, times(1)).build();
        verify(assessment, times(1)).setQuestions(question);
        verify(assessment, times(1)).getQuestionBuilder();
    }
    static Stream<Arguments> itShouldFillAssessmentQuestionsFromList(){
        return Stream.of(
                Arguments.of(Set.of("Quesiton1", "Question2"), 2),
                Arguments.of(Set.of("Quesiton1"), 1),
                Arguments.of(Set.of(), 0)
        );
    }
}