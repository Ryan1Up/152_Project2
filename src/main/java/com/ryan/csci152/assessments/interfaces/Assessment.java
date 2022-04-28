package com.ryan.csci152.assessments.interfaces;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public interface Assessment<Value> extends Iterable<IQuestion<Value>> {

    @Override
    Iterator<IQuestion<Value>> iterator();

    void setAssigneeId(UUID id);

    UUID getAssigneeId();

    void addQuestion(IQuestion<Value> question);

    void addQuestions(List<IQuestion<Value>> question);
}
