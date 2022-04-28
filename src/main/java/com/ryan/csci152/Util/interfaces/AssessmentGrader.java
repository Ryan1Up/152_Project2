package com.ryan.csci152.Util.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;

import java.util.Map;

public interface AssessmentGrader<Key, Value> {

    IReport gradeAssessment(Assessment assessment);

    void setAnswerKey(Map<Key, Value> answerKey);

}
