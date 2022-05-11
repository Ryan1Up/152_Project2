package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.IAssessment;

import java.util.List;

public interface IAssessmentBuilder {

    IAssessment buildAssessmentFromList(List<String> questions);

}
