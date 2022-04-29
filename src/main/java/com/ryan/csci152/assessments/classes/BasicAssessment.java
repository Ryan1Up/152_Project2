package com.ryan.csci152.assessments.classes;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class BasicAssessment<Value> implements Assessment<Value> {

    /*Not doing a tree structure, I personally feel that a bit too much
    * for a 'small' project assigned right on top the term project
    *
    * My general approach to a tree structured SET of Question
    * objects would have been to flatten it. I'm skipping that step
    * and going directly to the end result*/
    private final List<IQuestion<Value>> questionList;

    private UUID assigneeId;

    public BasicAssessment(){
        questionList = new ArrayList<>();
    }

    public void addQuestion(IQuestion<Value> question){
        if(!questionList.contains(question)){
            questionList.add(question);
        }
    }

    public void addQuestions(List<IQuestion<Value>> questionList){
        for(IQuestion q : questionList){
            if(!this.questionList.contains(q)){
                this.questionList.add(q);
            }
        }
    }
    @Override
    public Iterator<IQuestion<Value>> iterator() {
        return questionList.iterator();
    }

    @Override
    public void setAssigneeId(UUID id) {
        this.assigneeId = id;
    }

    @Override
    public UUID getAssigneeId() {
        return assigneeId;
    }
}
