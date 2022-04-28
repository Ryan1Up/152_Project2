package com.ryan.csci152;

import com.ryan.csci152.Util.classes.GraderUtil;
import com.ryan.csci152.brokers.classes.AssessmentBroker;
import com.ryan.csci152.professors.classes.Professor;

public class Controller{

    public static void main(String[] args){

        Professor alex
                = new Professor("Alex",
                new AssessmentBroker(),
                new GraderUtil<>());


    }
}