package com.ryan.csci152.assessments.classes;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class BasicAssessment<Value> implements Assessment<Value> {

    private List<IQuestion<Value>> questionList;

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
