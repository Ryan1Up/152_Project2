package Util;

import Assessment.IAssessment;

import java.util.Set;

public interface IAssessmentBuilder {

    IAssessment fillAssessmentQuestionsFromList(IAssessment assessment, Set<String> questions);

}
