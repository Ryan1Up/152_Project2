package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Broker;
import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.Party;

import java.util.List;

public class Roster implements Broker{

    List<Party> subscribers;

    @Override
    public void publish(IAssessment assessment) {
        for(Party s : subscribers){
            s.updateParty(assessment);
        }
    }

    @Override
    public void subscribe(Party party) {
        if(!subscribers.contains(party)){
            subscribers.add(party);
        }
    }
}
