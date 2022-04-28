package com.ryan.csci152.professors.interfaces;

import com.ryan.csci152.assessments.interfaces.Assessment;
import com.ryan.csci152.students.classes.Student;

public interface Publisher<Key, Value> {

    void publishAssessment();

    void setAssessment(Assessment<Key, Value> assessment);

    void subscribe(Student student);

}
