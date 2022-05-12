package Report;


import Assessment.IQuestion;

import java.util.Map;

public class ReportBuilder{


    public static IReport buildReport(Map<String, Integer> answerKey, IQuestion questions, String source) {
        StringBuilder report = new StringBuilder("Name: " + source + "\n");
        int score = 0;
        while (true) {
            try {
                String q = questions.getQuestion();
                report.append(q);

                Integer a = questions.getAnswer();
                report.append("\nAnswer: ").append(a);

                if (answerKey.get(q).equals(a)) {
                    report.append(" - Correct!");
                    score++;
                } else {
                    report.append(" - Incorrect!")
                            .append("\nCorrect Answer: ")
                            .append(answerKey.get(q));
                }
                report.append("\n");
            } catch (IllegalStateException e) {
                report.append(" not answered...\n");
            }
            if(questions.next() == null){
                break;
            }
            questions = questions.next();
        }

        report.append("\nTotal Score: ").append(score);

        return new Report(report.toString(), score, source);
    }
}
