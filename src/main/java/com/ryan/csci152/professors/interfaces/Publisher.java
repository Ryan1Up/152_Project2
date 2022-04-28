package com.ryan.csci152.professors.interfaces;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.brokers.interfaces.Broker;

/* To work with Brokers, a Publisher sends assessments
* They are also expected to return some type of Broker*/
public interface Publisher {

    void publishAssessment(Assessment assessment, AssessmentGrader grader);

    Broker getBroker();
}
