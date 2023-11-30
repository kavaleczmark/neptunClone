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
        // Arrange
        Classroom classroom = new Classroom(1, "B.111", 30);
        when(classroomRepository.insertClassroom(classroom)).thenReturn(true);
        ClassroomService classroomService = new ClassroomService(classroomRepository);

        // Act
        boolean result = classroomService.addClassroom(classroom);

        // Assert
        assertTrue(result);
        verify(classroomRepository, times(1)).insertClassroom(classroom);
    }


}