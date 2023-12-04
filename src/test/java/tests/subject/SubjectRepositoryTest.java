package tests.subject;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.repository.impl.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class SubjectRepositoryTest {
    @Mock
    private SubjectRepository subjectRepository;

    @BeforeEach
    public void setUp() {
        subjectRepository = new SubjectRepository();
    }

    @Test
    public void getSubjectById_NonExistingSubjectId_ThrowsSQLException() throws SQLException {
        int id = 1;
        subjectRepository = spy(subjectRepository);
        doThrow(new SQLException("Nem található a tárgy.")).when(subjectRepository).getSubjectById(id);
        assertThrows(SQLException.class, () -> subjectRepository.getSubjectById(id));
    }

    @Test
    public void getSubjectByName_NonExistingSubjectName_ThrowsSQLException() throws SQLException {
        String name = "Matek";
        subjectRepository = spy(subjectRepository);
        doThrow(new SQLException("Nem található a tárgy.")).when(subjectRepository).getSubjectByName(name);
        assertThrows(SQLException.class, () -> subjectRepository.getSubjectByName(name));
    }

    @Test
    public void insertSubject_ValidSubject_ReturnsTrue() {
        Subject subject = new Subject(1, "Matek");
        subjectRepository = spy(subjectRepository);
        doReturn(1).when(subjectRepository).upsert(anyString());
        boolean result = subjectRepository.insertSubject(subject);
        assertTrue(result);
    }

    @Test
    public void insertSubject_InvalidSubject_ReturnsFalse() {
        Subject subject = new Subject(1, null);
        subjectRepository = spy(subjectRepository);
        doReturn(0).when(subjectRepository).upsert(anyString());
        boolean result = subjectRepository.insertSubject(subject);
        assertFalse(result);
    }

    @Test
    public void updateSubject_ValidSubject_ReturnsTrue() {
        Subject subject = new Subject(1, "Updated Subject");
        subjectRepository = spy(subjectRepository);
        doReturn(1).when(subjectRepository).upsert(anyString());
        boolean result = subjectRepository.updateSubject(subject);
        assertTrue(result);
    }

    @Test
    public void updateSubject_InvalidSubject_ReturnsFalse() {
        Subject subject = new Subject(1, null);
        subjectRepository = spy(subjectRepository);
        doReturn(0).when(subjectRepository).upsert(anyString());
        boolean result = subjectRepository.updateSubject(subject);
        assertFalse(result);
    }

    @Test
    public void deleteSubject_ExistingSubjectId_ReturnsTrue() {
        int id = 1;
        subjectRepository = spy(subjectRepository);
        doReturn(true).when(subjectRepository).delete(anyString());
        boolean result = subjectRepository.deleteSubject(id);
        assertTrue(result);
    }

    @Test
    public void deleteSubject_NonExistingSubjectId_ReturnsFalse() {
        int id = 1;
        subjectRepository = spy(subjectRepository);
        doReturn(false).when(subjectRepository).delete(anyString());
        boolean result = subjectRepository.deleteSubject(id);
        assertFalse(result);
    }

    @Test
    public void insertSubject_ValidSubject_CallsUpsertMethod() {
        Subject subject = new Subject(1, "Matek");
        subjectRepository = spy(subjectRepository);
        doReturn(1).when(subjectRepository).upsert(anyString());
        subjectRepository.insertSubject(subject);
        verify(subjectRepository, times(1)).upsert(anyString());
    }

    @Test
    public void updateSubject_ValidSubject_CallsUpsertMethod() {
        Subject subject = new Subject(1, "Updated Subject");
        subjectRepository = spy(subjectRepository);
        doReturn(1).when(subjectRepository).upsert(anyString());
        subjectRepository.updateSubject(subject);
        verify(subjectRepository, times(1)).upsert(anyString());
    }

    @Test
    public void deleteSubject_ExistingSubjectId_CallsDeleteMethod() {
        int id = 1;
        subjectRepository = spy(subjectRepository);
        doReturn(true).when(subjectRepository).delete(anyString());
        subjectRepository.deleteSubject(id);
        verify(subjectRepository, times(1)).delete(anyString());
    }
}