package com.ryan.csci152;

import com.ryan.csci152.Util.classes.GraderUtil;
import com.ryan.csci152.assessments.classes.BasicAssessment;
import com.ryan.csci152.assessments.classes.Question;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;
import com.ryan.csci152.brokers.classes.AssessmentBroker;
import com.ryan.csci152.professors.classes.Professor;
import com.ryan.csci152.students.classes.CSCI152Student;
import com.ryan.csci152.students.classes.Student;

import java.util.HashMap;
import java.util.List;

public class Controller{

    public static void main(String[] args){


        GraderUtil<Integer> graderUtil = new GraderUtil<>();
        HashMap<IQuestion<Integer>, Integer> answerKey = new HashMap<>();

        String question1 = "Question 1?"; Integer answer1 = 1;
        Question<Integer> q1 = new Question<>(question1, answer1);
        answerKey.put(q1, answer1);

        String question2 = "Question 2?"; Integer answer2 = 1;
        Question<Integer> q2 = new Question<>(question2, answer2);
        answerKey.put(q2, answer2);

        String question3 = "Question 3?"; Integer answer3 = 1;
        Question<Integer> q3 = new Question<>(question3, answer3);
        answerKey.put(q3, answer3);

        String question4 = "Question 4?"; Integer answer4 = 1;
        Question<Integer> q4 = new Question<>(question4, answer4);
        answerKey.put(q4, answer4);

        /* Make answer Key */
        graderUtil.setAnswerKey(answerKey);

        Assessment<Integer> newAssessment = new BasicAssessment<>();
        newAssessment.addQuestions(List.of(q1, q2, q3, q4));

        Professor alex
                =   new Professor("Alex",
                    new AssessmentBroker());

        Student ryan = new CSCI152Student("Ryan", alex);

        /* Student subscribe to professor*/
        alex.getBroker().addSubscriber(ryan);

        /* Professor Publishes assignment*/
        alex.publishAssessment(newAssessment, graderUtil);

    }
}