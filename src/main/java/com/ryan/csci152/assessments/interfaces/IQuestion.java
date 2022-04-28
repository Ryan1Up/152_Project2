package com.ryan.csci152.assessments.interfaces;

public interface IQuestion<Value> {

    String getQuestion();

    Value getAnswer();

    void setAnswer(Value answer);
}
