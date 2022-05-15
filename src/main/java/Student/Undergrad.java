package Student;


import Assessment.IAssessment;
import Assessment.IQuestion;

import java.util.Random;

public class Undergrad extends Student{

    public Undergrad(String name){
        super.setName(name);
    }

    @Override
    public void notify(IAssessment assessment) {
        super.setAssessment(assessment);
        super.setQuestions(assessment.getQuestions());
        autoCompleteAssessment();
    }

    private void autoCompleteAssessment(){

        IQuestion q = super.getQuestions();
        if(q == null){
            return;
        }
        Random r = new Random();
        while(true){
            q.answerQuestion(1 + r.nextInt(4));
            if(q.next() == null){
                break;
            }
            q = q.next();
        }
        super.setQuestions(q.getRoot());
        submit();
    }

    @Override
    public void submit() {
        super.getAssessment().sendToGrader(super.getName(), super.getQuestions());
    }

    @Override
    public void subscribeToAssessment(IAssessment assessment) {
        assessment.subscribe(this);
    }
}
