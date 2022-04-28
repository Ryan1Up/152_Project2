package com.ryan.csci152.assessments.classes;

import com.ryan.csci152.assessments.interfaces.IQuestion;

public class Question<Value> implements IQuestion<Value> {

    String question;
    Value answer;

    public Question(String question, Value answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public Value getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(Value answer) {
        this.answer = answer;
    }
}
