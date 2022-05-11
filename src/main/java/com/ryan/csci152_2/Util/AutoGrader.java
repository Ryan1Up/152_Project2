package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.IQuestion;
import com.ryan.csci152_2.Report.IReport;
import com.ryan.csci152_2.Report.IReportBuilder;
import com.ryan.csci152_2.Report.ReportBuilder;

import java.util.Map;

public class AutoGrader implements GradingUtil{

    private Map<String, Integer> answerKey;
    private final IReportBuilder builder = new ReportBuilder();


    @Override
    public void setAnswerKey(Map<String, Integer> answerKey) {
        this.answerKey = answerKey;
    }

    @Override
    public IReport gradeAssessment(IQuestion questions, String source) {
        return builder.buildReport(answerKey, questions, source);
    }
}
