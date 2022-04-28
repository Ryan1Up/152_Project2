package com.ryan.csci152.professors.classes;

import com.ryan.csci152.Util.classes.GraderUtil;
import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.professors.interfaces.Grader;
import com.ryan.csci152.professors.interfaces.Publisher;

public class Professor implements Publisher, Grader{

    private String name;

    private final Broker broker;

    private AssessmentGrader grader;


    public Professor(String name, Broker broker) {
        this.name = name;
        this.broker = broker;
    }



    @Override
    public void publishAssessment(Assessment assessment, AssessmentGrader grader) {
        System.out.println("Publishing Assessment");
        this.grader = grader;
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
