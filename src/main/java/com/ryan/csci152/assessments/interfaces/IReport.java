package com.ryan.csci152.assessments.interfaces;

import java.util.UUID;

public interface IReport {

    void setGrade(Integer grade);

    void setDescription(String description);

    String getDescription();

    UUID getId();

    void setId(UUID id);

    Integer getGrade();
}
