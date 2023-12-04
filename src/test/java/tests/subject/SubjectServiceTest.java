package tests.subject;
import org.example.neptunClone.model.Subject;
import org.example.neptunClone.repository.SubjectRepositoryInterface;
import org.example.neptunClone.service.impl.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {
    @Mock
    private SubjectService subjectService;
    @Mock
    private SubjectRepositoryInterface subjectRepositoryInterface;
    private Subject subject;

    @BeforeEach
    void setUp() {
        subjectRepositoryInterface = mock(SubjectRepositoryInterface.class);
        subjectService = new SubjectService(subjectRepositoryInterface);
        subject = new Subject(1, "Matek");
    }

    @Test
    void addSubject_ValidSubject_ReturnsTrue() throws SQLException {
        when(subjectRepositoryInterface.insertSubject(subject)).thenReturn(true);
        boolean result = subjectService.addSubject(subject);
        assertTrue(result);
    }

    @Test
    void addSubject_InvalidSubject_ReturnsFalse() throws SQLException {
        when(subjectRepositoryInterface.insertSubject(subject)).thenReturn(false);
        boolean result = subjectService.addSubject(subject);
        assertFalse(result);
    }

    @Test
    void updateSubject_ValidSubject_ReturnsTrue() {
        when(subjectRepositoryInterface.updateSubject(subject)).thenReturn(true);
        boolean result = subjectService.updateSubject(subject);
        assertTrue(result);
    }

    @Test
    void updateSubject_InvalidSubject_ReturnsFalse() {
        when(subjectRepositoryInterface.updateSubject(subject)).thenReturn(false);
        boolean result = subjectService.updateSubject(subject);
        assertFalse(result);
    }

    @Test
    void getAllSubject_ReturnsListOfSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        when(subjectRepositoryInterface.getSubject()).thenReturn(subjects);
        List<Subject> result = subjectService.getAllSubject();
        assertEquals(subjects, result);
    }

    @Test
    void getSubjectById_ReturnsValidSubject() throws SQLException {
        when(subjectRepositoryInterface.getSubjectById(1)).thenReturn(subject);
        Subject result = subjectService.getSubjectById(1);
        assertEquals(subject, result);
    }

    @Test
    void getSubjectByName_ReturnsValidSubject() throws SQLException {
        when(subjectRepositoryInterface.getSubjectByName("Matek")).thenReturn(subject);
        Subject result = subjectService.getSubjectByName("Matek");
        assertEquals(subject, result);
    }

    @Test
    void deleteSubject_ValidId_ReturnsTrue() throws SQLException {
        when(subjectRepositoryInterface.deleteSubject(1)).thenReturn(true);
        boolean result = subjectService.deleteSubject(1);
        assertTrue(result);
    }

    @Test
    void deleteSubject_InvalidId_ReturnsFalse() throws SQLException {
        when(subjectRepositoryInterface.deleteSubject(1)).thenReturn(false);
        boolean result = subjectService.deleteSubject(1);
        assertFalse(result);
    }
}
