package com.ryan.csci152_2.Student;

import com.ryan.csci152_2.Assessment.IAssessment;

public class Undergrad extends Student{


    Undergrad(String name){
        super.name = name;
    }

    @Override
    public void notify(IAssessment assessment) {
        super.assessment = assessment;
        //Automatically Do Assessment
    }

    @Override
    public void submit() {
        assessment.returnToSender();
    }

    @Override
    void setName(String name) {
        super.name = name;
    }
}
