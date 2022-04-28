package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.IReports;
import com.ryan.csci152.interfaces.Party;
import com.ryan.csci152.interfaces.Question;

import java.util.Map;

public class AssessmentReport implements IReports {

    private Integer grade;
    private Party subscriber;

    /*Question contains the submitted answer, Integer is the Correct Answer*/
    private Map<Question, Integer> results;

    public AssessmentReport(Integer grade, Party subscriber, Map<Question, Integer> results) {
        this.grade = grade;
        this.subscriber = subscriber;
        this.results = results;
    }

    @Override
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int getGrade() {
        return this.grade;
    }

    @Override
    public String getReportAsString() {
        String ret = "";
        for(Question q : results.keySet()){
            ret += ("%s: ").formatted(q.getQuestionString()) +
                    ("\nYour Answer: %d,").formatted(q.getAnswer()) +
                    ("\nCorrect Answer: %d").formatted(results.get(q)) +
                    ("\nResult: %s").formatted((results.get(q).equals(q.getAnswer()) ? "Correct" : "Incorrect")) +
                    "\n";
        }
        ret += ("Grade: %d").formatted(this.grade);
        return ret;
    }

    @Override
    public void setResults(Map<Question, Integer> results) {
        this.results = results;
    }

    @Override
    public void setSubscriber(Party subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public Party getSubscriber() {
        return subscriber;
    }
}
