package Report;

import Assessment.IQuestion;
import Assessment.IQuestionBuilder;
import Assessment.Question;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportBuilderTest {


    private static String reportStringWCorrect(Map<String, Integer> answerKey, String source){
        StringBuilder builder = new StringBuilder("Name: " + source + "\n");
        answerKey.keySet().forEach(c -> {
           builder.append(c)
                   .append("\n")
                   .append("Answer: ").append(answerKey.get(c))
                   .append(" - Correct!")
                   .append("\n");
        });
        builder.append("\nTotal Score: ").append(answerKey.keySet().size());
        return builder.toString();
    }

    private static String reportStringWIncorrect(Map<String, Integer> answerKey, String source){
        StringBuilder builder = new StringBuilder("Name: " + source + "\n");
        answerKey.keySet().forEach(c -> {
            builder.append(c)
                    .append("\n")
                    .append("Answer: ").append((answerKey.get(c) == 4) ? answerKey.get(c) - 1 : answerKey.get(c) + 1)
                    .append(" - Incorrect!")
                    .append("\nCorrect Answer: ")
                    .append(answerKey.get(c))
                    .append("\n");
        });
        builder.append("\nTotal Score: ").append(0);
        return builder.toString();
    }

    private static String reportStringWNotAnswered(Map<String, Integer> answerKey, String source){
        StringBuilder builder = new StringBuilder("Name: " + source + "\n")
                .append("Question not answered...\n");

        builder.append("\nTotal Score: ").append(0);
        return builder.toString();
    }


    private static IQuestion getCorrectQuestionsFromKey(Map<String, Integer> answerKey){
        IQuestionBuilder builder = new Question.QuestionBuilder();
        answerKey.keySet().forEach(builder::addQuestion);
        IQuestion question = builder.build();
        while(true){
            question.answerQuestion(answerKey.get(question.getQuestion()));
            if(question.next() == null){
                break;
            }
            question = question.next();
        }
        return question.getRoot();
    }

    private static IQuestion getIncorrectQuestionsFromKey(Map<String, Integer> answerKey){
        IQuestionBuilder builder = new Question.QuestionBuilder();
        answerKey.keySet().forEach(builder::addQuestion);
        IQuestion question = builder.build();
        while(true){
            Integer val = answerKey.get(question.getQuestion());
            question.answerQuestion( (val==4) ? val - 1 : val + 1);
            if(question.next() == null){
                break;
            }
            question = question.next();
        }
        return question.getRoot();
    }

    private static IQuestion getUnansweredQuestionsFromKey(Map<String, Integer> answerKey){
        IQuestionBuilder builder = new Question.QuestionBuilder();
        answerKey.keySet().forEach(builder::addQuestion);
        return builder.build();

    }

    /* On 5-12-22, this caught a logic bug, report builder stopped 1 question
    * early each time due to an eager check against question.next() != null
    * as well as a formatting error when dealing with unanswered questions*/
    @ParameterizedTest
    @MethodSource
    void itShouldBuildReport(Map<String, Integer> answerKey,
                             IQuestion questions,
                             String source,
                             Integer score,
                             String expected) {
        // Given
        // When
        IReport actual = ReportBuilder.buildReport(answerKey, questions, source);
        // Then

        assertEquals(actual.getSource(), source);
        assertEquals(actual.getScore(), score);
        assertEquals(actual.getReportString(), expected);
    }
    static Stream<Arguments> itShouldBuildReport(){
        return Stream.of(
            Arguments.of(Map.of("Question", 1, "Question 2", 2),                                 // Answer Key
                    getCorrectQuestionsFromKey(Map.of("Question", 1,"Question 2", 2)),           // Completed and Correct Answers
                    "Test",                                                                                    // Source Name
                    2,                                                                                         // Expected Score
                    reportStringWCorrect(Map.of("Question", 1,"Question 2", 2), "Test")), // Expected report string

            Arguments.of(Map.of("Question", 1),
                    getIncorrectQuestionsFromKey(Map.of("Question", 1)),
                    "Test",
                    0,
                    reportStringWIncorrect(Map.of("Question", 1), "Test")),

            Arguments.of(Map.of("Question", 1),
                    getUnansweredQuestionsFromKey(Map.of("Question", 1)),
                    "Test",
                    0,
                    reportStringWNotAnswered(Map.of("Question", 1), "Test"))
        );
    }

}