package com.ryan.csci152.professors.classes;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.professors.interfaces.Grader;
import com.ryan.csci152.professors.interfaces.Publisher;
import com.ryan.csci152.students.classes.Student;

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
        broker.publishAssessment(assessment);
    }

    @Override
    public void setAssessment(Assessment assessment) {

    }

    @Override
    public void subscribe(Student student) {
        this.broker.addSubscriber(student);
    }


    @Override
    public void gradeAssessment(Assessment assessment) {
        broker.publishResults(grader.gradeAssessment(assessment));
    }

}
