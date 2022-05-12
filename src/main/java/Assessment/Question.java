package Assessment;

import java.util.ArrayList;
import java.util.List;

/**
 * The Question class represents a composite data structure
 * loosely based on a Doubly Linked list. Each Question
 * has a reference to a 'next' Question and a 'prev'
 * (previous) Question. Each Question contains an Answer
 * and a String representation of the Query itself.
 *
 * A Builder is provided by this class to make implementation
 * simpler. Question also supplies a Deep Copy through it's
 * clone() method.
 * */
public class Question implements IQuestion{

    private final String question;
    private Integer answer;

    /* Due to IQuestion interface, each question should have both a prev, and next
    * therefore these are both IQuestions, though it would be legal to declare them
    * as Question, this declaration is purely for clarity*/
    private final IQuestion prev;
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
        return question;
    }

    @Override
    public void answerQuestion(Integer answer) {
        if(answer < 0 || answer > 4){
            throw new IllegalStateException("Answer out of bounds!");
        }
        this.answer = answer;
    }

    @Override
    public Integer getAnswer() throws IllegalStateException {
        if (answer != null){
            return answer;
        }
        throw new IllegalStateException("No answer defined!");
    }

    @Override
    public IQuestion next() {
        return this.next;
    }

    @Override
    public IQuestion prev() {
        return this.prev;
    }

    @Override
    public IQuestion getRoot() {
        IQuestion current = this;
        while(current.prev() != null){
            current = current.prev();
        }

        return current;
    }

    @Override
    public IQuestionBuilder getBuilder() {
        return new QuestionBuilder();
    }

    private static class QuestionBuilder implements IQuestionBuilder{

        private Question root;
        private Question current;

        public QuestionBuilder(){
            root = null;
            current = null;
        }

        /**
         * Returns a reference to Itself after updating its 'current' node's
         * 'next' value, and iterating 'current' to it's 'next' value*/
        @Override
        public IQuestionBuilder addQuestion(String question){
            if(root == null){
                root = new Question(question);
                current = root;
            }
            else{
                current.next = new Question(question, current);
                current = (Question) current.next;
            }
            return this;
        }

        @Override
        public IQuestion build() {
            return root;
        }
    }


    /**
     * clone will return a 'deep' copy of the IQuestion
     * This ensures that whatever clone is assigned answers
     * will not interfere with the original
     *
     * @return IQuestion*/
    @Override
    public IQuestion clone() {
        IQuestion root = this;
        List<String> questions = new ArrayList<>();
        while(root != null){
            questions.add(root.getQuestion());
            root = root.next();
        }

        IQuestionBuilder builder = new QuestionBuilder();
        questions.forEach(builder::addQuestion);

        return builder.build();
    }
}
