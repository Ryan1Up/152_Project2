package Professor;


import Assessment.IQuestion;

public interface Grader {

    void gradeAssessment(IQuestion questions, String name);
}
