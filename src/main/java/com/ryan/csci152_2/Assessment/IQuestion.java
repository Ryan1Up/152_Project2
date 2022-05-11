package com.ryan.csci152_2.Assessment;

public interface IQuestion extends Cloneable{

    String getQuestion();

    void answerQuestion(Integer answer) throws IllegalStateException;

    Integer getAnswer() throws IllegalStateException;

    IQuestion next();

    IQuestion prev();

    IQuestionBuilder getBuilder();
}
