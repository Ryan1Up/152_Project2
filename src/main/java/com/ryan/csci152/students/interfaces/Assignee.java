package com.ryan.csci152.students.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.professors.interfaces.Grader;

public interface Assignee {

    void assign(Assessment assessment);

    void submit();

    void setGrader(Grader grader);

    /*This will just randomly fill out the assessment*/
    void doAssessment();

    void sendResults(IReport results);
}
