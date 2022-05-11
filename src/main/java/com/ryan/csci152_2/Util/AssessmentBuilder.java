package com.ryan.csci152_2.Util;

import com.ryan.csci152_2.Assessment.*;

import java.util.List;

public class AssessmentBuilder implements IAssessmentBuilder{

    @Override
    public IAssessment buildAssessmentFromList(List<String> questions) {

        IQuestion question = new Question(null, null);
        IQuestionBuilder builder = question.getBuilder();

        for(String q : questions){
            builder.addQuestion(q);
        }
        question = builder.build();

        return new Assessment(question);
    }
}
