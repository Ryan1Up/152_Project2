package Assessment;


import Professor.Grader;
import Student.Assignee;

public interface IAssessment {

    void notifyRoster();

    IQuestion getQuestions();

    IQuestionBuilder getQuestionBuilder();

    void sendToGrader(String source, IQuestion answers);

    void subscribe(Assignee assignee) throws IllegalStateException;

    void setGrader(Grader grader);

    void setQuestions(IQuestion questions);
}
