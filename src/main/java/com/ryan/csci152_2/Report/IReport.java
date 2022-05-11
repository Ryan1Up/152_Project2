package com.ryan.csci152_2.Report;

import com.ryan.csci152_2.Assessment.IQuestion;

import java.util.Map;

public interface IReport {

    IReport buildReport(Map<String, Integer> answerKey, IQuestion questions, String source);

    String getReportString();

    Integer getScore();

    String getSource();
}
