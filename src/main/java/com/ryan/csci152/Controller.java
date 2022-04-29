package com.ryan.csci152;

import com.ryan.csci152.Util.classes.AssessmentFactory;
import com.ryan.csci152.Util.classes.GraderUtil;
import com.ryan.csci152.Util.interfaces.AssessmentCompiler;
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

        AssessmentCompiler<Integer> factory = new AssessmentFactory<>();
        String question1 = "Question 1?"; Integer answer1 = 1;
        String question2 = "Question 2?"; Integer answer2 = 1;
        String question3 = "Question 3?"; Integer answer3 = 1;
        String question4 = "Question 4?"; Integer answer4 = 1;
        factory.addQuestions(
                List.of(
                        new Question<>(question1, answer1),
                        new Question<>(question2, answer2),
                        new Question<>(question3, answer3),
                        new Question<>(question4, answer4)
                )
        );


        /* Make answer Key */
        graderUtil.setAnswerKey(factory.getAnswerKey());

        Assessment<IQuestion<Integer>> newAssessment = factory.getAssessment();

        Professor alex
                =   new Professor("Alex",
                    new AssessmentBroker());

        Student ryan = new CSCI152Student("Ryan", alex);
        Student marc = new CSCI152Student("Marc", alex);
        /* Student subscribe to professor*/
        alex.getBroker().addSubscriber(ryan);
        alex.getBroker().addSubscriber(marc);
        /* Professor Publishes assignment*/
        alex.publishAssessment(newAssessment, graderUtil);

        alex.getBroker().dropSubscriber(ryan);
        factory.reset();

        String question5 = "Question 5?"; Integer answer5 = 1;
        String question6 = "Question 6?"; Integer answer6 = 4;
        String question7 = "Question 7?"; Integer answer7 = 3;
        String question8 = "Question 8?"; Integer answer8 = 2;
        factory.addQuestions(
                List.of(
                        new Question<>(question5, answer5),
                        new Question<>(question6, answer6),
                        new Question<>(question7, answer7),
                        new Question<>(question8, answer8)
                )
        );

        newAssessment = factory.getAssessment();

        graderUtil.setAnswerKey(factory.getAnswerKey());

        alex.publishAssessment(newAssessment, graderUtil);

    }
}