package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Question;

public class AssessmentQuestion implements Question {


    private Integer answer;
    public String question;

    public AssessmentQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String getQuestionString() {
        return getQuestion();
    }

    @Override
    public void setAnswer(int answer) {
        if(!(answer > 0) || !(answer < 6)){
            throw new IllegalStateException("Answer out of Bounds! Expecting 1 .. 5 ONLY");
        }
        this.answer = answer;

    }

    @Override
    public int getAnswer() {
        if(this.answer != null){
            return answer;
        }
        return -1;
    }
}
