package Professor;

import Assessment.IAssessment;
import Assessment.IQuestion;
import Report.IReport;
import Util.GradingUtil;
import Util.IAssessmentBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ProfessorTest {

    @Mock
    private GradingUtil gradingUtil;
    @Mock
    private IAssessmentBuilder assessmentBuilder;
    @Mock
    private IAssessment assessment;
    @Mock
    IQuestion question;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Mock
    IReport report;

    @Captor
    ArgumentCaptor<Professor> professorArgumentCaptor;

    private Professor underTest;
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        MockitoAnnotations.initMocks(this);
        underTest = new Professor(gradingUtil, assessmentBuilder);
    }

    @AfterEach
    void tearDown(){
        System.setOut(originalOut);
    }

    /**
     * The following test tests against the output to System.out
     * In project 1, we skipped testing those classes due to
     * higher difficulty. I implemented them here as a way of
     * pushing myself out of my comfort zone.*/
    @Test
    @Order(4)
    void itShouldGradeAssessment() {
        // Given
        String source = "source";
        String expected = "Success!";
        given(gradingUtil.gradeAssessment(question, source)).willReturn(report);
        given(report.getReportString()).willReturn(expected);
        // When
        underTest.gradeAssessment(question, source);
        // Then
        assertThat(outContent.toString()).isEqualToIgnoringWhitespace(expected);
        verify(gradingUtil).gradeAssessment(question, source);
        verifyNoMoreInteractions(gradingUtil);
    }

    /* This is ordered '2nd' because it 'relies' on the fact that
    *  Profess::createAssessment works correctly*/
    @Test
    @Order(2)
    void itShouldPublish() {
        // Given
        Map<String, Integer> answerKey = Map.of("Question", 1);
        doNothing().when(gradingUtil).setAnswerKey(answerKey);
        doReturn(assessment).when(assessmentBuilder)
                .fillAssessmentQuestionsFromList(assessment, answerKey.keySet());
        doNothing().when(assessment).setGrader(underTest);
        doNothing().when(assessment).notifyRoster();
        underTest.createAssessment(answerKey, assessment);

        // When
        underTest.publish();

        // Then
        verify(assessment, times(1)).notifyRoster();
    }

    /* This test runs first to verify Professor::createAssessment()
    * works correctly, as it is depended on by other tests*/
    @Test
    @Order(1)
    void itShouldCreateAssessment() {
        // Given
        Map<String, Integer> answerKey = Map.of("Question", 1);
        doNothing().when(gradingUtil).setAnswerKey(answerKey);
        doReturn(assessment).when(assessmentBuilder)
                .fillAssessmentQuestionsFromList(assessment, answerKey.keySet());
        doNothing().when(assessment).setGrader(underTest);
        // When
        underTest.createAssessment(answerKey, assessment);
        // Then
        verify(assessmentBuilder)
                .fillAssessmentQuestionsFromList(assessment, answerKey.keySet());
        verify(assessment).setGrader(professorArgumentCaptor.capture());
        assertThat(underTest)
                .usingRecursiveComparison().isEqualTo(professorArgumentCaptor.getValue());
        verify(gradingUtil).setAnswerKey(answerKey);

    }

    @Test
    @Order(3)
    void itShouldGetAssessment() {
        // Given
        Map<String, Integer> answerKey = Map.of("Question", 1);
        doNothing().when(gradingUtil).setAnswerKey(answerKey);
        doReturn(assessment).when(assessmentBuilder)
                .fillAssessmentQuestionsFromList(assessment, answerKey.keySet());
        doNothing().when(assessment).setGrader(underTest);
        doNothing().when(assessment).notifyRoster();
        underTest.createAssessment(answerKey, assessment);

        // When
        IAssessment actual = underTest.getAssessment();
        // Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(assessment);

    }
}