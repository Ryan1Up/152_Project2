package com.ryan.csci152_2.Assessment;

import com.ryan.csci152_2.Professor.Grader;
import com.ryan.csci152_2.Student.Assignee;

import java.util.ArrayList;
import java.util.List;

public class Assessment implements IAssessment{

    private final List<Assignee> roster;
    /**
    *'questions' is a composite data structure that
    * allows a 'SET' of questions by using inner pointers to other questions
    * */
    private IQuestion questions;
    /* Reference to the Object that 'grades' the assignment*/
    private Grader grader;

    public Assessment() {
        this.roster = new ArrayList<>();
        this.questions = null;
        grader = null;
    }

    public Assessment(IQuestion questions){
        this.roster = new ArrayList<>();
        this.questions = questions;
        grader = null;
    }

    public Assessment(List<Assignee> roster, IQuestion questions, Grader grader) {
        this.roster = roster;
        this.questions = questions;
        this.grader = grader;
    }

    /* Assignees (Students) will be notified of this assessment
    * and pass a copy of this to each student*/
    @Override
    public void notifyRoster() {
        for(Assignee a : roster){
            a.notify(this);
        }
    }

    /**
     * As the Questions are expected to be answered by some number
     * of assignees, provide a deep copy of the Questions so each
     * assignee does not get the same 'Question' object, but instead
     * receives their own reference
     *
     * @return IQuestion*/
    @Override
    public IQuestion getQuestions(){
        return questions.clone();
    }

    /* send this assessment to the grader, and
    * for this code, incidentally, is also the publisher*/
    @Override
    public void sendToGrader(String source, IQuestion questions){
        grader.gradeAssessment(questions, source);
    }

    /* Assignees Subscribe themselves to this Assessment,
    * but are only allowed to subscribe once!*/
    @Override
    public void subscribe(Assignee assignee) throws IllegalStateException {
        if(roster.contains(assignee)){
            throw new IllegalStateException("Assignee already subscribed!");
        }
        roster.add(assignee);
    }

    @Override
    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    @Override
    public void setQuestions(IQuestion questions) {
        this.questions = questions;
    }
}
