package com.ryan.csci152.professors.classes;

import com.ryan.csci152.Util.classes.GraderUtil;
import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.professors.interfaces.Grader;
import com.ryan.csci152.professors.interfaces.Publisher;

import java.util.HashMap;
import java.util.Map;

/* This class has 2 responsibilities.
* 1. Publish assessments
* 2. Grade Assessments
*
* Therefore, it implements both the publisher interface
* and the Grader interfaces*/
public class Professor implements Publisher, Grader{

    private String name;

    private final Broker broker;

    /* Extracts the Grading Logic to its own interface*/
    private AssessmentGrader grader;


    public Professor(String name, Broker broker, AssessmentGrader grader) {
        this.name = name;
        this.broker = broker;
        this.grader = grader;
    }



    /* Submit the test with an Answer Key*/
    @Override
    public void publishAssessment(Assessment assessment, Map answerKey) {
        System.out.println("Publishing Assessment");
        this.grader.setAnswerKey(answerKey);
        broker.publishAssessment(assessment);
    }

    @Override
    public Broker getBroker(){
        return broker;
    }


    @Override
    public void gradeAssessment(Assessment assessment) {
        System.out.println("Grading Assessment");
        IReport results = grader.gradeAssessment(assessment);
        System.out.println("Publishing Results");
        broker.publishResults(results);
    }

}
