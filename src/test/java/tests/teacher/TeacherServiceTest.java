package tests.teacher;

import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.repository.TeacherRepositoryInterface;
import org.example.neptunClone.service.impl.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {
    @Mock
    private TeacherRepositoryInterface teacherRepositoryInterface;
    @Mock
    private TeacherService teacherService;
    @Mock
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacherRepositoryInterface = mock(TeacherRepositoryInterface.class);
        teacherService = new TeacherService(teacherRepositoryInterface);
        teacher = new Teacher(1, "Nagy József", 1);
    }

    @Test
    void testAddTeacher() throws SQLException {
        when(teacherRepositoryInterface.insertTeacher(teacher)).thenReturn(true);

        boolean result = teacherService.addTeacher(teacher);

        assertTrue(result);
        verify(teacherRepositoryInterface, times(1)).insertTeacher(teacher);
    }

    @Test
    void testUpdateTeacher() {
        when(teacherRepositoryInterface.updateTeacher(teacher)).thenReturn(true);

        boolean result = teacherService.updateTeacher(teacher);

        assertTrue(result);
        verify(teacherRepositoryInterface, times(1)).updateTeacher(teacher);
    }

    @Test
    void testGetAllTeacher() throws SQLException {
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(1, "Nagy József", 1),
                new Teacher(2, "Kiss Piroska", 2)
        );
        when(teacherRepositoryInterface.getTeacher()).thenReturn(expectedTeachers);

        List<Teacher> result = teacherService.getAllTeacher();

        assertEquals(expectedTeachers.size(), result.size());
        assertEquals(expectedTeachers.get(0), result.get(0));
        assertEquals(expectedTeachers.get(1), result.get(1));
        verify(teacherRepositoryInterface, times(1)).getTeacher();
    }


    @Test
    void testDeleteTeacher() throws SQLException {
        int teacherId = 1;
        when(teacherRepositoryInterface.deleteTeacher(teacherId)).thenReturn(true);

        boolean result = teacherService.deleteTeacher(teacherId);

        assertTrue(result);
        verify(teacherRepositoryInterface, times(1)).deleteTeacher(teacherId);
    }

    @Test
    void testGetTeacherById() throws SQLException {
        int teacherId = 1;
        Teacher expectedTeacher = new Teacher(1, "Nagy József", 1);
        when(teacherRepositoryInterface.getTeacherById(teacherId)).thenReturn(expectedTeacher);

        Teacher result = teacherService.getTeacherById(teacherId);

        assertEquals(expectedTeacher, result);
        verify(teacherRepositoryInterface, times(1)).getTeacherById(teacherId);
    }

    @Test
    void testGetTeacherByName() throws SQLException {
        String teacherName = "Nagy József";
        Teacher expectedTeacher = new Teacher(1, teacherName, 1);
        when(teacherRepositoryInterface.getTeacherByName(teacherName)).thenReturn(expectedTeacher);

        Teacher result = teacherService.getTeacherByName(teacherName);

        assertEquals(expectedTeacher, result);
        verify(teacherRepositoryInterface, times(1)).getTeacherByName(teacherName);
    }

    @Test
    void testGetTeacherBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(1, "Nagy József", subjectId),
                new Teacher(2, "Kiss Piroska", subjectId)
        );
        when(teacherRepositoryInterface.getTeacherBySubjectId(subjectId)).thenReturn(expectedTeachers);

        List<Teacher> result = teacherService.getTeacherBySubjectId(subjectId);

        assertEquals(expectedTeachers.size(), result.size());
        assertEquals(expectedTeachers.get(0), result.get(0));
        assertEquals(expectedTeachers.get(1), result.get(1));
        verify(teacherRepositoryInterface, times(1)).getTeacherBySubjectId(subjectId);
    }
}

