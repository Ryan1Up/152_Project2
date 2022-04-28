package com.ryan.csci152.classes;

import com.ryan.csci152.interfaces.IAssessment;
import com.ryan.csci152.interfaces.Party;
import com.ryan.csci152.interfaces.Question;

import java.util.*;

public class Assessment implements IAssessment, Iterable {

    /*In this case, publisher would be 'Alex'*/
    private Party publisher;

    /* Subscriber is the one who has taken the assessment*/
    private Party subscriber;

    private List<Question> questions;

    private Map<Question, Integer> answerKey;

    private Iterator<Question> iterator;

    Assessment(Party publisher, Map<Question, Integer> answerKey){
        this.publisher = publisher;
        this.questions = new ArrayList<>(answerKey.keySet());
        this.answerKey = new HashMap<>(answerKey);
        this.iterator = this.questions.iterator();
    }

    @Override
    public Question nextQuestion() {
        if(iterator().hasNext()){
            return iterator.next();
        }
        return null;
    }

    @Override
    public void notifyPublisher() {
        publisher.updateParty(this);
    }

    @Override
    public void setPublisher(Party publisher) {
        this.publisher = publisher;
    }

    @Override
    public void setSubscriber(Party subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public Iterator iterator() {
        return this.iterator;
    }
}
