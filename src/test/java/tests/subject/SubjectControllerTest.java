package tests.subject;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.controller.SubjectController;
import org.example.neptunClone.service.impl.SubjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class SubjectControllerTest {
    @Mock
    private SubjectService subjectService;
    @InjectMocks
    private SubjectController subjectController;

    @Test
    void getAllSubject_ShouldReturnListOfSubjects() throws SQLException {
        Subject subject1 = new Subject(1, "Subject 1");
        Subject subject2 = new Subject(2, "Subject 2");
        List<Subject> subjectList = Arrays.asList(subject1, subject2);

        when(subjectService.getAllSubject()).thenReturn(subjectList);

        List<Subject> result = subjectController.getAllSubject();

        assertEquals(subjectList, result);
    }

    @Test
    void getSubjectById_ShouldReturnSubjectWithGivenId() throws SQLException {
        int subjectId = 1;
        Subject subject = new Subject(subjectId, "Subject 1");
        when(subjectService.getSubjectById(subjectId)).thenReturn(subject);
        Subject result = subjectController.getSubjectById(subjectId);
        assertEquals(subject, result);
    }

    @Test
    void getSubjectByName_ShouldReturnSubjectWithGivenName() throws SQLException {
        String subjectName = "Subject 1";
        Subject subject = new Subject(1, subjectName);
        when(subjectService.getSubjectByName(subjectName)).thenReturn(subject);
        Subject result = subjectController.getSubjectByName(subjectName);
        assertEquals(subject, result);
    }

    @Test
    void insertSubject_ShouldReturnHttpStatusNoContent() throws SQLException {
        Subject subject = new Subject(1, "Subject 1");
        when(subjectService.addSubject(subject)).thenReturn(true);
        ResponseEntity<Void> response = subjectController.insertSubject(subject);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void insertSubject_ShouldReturnHttpStatusNotModified() throws SQLException {
        Subject subject = new Subject(1, "Subject 1");
        when(subjectService.addSubject(subject)).thenReturn(false);
        ResponseEntity<Void> response = subjectController.insertSubject(subject);
        assertEquals(HttpStatus.NOT_MODIFIED, response.getStatusCode());
    }

    @Test
    void updateSubject_ShouldReturnHttpStatusOK() throws SQLException {
        int subjectId = 1;
        Subject existingSubject = new Subject(subjectId, "Subject 1");
        Subject updatedSubject = new Subject(subjectId, "Updated Subject 1");

        when(subjectService.getSubjectById(subjectId)).thenReturn(existingSubject);
        when(subjectService.updateSubject(existingSubject)).thenReturn(true);

        ResponseEntity<Void> response = subjectController.updateSubject(updatedSubject, subjectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Subject 1", existingSubject.getName());
    }

    @Test
    void updateSubject_ShouldReturnHttpStatusNotModified() throws SQLException {
        int subjectId = 1;
        Subject existingSubject = new Subject(subjectId, "Subject 1");
        Subject updatedSubject = new Subject(subjectId, "Updated Subject 1");

        when(subjectService.getSubjectById(subjectId)).thenReturn(existingSubject);
        when(subjectService.updateSubject(existingSubject)).thenReturn(false);

        ResponseEntity<Void> response = subjectController.updateSubject(updatedSubject, subjectId);
        assertEquals(HttpStatus.NOT_MODIFIED, response.getStatusCode());
        assertEquals("Updated Subject 1", existingSubject.getName());
    }

    @Test
    void deleteSubject_ShouldReturnHttpStatusOK() throws SQLException {
        int subjectId = 1;
        when(subjectService.deleteSubject(subjectId)).thenReturn(true);
        ResponseEntity<Void> response = subjectController.deleteSubject(subjectId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteSubject_ShouldReturnHttpStatusNotModified() throws SQLException {
        int subjectId = 1;
        when(subjectService.deleteSubject(subjectId)).thenReturn(false);
        ResponseEntity<Void> response = subjectController.deleteSubject(subjectId);
        assertEquals(HttpStatus.NOT_MODIFIED, response.getStatusCode());
    }

    @Test
    void getSubjectByName_ShouldThrowExceptionWhenNameIsEmpty() throws SQLException {
        String subjectName = "Matek";
        when(subjectService.getSubjectByName(subjectName)).thenThrow(new IllegalArgumentException("Name is Illegal"));
        assertThrows(IllegalArgumentException.class, () -> subjectController.getSubjectByName(subjectName));
    }

    @Test
    void getSubjectById_ShouldThrowExceptionWhenIdIsNegative() throws SQLException {
        int subjectId = -1;
        when(subjectService.getSubjectById(subjectId)).thenThrow(new IllegalArgumentException("Invalid ID"));
        assertThrows(IllegalArgumentException.class, () -> subjectController.getSubjectById(subjectId));
    }
}

