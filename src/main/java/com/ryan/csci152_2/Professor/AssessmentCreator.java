package com.ryan.csci152_2.Professor;

import com.ryan.csci152_2.Assessment.IAssessment;

import java.util.Map;

public interface AssessmentCreator {

    void createAssessment(Map<String, Integer> assessmentQuestionsAndAnswer, IAssessment blankAssessment);

    IAssessment getAssessment();
}
