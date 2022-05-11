package com.ryan.csci152_2.Assessment;

public class Question implements IQuestion{

    private String question;
    private Integer answer;
    private IQuestion prev;
    private IQuestion next;

    Question(String question){
        this.question = question;
        this.prev = null;
        this.next = null;
    }

    public Question(String question, IQuestion prev) {
        this.question = question;
        this.prev = prev;
    }

    public Question(String question, IQuestion prev, IQuestion next) {
        this.question = question;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String getQuestion() {
        return null;
    }

    @Override
    public void answerQuestion(Integer answer) {

    }

    @Override
    public Integer getAnswer() {
        return null;
    }

    @Override
    public IQuestion next() {
        return null;
    }

    @Override
    public IQuestion prev() {
        return null;
    }

    @Override
    public QuestionBuilder getBuilder() {
        return null;
    }

    public static class QuestionBuilder implements IQuestionBuilder{

        private Question root;
        private Question current;

        QuestionBuilder(){
            root = null;
            current = null;
        }

        @Override
        public QuestionBuilder addQuestion(String question){
            if(root == null){
                root = new Question(question);
                current = root;
            }else{
                current.next = new Question(question, current);
                current = (Question) current.next();
            }
            return this;
        }

        @Override
        public IQuestion build() {
            return root;
        }


    }
}
