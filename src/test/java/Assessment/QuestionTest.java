package Assessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // Then
    }

    @Test
    void itShouldTestClone() {
        // Given
        // When
        // Then
    }
}