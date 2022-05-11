package com.ryan.csci152_2.Professor;

import com.ryan.csci152_2.Assessment.IAssessment;
import com.ryan.csci152_2.Assessment.IQuestion;

public interface Grader {

    void gradeAssessment(IQuestion questions, String name);
}
