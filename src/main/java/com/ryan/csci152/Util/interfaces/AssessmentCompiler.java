package com.ryan.csci152.Util.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;

import java.util.List;
import java.util.Map;

public interface AssessmentCompiler<Value> {

    void addQuestion(IQuestion<Value> question);

    void addQuestions(List<IQuestion<Value>> questionList);

    Map<IQuestion<Value>, Value> getAnswerKey();

    Assessment<IQuestion<Value>> getAssessment();

    void reset();

}
