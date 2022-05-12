package Professor;

import Assessment.IAssessment;
import Assessment.IQuestion;
import Report.IReport;
import Util.GradingUtil;
import Util.IAssessmentBuilder;


import java.util.Map;

public class Professor implements Publisher, Grader, AssessmentCreator{

    private final GradingUtil gradingUtil;
    private final IAssessmentBuilder assessmentBuilder;
    private IAssessment assessment;

    public Professor(GradingUtil gradingUtil, IAssessmentBuilder assessmentBuilder){
        this.gradingUtil = gradingUtil;
        this.assessmentBuilder = assessmentBuilder;
    }

    @Override
    public void gradeAssessment(IQuestion questions, String name) {
        IReport report = gradingUtil.gradeAssessment(questions, name);
        System.out.println(report.getReportString());
    }

    @Override
    public void publish() {
        this.assessment.notifyRoster();
    }

    @Override
    public void createAssessment(Map<String, Integer> assessmentQuestionsAndAnswer, IAssessment blankAssessment) {
        gradingUtil.setAnswerKey(assessmentQuestionsAndAnswer);
        this.assessment = assessmentBuilder
                .fillAssessmentQuestionsFromList(blankAssessment, assessmentQuestionsAndAnswer.keySet());
        this.assessment.setGrader(this);
    }

    @Override
    public IAssessment getAssessment() {
        return this.assessment;
    }
}
