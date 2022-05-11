package com.ryan.csci152_2.Assessment;


import com.ryan.csci152_2.Professor.Grader;
import com.ryan.csci152_2.Student.Assignee;

public interface IAssessment {

    void notifyRoster();

    void returnToSender();

    void subscribe(Assignee assignee);

    void setGrader(Grader grader);

    void setQuestions(IQuestion questions);
}
