package Util;

import Assessment.IQuestion;
import Report.IReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class AutoGraderTest {

    @Spy
    AutoGrader underTest = new AutoGrader();

    @Mock
    IQuestion question;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = spy(underTest);
    }


    @Test
    void itShouldGradeAssessment() {
        // Given
        String source = "someSource";
        String questionString = "Question";
        Map<String, Integer> answerKey = new HashMap<>();
        answerKey.put(questionString, 1);
        given(question.getAnswer()).willReturn(1);
        given(question.getQuestion()).willReturn(questionString);
        underTest.setAnswerKey(answerKey);
        // When
        IReport result = underTest.gradeAssessment(question, source);
        // Then
        assertEquals(source, result.getSource());
        assertEquals(1, result.getScore());
    }
}