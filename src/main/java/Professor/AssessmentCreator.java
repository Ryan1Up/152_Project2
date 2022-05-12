package Professor;

import Assessment.IAssessment;

import java.util.Map;

public interface AssessmentCreator {

    void createAssessment(Map<String, Integer> assessmentQuestionsAndAnswer, IAssessment blankAssessment);

    IAssessment getAssessment();
}
