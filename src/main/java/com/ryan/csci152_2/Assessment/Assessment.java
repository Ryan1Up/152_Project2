package com.ryan.csci152_2.Assessment;

import com.ryan.csci152_2.Professor.Grader;
import com.ryan.csci152_2.Student.Assignee;

import java.util.ArrayList;
import java.util.List;

public class Assessment implements IAssessment{

    List<Assignee> roster;
    IQuestion questions;

    public Assessment() {
        this.roster = new ArrayList<>();
        this.questions = null;
    }

    Assessment(IQuestion questions){
        this.roster = new ArrayList<>();
        this.questions = questions;
    }

    @Override
    public void notifyRoster() {

    }

    @Override
    public void returnToSender() {

    }

    @Override
    public void subscribe(Assignee assignee) {

    }

    @Override
    public void setGrader(Grader grader) {

    }

    @Override
    public void setQuestions(IQuestion questions) {
        this.questions = questions;
    }
}
