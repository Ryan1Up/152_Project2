package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.*;

import java.util.Set;

public class AssessmentBuilder implements IAssessmentBuilder{

    @Override
    public IAssessment buildAssessmentFromList(Set<String> questions) {

        IQuestion question = new Question(null, null);
        IQuestionBuilder builder = question.getBuilder();

        for(String q : questions){
            builder.addQuestion(q);
        }
        question = builder.build();

        return new Assessment(question);
    }
}
