package Student;

import Assessment.IAssessment;
import Assessment.IQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class UndergradTest {

    @Mock
    private IAssessment assessment;
    @Mock
    private IQuestion question;

    private Undergrad underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void itShouldSetAndGetName() {
        // Given
        String origName = "origName";
        String setName = "setName";
        //Constructs with name
        underTest = new Undergrad(origName);

        //Verify original
        assertEquals(origName, underTest.getName());

        // When
        underTest.setName(setName);

        // Then
        String actual = underTest.getName();
        assertEquals(setName, actual);
        assertNotEquals(origName, actual);
    }


    @Test
    void itShouldSetAndGetAssessment() {
        // Given
        underTest = new Undergrad("SomeName");
        //Verify assessment is null
        assertNull(underTest.getAssessment());

        // When
        underTest.setAssessment(assessment);

        // Then
        IAssessment actual = underTest.getAssessment();
        assertEquals(assessment, actual);
    }

    @Test
    void itShouldSetAndGetQuestions() {
        // Given
        underTest = new Undergrad("SomeName");
        //Verify questions are null
        assertNull(underTest.getQuestions());

        // When
        underTest.setQuestions(question);

        // Then
        IQuestion actual = underTest.getQuestions();
        assertEquals(question, actual);
    }


    @Test
    void itShouldTestNotify() {
        // Given
        underTest = new Undergrad("SomeName");
        given(assessment.getQuestions()).willReturn(question);

        // Due to autocomplete nature of this assignment, the following
        // normally wouldn't apply, but is necessary here
        // This will also cause a few lines to be skipped because I am not
        // testing the auto-taker function
        doNothing().when(question).answerQuestion(any());
        doReturn(null).when(question).next();
        doNothing().when(assessment).sendToGrader(any(), any());
        doReturn(question).when(question).getRoot();

        // When
        underTest.notify(assessment);
        // Then
        verify(assessment, times(1)).getQuestions();
        assertEquals(assessment, underTest.getAssessment());
        assertEquals(question, underTest.getQuestions());
    }

    @Test
    void itShouldSubmit() {
        // Given
        String name = "SomeName";
        underTest = new Undergrad(name);
        underTest.setAssessment(assessment);
        underTest.setQuestions(question);
        doNothing().when(assessment).sendToGrader(name, question);

        // When
        underTest.submit();
        // Then

        verify(assessment, times(1)).sendToGrader(name, question);
    }

    @Test
    void itShouldSubscribeToAssessment() {
        // Given
        underTest = new Undergrad("SomeName");
        doNothing().when(assessment).subscribe(underTest);
        // When
        underTest.subscribeToAssessment(assessment);
        // Then
        verify(assessment,times(1)).subscribe(underTest);
        verifyNoMoreInteractions(assessment);
    }
}