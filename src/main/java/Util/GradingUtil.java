package Util;


import Assessment.IQuestion;
import Report.IReport;

import java.util.Map;

public interface GradingUtil {


    void setAnswerKey(Map<String, Integer> answerKey);

    IReport gradeAssessment(IQuestion questions, String source);

}
