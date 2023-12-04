package tests.classroom;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.ClassroomRepositoryInterface;
import org.example.neptunClone.service.impl.ClassroomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @Mock
    private ClassroomRepositoryInterface classroomRepository;

    @InjectMocks
    private ClassroomService classroomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddClassroom() {
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.insertClassroom(any(Classroom.class))).thenReturn(true);
        boolean result = classroomService.addClassroom(classroom);
        assertTrue(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    void testAddClassroom_Failure() {
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.insertClassroom(any(Classroom.class))).thenReturn(false);
        boolean result = classroomService.addClassroom(classroom);
        assertFalse(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    void testUpdateClassroom() {
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.updateClassroom(any(Classroom.class))).thenReturn(true);
        boolean result = classroomService.updateClassroom(classroom);
        assertTrue(result);
        verify(classroomRepository, times(1)).updateClassroom(classroom);
    }

    @Test
    void testUpdateClassroom_Failure() {
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.updateClassroom(any(Classroom.class))).thenReturn(false);
        boolean result = classroomService.updateClassroom(classroom);
        assertFalse(result);
        verify(classroomRepository, times(1)).updateClassroom(classroom);
    }

    @Test
    void testDeleteClassroom() throws SQLException {
        int id = 1;
        when(classroomRepository.deleteClassroom(id)).thenReturn(true);
        boolean result = classroomService.deleteClassroom(id);
        assertTrue(result);
        verify(classroomRepository, times(1)).deleteClassroom(id);
    }

    @Test
    void testDeleteClassroom_Failure() throws SQLException {
        int id = 1;
        when(classroomRepository.deleteClassroom(id)).thenReturn(false);
        boolean result = classroomService.deleteClassroom(id);
        assertFalse(result);
        verify(classroomRepository, times(1)).deleteClassroom(id);
    }

    @Test
    void testGetAllClassroom() throws SQLException {
        Classroom classroom1 = new Classroom(1, "Classroom 1", 30);
        Classroom classroom2 = new Classroom(2, "Classroom 2", 20);
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroom1);
        classrooms.add(classroom2);
        when(classroomRepository.getClassroom()).thenReturn(classrooms);
        List<Classroom> result = classroomService.getAllClassroom();
        assertEquals(classrooms, result);
        verify(classroomRepository, times(1)).getClassroom();
    }

    @Test
    void testGetAllClassroom_Empty() throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();
        when(classroomRepository.getClassroom()).thenReturn(classrooms);
        List<Classroom> result = classroomService.getAllClassroom();
        assertEquals(classrooms, result);
        verify(classroomRepository, times(1)).getClassroom();
    }

    @Test
    void testGetClassroomById() throws SQLException {
        int id = 1;
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.getClassroomById(id)).thenReturn(classroom);
        Classroom result = classroomService.getClassroomById(id);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).getClassroomById(id);
    }

    @Test
    void testGetClassroomById_NotFound() throws SQLException {
        int id = 1;
        when(classroomRepository.getClassroomById(id)).thenReturn(null);
        Classroom result = classroomService.getClassroomById(id);
        assertNull(result);
        verify(classroomRepository, times(1)).getClassroomById(id);
    }

    @Test
    void testGetClassroomByName() throws SQLException {
        String name = "Classroom 1";
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.getClassroomByName(name)).thenReturn(classroom);
        Classroom result = classroomService.getClassroomByName(name);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).getClassroomByName(name);
    }

    @Test
    void testGetClassroomByName_NotFound() throws SQLException {
        String name = "Classroom 1";
        when(classroomRepository.getClassroomByName(name)).thenReturn(null);
        Classroom result = classroomService.getClassroomByName(name);
        assertNull(result);
        verify(classroomRepository, times(1)).getClassroomByName(name);
    }

    @Test
    void testGetClassroomByPlaces() throws SQLException {
        int places = 30;
        Classroom classroom = new Classroom(1, "Classroom 1", 30);
        when(classroomRepository.getClassroomByPlaces(places)).thenReturn(classroom);
        Classroom result = classroomService.getClassroomByPlaces(places);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).getClassroomByPlaces(places);
    }

    @Test
    void testGetClassroomByPlaces_NotFound() throws SQLException {
        int places = 30;
        when(classroomRepository.getClassroomByPlaces(places)).thenReturn(null);
        Classroom result = classroomService.getClassroomByPlaces(places);
        assertNull(result);
        verify(classroomRepository, times(1)).getClassroomByPlaces(places);
    }
}
