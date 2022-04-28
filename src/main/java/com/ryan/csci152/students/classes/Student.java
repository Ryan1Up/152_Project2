package com.ryan.csci152.students.classes;

import com.ryan.csci152.students.interfaces.Assignee;

import java.util.UUID;

public abstract class Student implements Assignee{
    private String name;
    private UUID id;

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
