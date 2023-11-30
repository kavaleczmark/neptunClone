package tests;

import org.example.neptunClone.controller.ClassroomController;
import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.ClassroomRepositoryInterface;
import org.example.neptunClone.service.impl.ClassroomService;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassroomControllerTest {

    @InjectMocks
    private ClassroomController classroomController;

    @Mock
    private ClassroomService classroomService;

    @Mock
    private ClassroomRepositoryInterface classroomRepository;

    @Test
    public void testAddClassroom() {
        Classroom classroom = new Classroom(1, "B.111", 30);
        when(classroomRepository.insertClassroom(classroom)).thenReturn(true);
        ClassroomService classroomService = new ClassroomService(classroomRepository);
        boolean result = classroomService.addClassroom(classroom);
        assertTrue(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    public void testGetAllClassroom() throws SQLException {
        List<Classroom> classrooms = Arrays.asList(
                new Classroom(1, "B.111", 100),
                new Classroom(2, "B.113", 250)
        );
        when(classroomRepository.getClassroom()).thenReturn(classrooms);
        ClassroomService classroomService = new ClassroomService(classroomRepository);
        List<Classroom> result = classroomService.getAllClassroom();
        assertEquals(classrooms.size(), result.size());
    }

    @Test
    public void testGetClassroomById() throws SQLException {
        int id = 1;
        Classroom classroom = new Classroom(id, "B.111", 30);
        when(classroomRepository.getClassroomById(id)).thenReturn(classroom);
        ClassroomService classroomService = new ClassroomService(classroomRepository);
        Classroom result = classroomService.getClassroomById(id);
        assertEquals(id, result.getId());
    }

    @Test
    public void testGetClassroomByName() throws SQLException {
        String name = "B.111";
        Classroom classroom = new Classroom(1, name, 30);
        when(classroomRepository.getClassroomByName(name)).thenReturn(classroom);
        Classroom result = classroomRepository.getClassroomByName(name);
        assertEquals(name, result.getName());
    }
    @Test
    public void testGetClassroomByPlaces() throws SQLException {
        int places = 30;
        Classroom classroom = new Classroom(1, "B.111", places);
        when(classroomRepository.getClassroomByPlaces(places)).thenReturn(classroom);
        Classroom result = classroomRepository.getClassroomByPlaces(places);
        assertEquals(places, result.getSpaces());
    }
    @Test
    public void testInsertClassroom_Successful() {
        Classroom classroom = new Classroom(1, "B.111", 30);
        when(classroomService.addClassroom(classroom)).thenReturn(true);
        ResponseEntity<Void> result = classroomController.insertClassroom(classroom);
        assertEquals(HttpStatus.NO_CONTENT.value(), result.getStatusCodeValue());
    }
    @Test
    public void testInsertClassroom_Failure() {
        Classroom classroom = new Classroom(1, "B.111", 30);
        when(classroomService.addClassroom(classroom)).thenReturn(false);
        ResponseEntity<Void> result = classroomController.insertClassroom(classroom);
        assertEquals(HttpStatus.NOT_MODIFIED, result.getStatusCode());
    }
    @Test
    public void testUpdateClassroom_Successful() throws SQLException {
        int id = 1;
        Classroom classroom = new Classroom(id, "B.111", 100);
        Classroom updatedClassroom = new Classroom(id, "Updated Classroom", 40);
        when(classroomService.getClassroomById(id)).thenReturn(classroom);
        when(classroomService.updateClassroom(classroom)).thenReturn(true);
        ResponseEntity<Void> result = classroomController.updateClassroom(updatedClassroom, id);
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        assertEquals(updatedClassroom.getName(), classroom.getName());
        assertEquals(updatedClassroom.getSpaces(), classroom.getSpaces());
    }

    @Test
    public void testUpdateClassroom_Failure() throws SQLException {
        int id = 1;
        Classroom classroom = new Classroom(id, "B.111", 100);
        Classroom updatedClassroom = new Classroom(id, "Updated Classroom", 40);
        when(classroomService.getClassroomById(id)).thenReturn(classroom);
        when(classroomService.updateClassroom(classroom)).thenReturn(false);
        ResponseEntity<Void> result = classroomController.updateClassroom(updatedClassroom, id);
        assertEquals(HttpStatus.NOT_MODIFIED.value(), result.getStatusCodeValue());
    }
}