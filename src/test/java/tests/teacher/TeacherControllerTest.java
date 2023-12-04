package tests.teacher;

import org.example.neptunClone.controller.TeacherController;
import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.service.impl.TeacherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherControllerTest {

    @InjectMocks
    private TeacherController teacherController;
    @Mock
    private TeacherService teacherService;
    @Mock
    private Teacher teacher;

    @Test
    public void testGetAllTeachers() throws SQLException {
        List<Teacher> teachers = Arrays.asList(
                new Teacher(1, "Nagy József", 1),
                new Teacher(2, "Kiss Piroska", 2)
        );
        when(teacherService.getAllTeacher()).thenReturn(teachers);

        List<Teacher> result = teacherController.getAllTeacher();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Nagy József", result.get(0).getName());
        assertEquals(1, result.get(0).getSubject_id());
        assertEquals(2, result.get(1).getId());
        assertEquals("Kiss Piroska", result.get(1).getName());
        assertEquals(2, result.get(1).getSubject_id());

        verify(teacherService, times(1)).getAllTeacher();
    }

    @Test
    public void testGetTeacherById() throws SQLException {
        Teacher teacher = new Teacher(1, "Nagy József", 1);
        when(teacherService.getTeacherById(1)).thenReturn(teacher);

        Teacher result = teacherController.getTeacherById(1);

        assertEquals(1, result.getId());
        assertEquals("Nagy József", result.getName());
        assertEquals(1, result.getSubject_id());

        verify(teacherService, times(1)).getTeacherById(1);
    }

    @Test
    public void testUpdateTeacher() throws SQLException {
        Teacher existingTeacher = new Teacher(1, "Nagy József", 1);
        Teacher newTeacher = new Teacher(1, "Kiss Piroska", 2);

        when(teacherService.getTeacherById(1)).thenReturn(existingTeacher);
        when(teacherService.updateTeacher(existingTeacher)).thenReturn(true);

        ResponseEntity<Void> responseEntity = teacherController.updateTeacher(newTeacher, 1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Kiss Piroska", existingTeacher.getName());
        assertEquals(2, existingTeacher.getSubject_id());

        verify(teacherService, times(1)).getTeacherById(1);
        verify(teacherService, times(1)).updateTeacher(existingTeacher);
    }

    @Test
    public void testDeleteTeacher() throws SQLException {
        when(teacherService.deleteTeacher(1)).thenReturn(true);

        ResponseEntity<Void> responseEntity = teacherController.deleteTeacher(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(teacherService, times(1)).deleteTeacher(1);
    }

    @Test
    public void testGetTeacherBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Teacher> teachers = Arrays.asList(
                new Teacher(1, "Nagy József", 1),
                new Teacher(2, "Kiss Piroska", 1)
        );
        when(teacherService.getTeacherBySubjectId(subjectId)).thenReturn(teachers);

        List<Teacher> result = teacherController.getTeacherBySubjectId(subjectId);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Nagy József", result.get(0).getName());
        assertEquals(1, result.get(0).getSubject_id());
        assertEquals(2, result.get(1).getId());
        assertEquals("Kiss Piroska", result.get(1).getName());
        assertEquals(1, result.get(1).getSubject_id());

        verify(teacherService, times(1)).getTeacherBySubjectId(subjectId);
    }

    @Test
    public void testGetTeacherBySubjectIdNotFound() throws SQLException {
        int subjectId = 1;
        when(teacherService.getTeacherBySubjectId(subjectId)).thenReturn(Collections.emptyList());

        List<Teacher> result = teacherController.getTeacherBySubjectId(subjectId);

        assertTrue(result.isEmpty());

        verify(teacherService, times(1)).getTeacherBySubjectId(subjectId);
    }


    @Test
    public void testGetTeacherByIdNotFound() throws SQLException {
        int teacherId = 123;
        when(teacherService.getTeacherById(teacherId)).thenReturn(null);

        Teacher result = teacherController.getTeacherById(teacherId);

        assertNull(result);

        verify(teacherService, times(1)).getTeacherById(teacherId);
    }

    @Test
    public void testGetTeacherByNameNotFound() throws SQLException {
        String teacherName = "Nonexistent Teacher";
        when(teacherService.getTeacherByName(teacherName)).thenReturn(null);

        Teacher result = teacherController.getTeacherByName(teacherName);

        assertNull(result);

        verify(teacherService, times(1)).getTeacherByName(teacherName);
    }


    @Test
    public void testInsertTeacherNotFound() throws SQLException {
        Teacher teacher = new Teacher(123, "Nonexistent Teacher", 1);
        when(teacherService.addTeacher(teacher)).thenReturn(false);

        ResponseEntity<Void> responseEntity = teacherController.insertTeacher(teacher);

        assertEquals(HttpStatus.NOT_MODIFIED, responseEntity.getStatusCode());

        verify(teacherService, times(1)).addTeacher(teacher);
    }

}