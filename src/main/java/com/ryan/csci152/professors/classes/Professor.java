package com.ryan.csci152.professors.classes;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.professors.interfaces.Grader;
import com.ryan.csci152.professors.interfaces.Publisher;

public class Professor<Key, Value> implements Publisher, Grader {

    private String name;

    private final Broker broker;

    private Assessment assessment;

    private AssessmentGrader<Key, Value> grader;

    public Professor(String name, Broker broker, AssessmentGrader<Key, Value> grader) {
        this.name = name;
        this.broker = broker;
        this.grader = grader;
    }

    @Override
    public void publishAssessment() {
        broker.publishAssessment(assessment);
    }

    @Override
    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }


    @Override
    public void gradeAssessment(Assessment assessment) {
        broker.publishResults(grader.gradeAssessment(assessment));
    }
}
