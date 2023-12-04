package tests.teacher;

import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.repository.impl.TeacherRepository;
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
public class TeacherRepositoryTest {
    @Mock
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        teacherRepository = mock(TeacherRepository.class);
    }

    @Test
    void testGetAllTeachers() throws SQLException {
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(1, "Nagy József", 1),
                new Teacher(2, "Kiss Piroska", 2)
        );
        when(teacherRepository.getTeacher()).thenReturn(expectedTeachers);

        List<Teacher> result = teacherRepository.getTeacher();

        assertEquals(expectedTeachers.size(), result.size());
        assertEquals(expectedTeachers.get(0), result.get(0));
        assertEquals(expectedTeachers.get(1), result.get(1));
        verify(teacherRepository, times(1)).getTeacher();
    }

    @Test
    void testGetTeacherById() throws SQLException {
        int teacherId = 1;
        Teacher expectedTeacher = new Teacher(1, "Nagy József", 1);
        when(teacherRepository.getTeacherById(teacherId)).thenReturn(expectedTeacher);

        Teacher result = teacherRepository.getTeacherById(teacherId);

        assertEquals(expectedTeacher, result);
        verify(teacherRepository, times(1)).getTeacherById(teacherId);
    }

    @Test
    void testGetTeachersBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(1, "Nagy József", 1),
                new Teacher(2, "Kiss Piroska", 1)
        );
        when(teacherRepository.getTeacherBySubjectId(subjectId)).thenReturn(expectedTeachers);


        List<Teacher> result = teacherRepository.getTeacherBySubjectId(subjectId);

        assertEquals(expectedTeachers.size(), result.size());
        assertEquals(expectedTeachers.get(0), result.get(0));
        assertEquals(expectedTeachers.get(1), result.get(1));
        verify(teacherRepository, times(1)).getTeacherBySubjectId(subjectId);
    }

    @Test
    void testInsertTeacher() throws SQLException {
        Teacher teacher = new Teacher(1, "Nagy József", 1);
        when(teacherRepository.insertTeacher(teacher)).thenReturn(true);

        boolean result = teacherRepository.insertTeacher(teacher);

        assertTrue(result);
        verify(teacherRepository, times(1)).insertTeacher(teacher);
    }

    @Test
    void testUpdateTeacher() throws SQLException {
        Teacher teacher = new Teacher(1, "Nagy József", 1);
        when(teacherRepository.updateTeacher(teacher)).thenReturn(true);

        boolean result = teacherRepository.updateTeacher(teacher);

        assertTrue(result);
        verify(teacherRepository, times(1)).updateTeacher(teacher);
    }

    @Test
    void testDeleteTeacher() throws SQLException {
        int teacherId = 1;
        when(teacherRepository.deleteTeacher(teacherId)).thenReturn(true);

        boolean result = teacherRepository.deleteTeacher(teacherId);

        assertTrue(result);
        verify(teacherRepository, times(1)).deleteTeacher(teacherId);
    }

    @Test
    public void testGetTeacherByName() throws SQLException {
        String teacherName = "Nagy József";
        Teacher expectedTeacher = new Teacher(1, teacherName, 1);
        when(teacherRepository.getTeacherByName(teacherName)).thenReturn(expectedTeacher);

        Teacher result = teacherRepository.getTeacherByName(teacherName);

        assertEquals(expectedTeacher, result);
        verify(teacherRepository, times(1)).getTeacherByName(teacherName);
    }

}
