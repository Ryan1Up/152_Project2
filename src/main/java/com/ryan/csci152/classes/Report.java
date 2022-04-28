package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.IReports;
import com.ryan.csci152.interfaces.Question;

import java.util.Map;

public class Report implements IReports {

    private Integer grade;

    /*Question contains the submitted answer, Integer is the Correct Answer*/
    Map<Question, Integer> results;

    @Override
    public void setGrade(int grade) {

    }

    @Override
    public int getGrade() {
        return 0;
    }

    @Override
    public String getReportAsString() {
        return null;
    }

    @Override
    public void setResults(Map<Question, Integer> results) {

    }
}
