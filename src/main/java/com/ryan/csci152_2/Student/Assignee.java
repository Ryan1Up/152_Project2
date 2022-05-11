package com.ryan.csci152_2.Student;

import com.ryan.csci152_2.Assessment.IAssessment;

public interface Assignee {

    void notify(IAssessment assessment);

    void submit();
}
