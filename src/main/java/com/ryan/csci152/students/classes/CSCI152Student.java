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

    @Override
    public void assign(Assessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public void submit() {
        grader.gradeAssessment(this.assessment);
    }

    @Override
    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    @Override
    public void doAssessment() {
        testTaker.doAssessment(assessment);
        submit();
    }

    @Override
    public void sendResults(IReport results) {
        this.results = results;
        System.out.println(results.getDescription());
    }


}
