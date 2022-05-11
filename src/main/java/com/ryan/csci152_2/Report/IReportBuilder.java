package com.ryan.csci152_2.Report;

import com.ryan.csci152_2.Assessment.IQuestion;

import java.util.Map;

public interface IReportBuilder {

    IReportBuilder getInstance();

    IReport buildReport(Map<String, Integer> answerKey, IQuestion questions, String source);
}
