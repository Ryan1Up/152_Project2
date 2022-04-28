package com.ryan.csci152.assessments.interfaces;

import java.util.Iterator;
import java.util.UUID;

public interface Assessment<Value> extends Iterable<IQuestion<Value>> {

    @Override
    Iterator<IQuestion<Value>> iterator();

    void setAssigneeId(UUID id);

    UUID getAssigneeId();
}
