package com.ryan.csci152_2.Assessment;

/**
 * IQuestion extends the Cloneable interface.
 * An IQuestion is assumed to store a String Query
 * that represents a 'Test Question', and stores
 * an 'Answer'.
 *
 * A class that implements this interface should also
 * do 2 other things. 1 Provide a Builder, 2. Provide a deep
 * clone of the IQuestion Object.*/
public interface IQuestion extends Cloneable {

    String getQuestion();

    void answerQuestion(Integer answer) throws IllegalStateException;

    Integer getAnswer() throws IllegalStateException;

    IQuestion next();

    IQuestion prev();

    IQuestion getRoot();

    IQuestionBuilder getBuilder();

    IQuestion clone();
}
