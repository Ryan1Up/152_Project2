package com.ryan.csci152_2.Report;

import com.ryan.csci152_2.Assessment.IQuestion;


import java.util.Map;

public class Report implements IReport{

    private String reportString;
    private Integer score;
    private String source;

    public String getReportString() {
        return reportString;
    }

    public Integer getScore() {
        return score;
    }

    public String getSource() {
        return source;
    }

    @Override
    public IReport buildReport(Map<String, Integer> answerKey, IQuestion questions, String source) {
        this.source = source;
        StringBuilder report = new StringBuilder("Name: " + source);
        int score = 0;
        while(questions != null){
            try{
                String q = questions.getQuestion();
                report.append(q).append("\n");

                Integer a = questions.getAnswer();
                report.append("Answer:").append(a);

                if(answerKey.get(q).equals(a)){
                    report.append("\nCorrect!");
                    score++;
                }
                else {
                    report.append("\nIncorrect!")
                            .append("\nCorrect Answer: ")
                            .append(answerKey.get(q));
                }
                report.append("\n");
            }catch(IllegalStateException e){
                report.append("Question not answered...\n");
            }
            questions = questions.next();
        }

        this.score = score;
        this.reportString = report.toString();

        return this;
    }

}
