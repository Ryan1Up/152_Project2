package com.ryan.csci152.brokers.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.students.interfaces.Assignee;

public interface Broker {

    void addSubscriber(Assignee subscriber);

    void publishAssessment(Assessment assessment);

    void publishResults(IReport report);

    void dropSubscriber(Assignee subscriber);

}
