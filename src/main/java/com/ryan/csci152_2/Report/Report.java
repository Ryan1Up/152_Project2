package com.ryan.csci152_2.Report;


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
