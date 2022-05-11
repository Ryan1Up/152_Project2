package com.ryan.csci152_2.Assessment;

public interface IQuestionBuilder {

    IQuestionBuilder addQuestion(String question);

    IQuestion build();
}
