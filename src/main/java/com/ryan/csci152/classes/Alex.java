package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Broker;
import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.Party;

import java.util.List;

public class Alex implements Party {

    Broker roster;
    List<IAssessment> assessments;

    Alex(Broker roster){
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

    @Override
    public void updateParty(IAssessment assessment) {

    }

    private void gradeAssessment(IAssessment assessment){

    }


}
