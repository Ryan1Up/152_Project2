package com.ryan.csci152.brokers.classes;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.students.interfaces.Assignee;

import java.util.ArrayList;
import java.util.List;

/* A Broker is the in-between 'message' sender
* between the Publisher 'Professor' and the
* Subscribers 'Students' This class in particular
* works with Assessments and Students */
public class AssessmentBroker implements Broker {


    private final List<Assignee> subscribers;

    public AssessmentBroker() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Assignee subscriber) {
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void publishAssessment(Assessment assessment) {
        for(Assignee s : subscribers){
            System.out.println(("Broker Sending assignment to: %s").formatted(s.getName()));
            s.assign(assessment);
        }
    }

    @Override
    public void publishResults(IReport report) {
        for(Assignee s : subscribers){
            if(s.getId().equals(report.getId())){
                System.out.println(("Broker Sending results to: %s").formatted(s.getName()));
                s.sendResults(report);
            }
        }
    }

    @Override
    public void dropSubscriber(Assignee subscriber) {
        this.subscribers.remove(subscriber);
    }

}
