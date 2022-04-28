package com.ryan.csci152.assessments.interfaces;

public interface IQuestion<Key, Value> {

    Key getQuestion();

    Value getAnswer();

    void setAnswer(Value answer);
}
