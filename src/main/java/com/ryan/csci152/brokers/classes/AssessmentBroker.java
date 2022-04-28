package com.ryan.csci152.brokers.classes;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.students.classes.Student;

import java.util.ArrayList;
import java.util.List;

public class AssessmentBroker implements Broker {

    List<Student> subscribers;

    public AssessmentBroker() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Student subscriber) {
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void publishAssessment(Assessment assessment) {
        for(Student s : subscribers){
            System.out.println(("Broker Sending assignment to: %s").formatted(s.getName()));
            s.assign(assessment);
        }
    }

    @Override
    public void publishResults(IReport report) {
        for(Student s : subscribers){
            if(s.getId().equals(report.getId())){
                System.out.println(("Broker Sending results to: %s").formatted(s.getName()));
                s.sendResults(report);
            }
        }
    }

}
