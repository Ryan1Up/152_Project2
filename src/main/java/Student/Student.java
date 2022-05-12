package Student;


import Assessment.IAssessment;
import Assessment.IQuestion;

public abstract class Student implements Assignee{

    private String name;
    private IAssessment assessment;
    private IQuestion questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(IAssessment assessment) {
        this.assessment = assessment;
    }

    public IQuestion getQuestions() {
        return questions;
    }

    public void setQuestions(IQuestion questions) {
        this.questions = questions;
    }
}
