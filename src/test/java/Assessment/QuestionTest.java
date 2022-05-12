package Assessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {


    private String question = "Question";
    private Integer answer;
    @Mock
    private IQuestion prev;
    @Mock
    private IQuestion next;

    private IQuestion underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new Question(question, prev, next);
    }

    @Test
    void itShouldGetQuestion() {
        // Given
        // When
        String actual = underTest.getQuestion();
        // Then
        assertThat(actual).isEqualTo(question);
    }

    @ParameterizedTest
    @MethodSource
    void itShouldAnswerQuestion(Integer answer) {
        // Given
        underTest.answerQuestion(answer);
        // When
        Integer actual = underTest.getAnswer();
        // Then
        assertEquals(actual, answer);
    }
    static Stream<Arguments> itShouldAnswerQuestion(){
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4)
        );
    }

    /* On 5-11-22, this test caught logic bug on lower bound*/
    @ParameterizedTest
    @MethodSource
    void itShouldThrowOnAnswerOutOfRange(Integer outOfRange){
        // Given
        // When
        Exception e = assertThrows(IllegalStateException.class,
                () -> underTest.answerQuestion(outOfRange));
        // Then
        assertThat(e).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Answer out of bounds!");
    }
    /* Below defines the Test cases that SHOULD be out of range,
    * this is from Boundary Value Analysis, and equivalence partitioning*/
    static Stream<Arguments> itShouldThrowOnAnswerOutOfRange(){
        return Stream.of(
                Arguments.of(0),
                Arguments.of(5)
        );
    }

    @Test
    void itShouldThrowOnNullAnswer(){
        // Given
        // When
        Exception e = assertThrows(IllegalStateException.class,
                () -> underTest.getAnswer());
        // Then
        assertThat(e)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("No answer defined!");
    }

    @Test
    void itShouldNext() {
        // Given
        // When
        IQuestion actual = underTest.next();
        // Then
        assertEquals(actual, next);
    }

    @Test
    void itShouldPrev() {
        // Given
        // When
        IQuestion actual = underTest.prev();
        // Then
        assertEquals(actual, prev);
    }

    @Test
    void itShouldGetRoot() {
        // Given that underTest is defined with a 'prev' node we should expect
        // the following to return 'prev' as the root
        // When
        IQuestion actual = underTest.getRoot();
        // Then
        assertEquals(actual, prev);
    }

    @Test
    void itShouldGetBuilder() {
        // Given
        // When
        IQuestionBuilder builder = underTest.getBuilder();
        // Then
        assertThat(builder)
                .isInstanceOf(Question.QuestionBuilder.class);

        // Given NO questions, it should build to a null item
        assertNull(builder.build());
    }

    @Test
    void itShouldAllowStaticBuilderRetrieval(){
        // Given
        // When
        IQuestionBuilder builder = new Question.QuestionBuilder();

        // Then
        assertThat(builder)
                .isInstanceOf(Question.QuestionBuilder.class);

        // Given NO questions, it should build to a null item
        assertNull(builder.build());
    }

    @ParameterizedTest
    @MethodSource
    void itShouldBuildQuestionFromSet(Set<String> stringSet){

        // Given
        IQuestionBuilder builder = underTest.getBuilder();

        // When
        stringSet.forEach(builder::addQuestion);

        // Then
        IQuestion root = builder.build();

        while(root != null){
            assertTrue(stringSet.contains(root.getQuestion()));
            root = root.next();
        }
    }
    static Stream<Arguments> itShouldBuildQuestionFromSet(){
        return Stream.of(
                Arguments.of(Set.of("Question1", "Question2", "Question3")),
                Arguments.of(Set.of("Question1")),
                Arguments.of(Set.of())
        );
    }

    /* The following Test is for checking a deep copy
    * To ensure proper copying, Create Question object
    * Clone it, then provide 'Answers' to each object
    * Assert that their Questions are equal BUT their
    * answers are different*/
    @ParameterizedTest
    @MethodSource
    void itShouldTestClone(Set<String> questionSet, List<Integer> answerSet1, List<Integer> answerSet2) {
        // Given
        IQuestionBuilder builder = new Question.QuestionBuilder();
        questionSet.forEach(builder::addQuestion);
        // When
        IQuestion questionSet1 = builder.build();
        IQuestion questionSet2 = questionSet1.clone();

        int answerIndex = 0;
        do{
            questionSet1.answerQuestion(answerSet1.get(answerIndex));
            questionSet2.answerQuestion(answerSet2.get(answerIndex));

            answerIndex++;
            if(questionSet1.next() == null || questionSet2.next() == null){
                break;
            }
            questionSet1 = questionSet1.next();
            questionSet2 = questionSet2.next();

        }
        while(true);


        questionSet1 = questionSet1.getRoot();
        questionSet2 = questionSet2.getRoot();

        while(questionSet1 != null && questionSet2 != null){
            assertEquals(questionSet1.getQuestion(), questionSet2.getQuestion());
            assertNotEquals(questionSet1.getAnswer(), questionSet2.getAnswer());
            questionSet1 = questionSet1.next();
            questionSet2 = questionSet2.next();
        }

    }
    static Stream<Arguments> itShouldTestClone(){
        return Stream.of(
                Arguments.of(Set.of("Question1", "Question2"), List.of(1, 3), List.of(2, 4))
        );
    }

}