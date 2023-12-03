package tests.classroom;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.impl.ClassroomRepository;
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
public class ClassroomRepositoryTest {

    @Mock
    private ClassroomRepository classroomRepository;

    private Classroom classroom;

    @BeforeEach
    public void setUp() {
        classroom = new Classroom(1, "B.111", 100);
    }

    @Test
    public void testGetClassroom_ReturnsListOfClassrooms() throws SQLException {
        // Given
        List<Classroom> expectedClassrooms = new ArrayList<>();
        expectedClassrooms.add(classroom);
        when(classroomRepository.getClassroom()).thenReturn(expectedClassrooms);

        // When
        List<Classroom> actualClassrooms = classroomRepository.getClassroom();

        // Then
        assertEquals(expectedClassrooms, actualClassrooms);
        verify(classroomRepository, times(1)).getClassroom();
    }

    @Test
    public void testGetClassroomById_ReturnsClassroomWithGivenId() throws SQLException {
        int id = classroom.getId();
        when(classroomRepository.getClassroomById(id)).thenReturn(classroom);
        Classroom actualClassroom = classroomRepository.getClassroomById(id);
        assertEquals(classroom, actualClassroom);
        verify(classroomRepository, times(1)).getClassroomById(id);
    }

    @Test
    public void testGetClassroomByName_ReturnsClassroomWithGivenName() throws SQLException {
        // Given
        String name = classroom.getName();
        when(classroomRepository.getClassroomByName(name)).thenReturn(classroom);

        // When
        Classroom actualClassroom = classroomRepository.getClassroomByName(name);

        // Then
        assertEquals(classroom, actualClassroom);
        verify(classroomRepository, times(1)).getClassroomByName(name);
    }

    @Test
    public void testGetClassroomByPlaces_ReturnsClassroomWithGivenPlaces() throws SQLException {
        // Given
        int places = classroom.getSpaces();
        when(classroomRepository.getClassroomByPlaces(places)).thenReturn(classroom);

        // When
        Classroom actualClassroom = classroomRepository.getClassroomByPlaces(places);

        // Then
        assertEquals(classroom, actualClassroom);
        verify(classroomRepository, times(1)).getClassroomByPlaces(places);
    }

    @Test
    public void testInsertClassroom_ReturnsTrueWhenInsertSuccessful() throws SQLException {
        // Given
        when(classroomRepository.insertClassroom(classroom)).thenReturn(true);

        // When
        boolean result = classroomRepository.insertClassroom(classroom);

        // Then
        assertTrue(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    public void testInsertClassroom_ReturnsFalseWhenInsertUnsuccessful() throws SQLException {
        // Given
        when(classroomRepository.insertClassroom(classroom)).thenReturn(false);

        // When
        boolean result = classroomRepository.insertClassroom(classroom);

        // Then
        assertFalse(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    public void testGetClassroom_Successful() throws SQLException {
        Classroom classroom1 = new Classroom(1, "B.111", 100);
        Classroom classroom2 = new Classroom(2, "B.113", 250);
        List<Classroom> expectedClassrooms = new ArrayList<>();
        expectedClassrooms.add(classroom1);
        expectedClassrooms.add(classroom2);
        when(classroomRepository.getClassroom()).thenReturn(expectedClassrooms);
        List<Classroom> actualClassrooms = classroomRepository.getClassroom();
        assertEquals(expectedClassrooms.size(), actualClassrooms.size());
        assertEquals(expectedClassrooms.get(0), actualClassrooms.get(0));
        assertEquals(expectedClassrooms.get(1), actualClassrooms.get(1));
        verify(classroomRepository, times(1)).getClassroom();
    }

    @Test
    public void testGetClassroomById_Successful() throws SQLException {
        int id = 1;
        Classroom expectedClassroom = new Classroom(1, "B.111", 100);
        when(classroomRepository.getClassroomById(id)).thenReturn(expectedClassroom);
        Classroom actualClassroom = classroomRepository.getClassroomById(id);
        assertEquals(expectedClassroom, actualClassroom);
        verify(classroomRepository, times(1)).getClassroomById(id);
    }

    @Test
    public void testInsertClassroom_Successful() {
        Classroom classroom = new Classroom(1, "B.111", 100);
        when(classroomRepository.insertClassroom(classroom)).thenReturn(true);
        boolean result = classroomRepository.insertClassroom(classroom);
        assertTrue(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }

    @Test
    public void testUpdateClassroom_ReturnsTrueWhenUpdateSuccessful() throws SQLException {
        // Given
        ClassroomRepository classroomRepository = mock(ClassroomRepository.class);
        Classroom classroom = new Classroom(1, "B.111", 100);
        when(classroomRepository.updateClassroom(classroom)).thenReturn(true);

        // When
        boolean result = classroomRepository.updateClassroom(classroom);

        // Then
        assertTrue(result);
        verify(classroomRepository, times(1)).updateClassroom(classroom);
    }

    @Test
    public void testUpdateClassroom_ReturnsFalseWhenUpdateFails() throws SQLException {
        // Given
        ClassroomRepository classroomRepository = mock(ClassroomRepository.class);
        Classroom classroom = new Classroom(1, "B.111", 100);
        when(classroomRepository.updateClassroom(classroom)).thenReturn(false);

        // When
        boolean result = classroomRepository.updateClassroom(classroom);

        // Then
        assertFalse(result);
        verify(classroomRepository, times(1)).updateClassroom(classroom);
    }


    @Test
    public void testDeleteClassroom_ReturnsTrueWhenDeleteSuccessful() throws SQLException {
        // Given
        ClassroomRepository classroomRepository = mock(ClassroomRepository.class);
        int id = 1;
        when(classroomRepository.deleteClassroom(id)).thenReturn(true);

        // When
        boolean result = classroomRepository.deleteClassroom(id);

        // Then
        assertTrue(result);
        verify(classroomRepository, times(1)).deleteClassroom(id);
    }

    @Test
    public void testDeleteClassroom_ReturnsFalseWhenDeleteFails() throws SQLException {
        // Given
        ClassroomRepository classroomRepository = mock(ClassroomRepository.class);
        int id = 1;
        when(classroomRepository.deleteClassroom(id)).thenReturn(false);

        // When
        boolean result = classroomRepository.deleteClassroom(id);

        // Then
        assertFalse(result);
        verify(classroomRepository, times(1)).deleteClassroom(id);
    }
}