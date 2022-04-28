package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.Broker;
import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.Party;
import com.ryan.csci152.interfaces.Question;

import java.util.Map;

public class Alex implements Party {

    private String name;
    private Broker roster;

    private Map<Question, Integer> answerKey;

    Alex(String name, Broker roster){
        this.name = name;
        this.roster = roster;
    }

    public void addQuestion(String question, Integer correctAnswer){
        answerKey.put(new AssessmentQuestion(question), correctAnswer);
    }

    public void addQuestionSet(Map<String, Integer> questionSet){
        for(String q : questionSet.keySet()){
            answerKey.put(new AssessmentQuestion(q), questionSet.get(q));
        }
    }
    /*Update party of assessment completion*/
    @Override
    public void updateParty(IAssessment assessment) {
        /*Grade assignment, then publish results*/
        StudentBase
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private void gradeAssessment(IAssessment assessment){

    }




}
