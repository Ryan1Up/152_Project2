package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.IQuestion;
import com.ryan.csci152_2.Report.IReport;

import java.util.Map;

public interface GradingUtil {


    void setAnswerKey(Map<String, Integer> answerKey);

    IReport gradeAssessment(IQuestion questions, String source);

}
