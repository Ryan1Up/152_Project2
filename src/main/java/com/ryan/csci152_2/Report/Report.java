package com.ryan.csci152_2.Report;

import com.ryan.csci152_2.Assessment.IQuestion;


import java.util.Map;

public record Report(String reportString, Integer score,
                     String source) implements IReport {


    public String getReportString() {
        return reportString;
    }

    public Integer getScore() {
        return score;
    }

    public String getSource() {
        return source;
    }
}
