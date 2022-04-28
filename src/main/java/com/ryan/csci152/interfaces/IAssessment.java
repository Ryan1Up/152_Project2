package com.ryan.csci152.interfaces;

public interface IAssessment {

    Question nextQuestion();

    void notifyPublisher();

    void setPublisher(Party publisher);

    void setSubscriber(Party subscriber);

}
