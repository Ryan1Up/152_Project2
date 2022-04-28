package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.IReports;

public class Student extends StudentBase {

    private IAssessment currentAssignment;
    private String name;
    private IReports results;

    public Student(IAssessment currentAssignment, String name) {
        this.currentAssignment = currentAssignment;
        this.name = name;
    }

    /* Gets assigned an Assignment*/
    @Override
    public void updateParty(IAssessment assessment) {
        this.currentAssignment = assessment;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void submitAssignment(){
        currentAssignment.notifyPublisher();
        currentAssignment = null;
    }

    @Override
    public void updateResults(IReports results) {
        this.results = results;
    }

    @Override
    public String getResults() {
        return results.getReportAsString();
    }
}
