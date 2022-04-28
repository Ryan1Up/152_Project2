package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Broker;
import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.Party;

import java.util.List;

public class Alex implements Party {

    private String name;
    private Broker roster;

    private List<IAssessment> assessments;

    Alex(String name, Broker roster){
        this.name = name;
        this.roster = roster;
    }

    void publishAssessment(IAssessment assessment){
        roster.publish(assessment);
    }

    void addAssessment(IAssessment assessment) {
        if (!this.assessments.contains(assessment)) {
            this.assessments.add(assessment);
        }
    }

    /*Update party of assessment completion*/
    @Override
    public void updateParty(IAssessment assessment) {
        /*Grade assignment, then publish results*/
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private void gradeAssessment(IAssessment assessment){

    }


}
