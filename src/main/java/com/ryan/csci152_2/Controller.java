package com.ryan.csci152_2;

import com.ryan.csci152_2.Assessment.Assessment;
import com.ryan.csci152_2.Assessment.Question;
import com.ryan.csci152_2.Professor.Professor;
import com.ryan.csci152_2.Student.Student;
import com.ryan.csci152_2.Student.Undergrad;
import com.ryan.csci152_2.Util.AssessmentBuilder;
import com.ryan.csci152_2.Util.AutoGrader;

import java.util.HashMap;
import java.util.Map;

public class Controller {


    public static void main(String[] args){

        Student ryan = new Undergrad("Ryan");
        Professor alex = new Professor(
                new AutoGrader(), new AssessmentBuilder()
        );

        Map<String, Integer> questions = new HashMap<>();
        questions.put("Question 1a.", 1); // question as part of a set
        questions.put("Question 1b.", 3); // question as part of a set
        questions.put("Question 2.", 4);  // question as singleton
        questions.put("Question 3.a.1.", 2);
        questions.put("Question 3.a.2.", 3);
        questions.put("Question 3.b.1.", 1);
        questions.put("Question 3.b.2.", 1);
        questions.put("Question 3.b.3.", 4);

        // 'Professor creates assessments'
        alex.createAssessment(questions, new Assessment(new Question(null, null)));

        // 'Self' subscribe to assessment
        ryan.subscribeToAssessment(alex.getAssessment());

        /* 'Publish' assessment, this starts the flow outlined
        * in the assignment pdf.
        * -> publish
        * -> student receives assessment and completes it
        * -> student returns to professor
        * -> professor grades assessment
        * -> print out report, but this could be changed to return to the student if wanted*/
        alex.publish();
    }
}
