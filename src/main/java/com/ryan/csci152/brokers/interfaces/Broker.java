package com.ryan.csci152.brokers.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.students.classes.Student;

public interface Broker {

    void addSubscriber(Student subscriber);

    void publishAssessment(Assessment assessment);

    void publishResults(IReport report);

    void dropSubscriber(Student subscriber);

}
