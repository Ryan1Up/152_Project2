package com.ryan.csci152_2.Student;

import com.ryan.csci152_2.Assessment.IAssessment;

public class Undergrad extends Student{


    public Undergrad(String name){
        super.name = name;
    }

    @Override
    public void notify(IAssessment assessment) {
        super.assessment = assessment;
        //Automatically Do Assessment
    }

    @Override
    public void submit() {
        assessment.sendToGrader(super.name);
    }

    @Override
    void setName(String name) {
        super.name = name;
    }
}
