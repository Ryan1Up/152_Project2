package com.ryan.csci152.Util.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;

public interface TestTaker<Value>{

    void doAssessment(Assessment<Value> assessment);
}
