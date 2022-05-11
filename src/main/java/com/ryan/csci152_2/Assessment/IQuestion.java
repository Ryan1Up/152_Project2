package com.ryan.csci152_2.Assessment;

public interface IQuestion {

    String getQuestion();

    void answerQuestion(Integer answer);

    Integer getAnswer();

    IQuestion next();

    IQuestion prev();

    Question.QuestionBuilder getBuilder();
}
