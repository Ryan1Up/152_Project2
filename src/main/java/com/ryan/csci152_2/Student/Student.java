package com.ryan.csci152_2.Student;


import com.ryan.csci152_2.Assessment.IAssessment;

public abstract class Student implements Assignee{

    String name;
    IAssessment assessment;

    abstract void setName(String name);

}
