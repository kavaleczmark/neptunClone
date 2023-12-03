package tests.lecture;

import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.repository.LectureRepositoryInterface;
import org.example.neptunClone.service.impl.LectureService;
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
public class LectureServiceTest {
    @Mock
    private LectureRepositoryInterface lectureRepositoryInterface;
    @Mock
    private LectureService lectureService;
    @Mock
    private Lecture lecture;

    @BeforeEach
    void setUp() {
        lectureRepositoryInterface = mock(LectureRepositoryInterface.class);
        lectureService = new LectureService(lectureRepositoryInterface);
        lecture = new Lecture(1, 9, 50, 1, 1, 1);
    }

    @Test
    void testAddLecture() throws SQLException {
        when(lectureRepositoryInterface.insertLecture(lecture)).thenReturn(true);
        boolean result = lectureService.addLecture(lecture);
        assertTrue(result);
        verify(lectureRepositoryInterface, times(1)).insertLecture(lecture);
    }

    @Test
    void testUpdateLecture() {
        when(lectureRepositoryInterface.updateLecture(lecture)).thenReturn(true);
        boolean result = lectureService.updateLecture(lecture);
        assertTrue(result);
        verify(lectureRepositoryInterface, times(1)).updateLecture(lecture);
    }

    @Test
    void testGetAllLecture() throws SQLException {
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 2)
        );
        when(lectureRepositoryInterface.getLecture()).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getAllLecture();

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLecture();
    }

    @Test
    void testGetLecturerById() throws SQLException {
        int lectureId = 1;
        Lecture expectedLecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureRepositoryInterface.getLectureById(lectureId)).thenReturn(expectedLecture);

        Lecture result = lectureService.getLecturerById(lectureId);

        assertEquals(expectedLecture, result);
        verify(lectureRepositoryInterface, times(1)).getLectureById(lectureId);
    }

    @Test
    void testGetLectureByTeacherId() throws SQLException {
        int teacherId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 1, 2, 2)
        );
        when(lectureRepositoryInterface.getLectureByTeacherId(teacherId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getLectureByTeacherId(teacherId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLectureByTeacherId(teacherId);
    }

    @Test
    void testGetLectureByClassroomId() throws SQLException {
        int classroomId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 2)
        );
        when(lectureRepositoryInterface.getLectureByClassroomId(classroomId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getLectureByClassroomId(classroomId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLectureByClassroomId(classroomId);
    }

    @Test
    void testGetLectureBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 1)
        );
        when(lectureRepositoryInterface.getLectureBySubjectId(subjectId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getLectureBySubjectId(subjectId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLectureBySubjectId(subjectId);
    }

    @Test
    void testGetLectureByTime() throws SQLException {
        int time = 10;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(2, 10, 60, 2, 1, 1),
                new Lecture(3, 10, 50, 3, 2, 2)
        );
        when(lectureRepositoryInterface.getLectureByTime(time)).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getLectureByTime(time);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLectureByTime(time);
    }

    @Test
    void testGetLectureByStudentsPlaces() throws SQLException {
        int places = 50;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(3, 10, 50, 3, 2, 2)
        );
        when(lectureRepositoryInterface.getLectureByStudentsPlaces(places)).thenReturn(expectedLectures);

        List<Lecture> result = lectureService.getLectureByStudentsPlaces(places);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepositoryInterface, times(1)).getLectureByStudentsPlaces(places);
    }

    @Test
    void testDeleteLecture() throws SQLException {
        int lectureId = 1;
        when(lectureRepositoryInterface.deleteLecture(lectureId)).thenReturn(true);
        boolean result = lectureService.deleteLecture(lectureId);
        assertTrue(result);
        verify(lectureRepositoryInterface, times(1)).deleteLecture(lectureId);
    }
}
