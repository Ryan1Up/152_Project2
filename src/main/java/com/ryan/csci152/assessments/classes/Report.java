package com.ryan.csci152.assessments.classes;

import com.ryan.csci152.assessments.interfaces.IReport;

public class Report implements IReport {

    private Integer grade;
    private String description;

    public Report(Integer grade, String description) {
        this.grade = grade;
        this.description = description;
    }

    @Override
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
