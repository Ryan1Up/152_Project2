package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.IAssessment;

import java.util.List;
import java.util.Set;

public interface IAssessmentBuilder {

    IAssessment fillAssessmentQuestionsFromList(IAssessment assessment, Set<String> questions);

}
