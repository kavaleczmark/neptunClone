package tests.lecture;

import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.repository.impl.LectureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LectureRepositoryTest {
    private LectureRepository lectureRepository;

    @BeforeEach
    void setUp() {
        lectureRepository = mock(LectureRepository.class);
    }

    @Test
    void testGetLecture() throws SQLException {
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 2)
        );
        when(lectureRepository.getLecture()).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLecture();

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLecture();
    }

    @Test
    void testGetLectureById() throws SQLException {
        int lectureId = 1;
        Lecture expectedLecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureRepository.getLectureById(lectureId)).thenReturn(expectedLecture);

        Lecture result = lectureRepository.getLectureById(lectureId);

        assertEquals(expectedLecture, result);
        verify(lectureRepository, times(1)).getLectureById(lectureId);
    }

    @Test
    void testGetLectureByTeacherId() throws SQLException {
        int teacherId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 1, 2, 2)
        );
        when(lectureRepository.getLectureByTeacherId(teacherId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLectureByTeacherId(teacherId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLectureByTeacherId(teacherId);
    }

    @Test
    void testGetLectureByClassroomId() throws SQLException {
        int classroomId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 2)
        );
        when(lectureRepository.getLectureByClassroomId(classroomId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLectureByClassroomId(classroomId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLectureByClassroomId(classroomId);
    }

    @Test
    void testGetLectureBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 60, 2, 1, 1)
        );
        when(lectureRepository.getLectureBySubjectId(subjectId)).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLectureBySubjectId(subjectId);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLectureBySubjectId(subjectId);
    }

    @Test
    void testGetLectureByTime() throws SQLException {
        int time = 10;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(2, 10, 60, 2, 1, 1),
                new Lecture(3, 10, 50, 3, 2, 2)
        );
        when(lectureRepository.getLectureByTime(time)).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLectureByTime(time);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLectureByTime(time);
    }

    @Test
    void testGetLectureByStudentsPlaces() throws SQLException {
        int places = 50;
        List<Lecture> expectedLectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(3, 10, 50, 3, 2, 2)
        );
        when(lectureRepository.getLectureByStudentsPlaces(places)).thenReturn(expectedLectures);

        List<Lecture> result = lectureRepository.getLectureByStudentsPlaces(places);

        assertEquals(expectedLectures.size(), result.size());
        assertEquals(expectedLectures.get(0), result.get(0));
        assertEquals(expectedLectures.get(1), result.get(1));
        verify(lectureRepository, times(1)).getLectureByStudentsPlaces(places);
    }

    @Test
    void testInsertLecture() throws SQLException {
        Lecture lecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureRepository.insertLecture(lecture)).thenReturn(true);

        boolean result = lectureRepository.insertLecture(lecture);

        assertTrue(result);
        verify(lectureRepository, times(1)).insertLecture(lecture);
    }

    @Test
    void testDeleteLecture() throws SQLException {
        int lectureId = 1;
        when(lectureRepository.deleteLecture(lectureId)).thenReturn(true);

        boolean result = lectureRepository.deleteLecture(lectureId);

        assertTrue(result);
        verify(lectureRepository, times(1)).deleteLecture(lectureId);
    }

    @Test
    void testUpdateLecture() throws SQLException {
        Lecture lecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureRepository.updateLecture(lecture)).thenReturn(true);

        boolean result = lectureRepository.updateLecture(lecture);

        assertTrue(result);
        verify(lectureRepository, times(1)).updateLecture(lecture);
    }

}
