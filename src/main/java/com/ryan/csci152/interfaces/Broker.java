package com.ryan.csci152.interfaces;

import com.ryan.csci152.classes.StudentBase;

public interface Broker {

    void publish(IAssessment assessment);

    void publish(IReports report);

    void subscribe(StudentBase party);

}
