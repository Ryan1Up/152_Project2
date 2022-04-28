package com.ryan.csci152.brokers.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.professors.interfaces.Grader;

public interface InverseBroker {

    void setSubscriber(Grader grader);

    void submitAssessment(Assessment assessment);


}
