package Util;


import Assessment.IQuestion;
import Report.IReport;
import Report.ReportBuilder;

import java.util.Map;

public class AutoGrader implements GradingUtil{

    private Map<String, Integer> answerKey;

    @Override
    public void setAnswerKey(Map<String, Integer> answerKey) {
        this.answerKey = answerKey;
    }

    @Override
    public IReport gradeAssessment(IQuestion questions, String source) {
        return ReportBuilder.buildReport(answerKey, questions, source);
    }
}
