package com.ryan.csci152.Util.classes;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.classes.Report;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;
import com.ryan.csci152.assessments.interfaces.IReport;

import java.util.HashMap;
import java.util.Map;


public class GraderUtil<Key, Value> implements AssessmentGrader<Key, Value> {

    Map<Key, Value> answerKey;

    @Override
    public IReport gradeAssessment(Assessment assessment) {
        Integer total = 0;
        String desc = "";
        for(Key q : answerKey.keySet()) {
            IQuestion<Key, Value> question = assessment.getQuestion(q);
            if (answerKey.get(q).equals(question.getAnswer())) {
                total++;
            }
            desc += stringifyDesc(question, q);
        }
        desc += ("Total: %d/%d").formatted(total, answerKey.keySet().size());

        return new Report(total, desc);
    }

    private String stringifyDesc(IQuestion question, Key key){
        return ("%s").formatted(question.getQuestion()) +
                ("\nYour Answer: %s").formatted(question.getAnswer()) +
                ("\nCorrect Answer %s").formatted(answerKey.get(key)) +
                ("\nResult: %s")
                        .formatted((answerKey.get(key).equals(question.getAnswer())) ? "Correct" : "Incorrect") +
                "\n";
    }
    @Override
    public void setAnswerKey(Map<Key, Value> answerKey) {
        this.answerKey = new HashMap<>(answerKey);
    }
}
