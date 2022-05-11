package com.ryan.csci152_2.Report;

import com.ryan.csci152_2.Assessment.IQuestion;

import java.util.Map;

public class ReportBuilder{

    public static IReport buildReport(Map<String, Integer> answerKey, IQuestion questions, String source) {
        StringBuilder report = new StringBuilder("Name: " + source);
        int score = 0;
        while (questions != null) {
            try {
                String q = questions.getQuestion();
                report.append(q).append("\n");

                Integer a = questions.getAnswer();
                report.append("Answer:").append(a);

                if (answerKey.get(q).equals(a)) {
                    report.append("\nCorrect!");
                    score++;
                } else {
                    report.append("\nIncorrect!")
                            .append("\nCorrect Answer: ")
                            .append(answerKey.get(q));
                }
                report.append("\n");
            } catch (IllegalStateException e) {
                report.append("Question not answered...\n");
            }
            questions = questions.next();
        }

        return new Report(report.toString(), score, source);
    }
}