package com.ryan.csci152.Util.classes;

import com.ryan.csci152.Util.interfaces.AssessmentGrader;
import com.ryan.csci152.assessments.classes.Report;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;
import com.ryan.csci152.assessments.interfaces.IReport;

import java.util.HashMap;
import java.util.Map;


public class GraderUtil<Value> implements AssessmentGrader<Value> {

    Map<IQuestion<Value>, Value> answerKey;

    @Override
    public IReport gradeAssessment(Assessment<Value> assessment) {
        Integer total = 0;
        StringBuilder desc = new StringBuilder();
        for(IQuestion<Value> q : answerKey.keySet()) {

            if (answerKey.get(q).equals(q.getAnswer())) {
                total++;
            }
            desc.append(stringifyDesc(q));
        }
        desc.append(("Total: %d/%d\n").formatted(total, answerKey.keySet().size()));

        return new Report(total, desc.toString(), assessment.getAssigneeId());
    }

    private String stringifyDesc(IQuestion<Value> question){
        return ("%s").formatted(question.getQuestion()) +
                ("\nYour Answer: %s").formatted(question.getAnswer()) +
                ("\nCorrect Answer %s").formatted(answerKey.get(question)) +
                ("\nResult: %s")
                        .formatted((answerKey.get(question).equals(question.getAnswer())) ? "Correct" : "Incorrect") +
                "\n";
    }
    @Override
    public void setAnswerKey(Map<IQuestion<Value>, Value> answerKey) {
        this.answerKey = new HashMap<>(answerKey);
    }
}
