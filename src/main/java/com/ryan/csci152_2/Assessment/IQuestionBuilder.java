package com.ryan.csci152_2.Assessment;

public interface IQuestionBuilder {

    Question.QuestionBuilder addQuestion(String question);

    IQuestion build();
}
