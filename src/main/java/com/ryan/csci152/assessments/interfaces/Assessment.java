package com.ryan.csci152.assessments.interfaces;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/*
* An Assessment will likely contain multiple values, therefore
* an Assessment style class must implement at minimum that Iterable
* 'iterator()' method, as well as Setting questions and assignee id's
* */
public interface Assessment<Value> extends Iterable<IQuestion<Value>> {

    @Override
    Iterator<IQuestion<Value>> iterator();

    void setAssigneeId(UUID id);

    UUID getAssigneeId();

    /* Add a Singleton IQuestion */
    void addQuestion(IQuestion<Value> question);

    /* Add a IQuestion SET */
    void addQuestions(List<IQuestion<Value>> question);
}
