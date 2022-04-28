package com.ryan.csci152.interfaces;

public interface Broker {

    void publish(IAssessment assessment);

    void publish(IReports report);

    void subscribe(Party party);


}
