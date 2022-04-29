package com.ryan.csci152.Util.classes;

import com.ryan.csci152.Util.interfaces.AssessmentCompiler;
import com.ryan.csci152.assessments.classes.BasicAssessment;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssessmentFactory<Value> implements AssessmentCompiler<Value> {

    private List<IQuestion> questions;

    public AssessmentFactory(){
        this.questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(IQuestion<Value> question) {
        if(!this.questions.contains(question)){
            this.questions.add(question);
        }
    }

    @Override
    public void addQuestions(List<IQuestion<Value>> iQuestions) {
        for(IQuestion<Value> q : iQuestions){
            addQuestion(q);
        }
    }

    @Override
    public Map<IQuestion<Value>, Value> getAnswerKey() {
        HashMap<IQuestion<Value>, Value> answerKey = new HashMap<>();

        for(IQuestion<Value> q : questions){
            answerKey.put(q, q.getAnswer());
        }
        return answerKey;
    }

    @Override
    public Assessment getAssessment() {
        BasicAssessment assessment = new BasicAssessment();
        assessment.addQuestions(questions);

        return assessment;
    }

    @Override
    public void reset() {
        this.questions = new ArrayList<>();
    }
}
