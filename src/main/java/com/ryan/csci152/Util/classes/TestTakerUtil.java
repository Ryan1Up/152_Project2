package com.ryan.csci152.Util.classes;

import com.ryan.csci152.Util.interfaces.TestTaker;
import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.assessments.interfaces.IQuestion;

import java.util.Random;

public class TestTakerUtil<Value> implements TestTaker<Value> {

    @Override
    public void doAssessment(Assessment<Value> assessment) {
        Random r = new Random();

        for (IQuestion<Value> keyValueIQuestion : assessment) {
            keyValueIQuestion.setAnswer((Value) Integer.valueOf(r.nextInt(4) + 1));
        }
    }

}
