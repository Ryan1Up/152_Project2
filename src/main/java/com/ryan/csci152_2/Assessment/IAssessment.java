package com.ryan.csci152_2.Assessment;


import com.ryan.csci152_2.Professor.Grader;
import com.ryan.csci152_2.Student.Assignee;

public interface IAssessment {

    void notifyRoster();

    IQuestion getQuestions();

    void sendToGrader(String source, IQuestion answers);

    void subscribe(Assignee assignee) throws IllegalStateException;

    void setGrader(Grader grader);

    void setQuestions(IQuestion questions);
}
