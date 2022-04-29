package com.ryan.csci152.students.classes;

import com.ryan.csci152.Util.classes.TestTakerUtil;
import com.ryan.csci152.Util.interfaces.TestTaker;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IReport;
import com.ryan.csci152.professors.interfaces.Grader;

import java.util.UUID;

public class CSCI152Student extends Student{

    private Grader grader;
    private Assessment assessment;
    private IReport results;
    private final TestTaker<Integer>  testTaker = new TestTakerUtil<Integer>();

    public CSCI152Student(String name, Grader grader) {
        super.setId(UUID.randomUUID());
        super.setName(name);
        this.grader = grader;
    }

    /* The 'student' gets assigned the assessment*/
    @Override
    public void assign(Assessment assessment) {
        System.out.println(getName() + " getting assignment");
        this.assessment = assessment;
        this.assessment.setAssigneeId(getId());
        this.doAssessment();
    }

    /*Return to the 'professor' for grading*/
    @Override
    public void submit() {
        System.out.println(("Submitting assignment from: %s").formatted(getName()));
        grader.gradeAssessment(this.assessment);
    }

    @Override
    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    /* I didn't program anything to interactively take the test
    * So I made a randomized answering utility*/
    @Override
    public void doAssessment() {
        System.out.println("Assignment in progress");
        testTaker.doAssessment(assessment);
        submit();
    }

    /*'sendResults' is for the broker to understand that the
    * results are being sent to the student*/
    @Override
    public void sendResults(IReport results) {
        this.results = results;

        System.out.println(("Results received for: %s").formatted(getName()));
        System.out.println("Printing out Results...\n");
        System.out.println(results.getDescription());
    }


}
