package com.ryan.csci152.interfaces;

import java.util.Map;

public interface IReports {

    void setGrade(int grade);

    int getGrade();

    String getReportAsString();

    void setResults(Map<Question, Integer> results);

    void setSubscriber(Party subscriber);

    Party getSubscriber();
}
