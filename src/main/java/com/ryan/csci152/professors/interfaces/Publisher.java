package com.ryan.csci152.professors.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.brokers.interfaces.Broker;
import com.ryan.csci152.students.classes.Student;

public interface Publisher<Value> {

    void publishAssessment();

    void setAssessment(Assessment<Value> assessment);

//    void subscribe(Student student);

    Broker getBroker();
}
