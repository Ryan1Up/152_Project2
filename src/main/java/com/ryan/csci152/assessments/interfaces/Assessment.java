package com.ryan.csci152.assessments.interfaces;

public interface Assessment<Key> {

    IQuestion getQuestion(Key question);

}
