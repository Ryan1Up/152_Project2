package com.ryan.csci152_2.Professor;

import com.ryan.csci152_2.Assessment.IAssessment;
import com.ryan.csci152_2.Student.Assignee;

import java.util.Map;

public interface AssessmentCreator {

    void createAssessment(Map<String, Integer> assessmentQuestionsAndAnswer);

    void registerAssignee(Assignee assignee);

    IAssessment getAssessment();
}
