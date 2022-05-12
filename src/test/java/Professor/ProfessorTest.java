package Professor;

import Assessment.IAssessment;
import Assessment.IQuestion;
import Report.IReport;
import Util.GradingUtil;
import Util.IAssessmentBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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

    @Test
    void itShouldPublish() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldCreateAssessment() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldGetAssessment() {
        // Given
        // When
        // Then
    }
}