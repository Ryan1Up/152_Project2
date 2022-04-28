package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Broker;
import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.IReports;
import com.ryan.csci152.interfaces.Party;

import java.util.List;

public class Roster implements Broker{

    List<StudentBase> subscribers;

    @Override
    public void publish(IAssessment assessment) {
        for(Party s : subscribers){
            s.updateParty(assessment);
        }
    }

    @Override
    public void publish(IReports report) {
        for(StudentBase s: subscribers){
            if(report.getSubscriber().equals(s)){
                s.updateResults(report);
            }
        }
    }

    @Override
    public void subscribe(StudentBase party) {
        if(!subscribers.contains(party)){
            subscribers.add(party);
        }
    }
}
