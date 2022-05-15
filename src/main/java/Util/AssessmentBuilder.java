package Util;

import Assessment.IAssessment;
import Assessment.IQuestionBuilder;

import java.util.Set;

public class AssessmentBuilder implements IAssessmentBuilder{

    @Override
    public IAssessment fillAssessmentQuestionsFromList(IAssessment blankAssessment, Set<String> questions) {

        IQuestionBuilder builder = blankAssessment.getQuestionBuilder();

        for(String q : questions){
            builder.addQuestion(q);
        }

        blankAssessment.setQuestions(builder.build());
        return blankAssessment;
    }
}
