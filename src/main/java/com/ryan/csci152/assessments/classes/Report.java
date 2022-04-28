package com.ryan.csci152.assessments.classes;

import com.ryan.csci152.assessments.interfaces.IReport;

import java.util.UUID;

public class Report implements IReport {

    private Integer grade;
    private String description;
    private UUID assigneeId;

    public Report(Integer grade, String description, UUID id) {
        this.grade = grade;
        this.description = description;
        this.assigneeId = id;
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

    @Override
    public UUID getId() {
        return assigneeId;
    }

    @Override
    public void setId(UUID id) {
        this.assigneeId = id;
    }

    @Override
    public Integer getGrade() {
        return grade;
    }

}
