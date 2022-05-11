package com.ryan.csci152_2.Professor;

import com.ryan.csci152_2.Assessment.IAssessment;
import com.ryan.csci152_2.Assessment.IQuestion;
import com.ryan.csci152_2.Report.IReport;
import com.ryan.csci152_2.Student.Assignee;
import com.ryan.csci152_2.Util.IAssessmentBuilder;
import com.ryan.csci152_2.Util.GradingUtil;

import java.util.Map;

public class Professor implements Publisher, Grader, AssessmentCreator{

    private Map<String, Integer> answerKey;
    private GradingUtil gradingUtil;
    private IAssessmentBuilder assessmentBuilder;
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
    public void registerAssignee(Assignee assignee) {
        if(this.assessment != null){
            this.assessment.subscribe(assignee);
        }
    }

    @Override
    public IAssessment getAssessment() {
        return this.assessment;
    }
}
