package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.IQuestion;

import java.util.Map;

public interface GradingUtil {

    /* This applies an Answer Key and prints out the results */
    void gradeAssessment(IQuestion questions, Map<String, Integer> answerKey);

}
