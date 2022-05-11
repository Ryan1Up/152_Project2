package com.ryan.csci152_2.Student;

import com.ryan.csci152_2.Assessment.IAssessment;
import com.ryan.csci152_2.Assessment.IQuestion;

public class Undergrad extends Student{

    public Undergrad(String name){
        super.setName(name);
    }

    @Override
    public void notify(IAssessment assessment) {
        super.setAssessment(assessment);
        super.setQuestions(assessment.getQuestions());
    }

    private void autoCompleteAssessment(){

        IQuestion q = super.getQuestions();
        while(q != null){

        }
    }

    @Override
    public void submit() {
        super.getAssessment().sendToGrader(super.getName(), super.getQuestions());
    }
}
