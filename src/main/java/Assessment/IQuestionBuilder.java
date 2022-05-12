package Assessment;

public interface IQuestionBuilder {

    IQuestionBuilder addQuestion(String question);

    IQuestion build();
}
