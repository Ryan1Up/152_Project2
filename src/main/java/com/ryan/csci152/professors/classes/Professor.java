package com.ryan.csci152.professors.classes;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.professors.interfaces.Grader;
import com.ryan.csci152.professors.interfaces.Publisher;

public class Professor implements Publisher, Grader{

    private String name;

    private final Broker broker;

    private Assessment assessment;

    private final AssessmentGrader grader;


    public Professor(String name, Broker broker, AssessmentGrader grader) {
        this.name = name;
        this.broker = broker;
        this.grader = grader;
    }

    @Override
    public void publishAssessment() {
        System.out.println("Publishing Assessment");
        broker.publishAssessment(assessment);
    }

    @Override
    public void setAssessment(Assessment assessment) {
        System.out.println("Setting Assessment");
        this.assessment = assessment;
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
