package tests.lecture;
import org.example.neptunClone.controller.LectureController;
import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.service.impl.LectureService;
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
public class LectureControllerTest {
    @InjectMocks
    private LectureController lectureController;

    @Mock
    private LectureService lectureService;
    @Mock
    private Lecture lecture;

    @Test
    public void testGetAllLecture() throws SQLException {
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 40, 2, 2, 2)
        );
        when(lectureService.getAllLecture()).thenReturn(lectures);

        List<Lecture> result = lectureController.getAllLecture();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(9, result.get(0).getTime());
        assertEquals(50, result.get(0).getPlaces());
        assertEquals(1, result.get(0).getTeacher_id());
        assertEquals(1, result.get(0).getClassroom_id());
        assertEquals(1, result.get(0).getSubject_id());
        verify(lectureService, times(1)).getAllLecture();
    }

    @Test
    public void testGetLectureById() throws SQLException {
        Lecture lecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureService.getLecturerById(1)).thenReturn(lecture);

        Lecture result = lectureController.getLectureById(1);

        assertEquals(1, result.getId());
        assertEquals(9, result.getTime());
        assertEquals(50, result.getPlaces());
        assertEquals(1, result.getTeacher_id());
        assertEquals(1, result.getClassroom_id());
        assertEquals(1, result.getSubject_id());
        verify(lectureService, times(1)).getLecturerById(1);
    }

    @Test
    public void testInsertLecture() throws SQLException {
        Lecture lecture = new Lecture(1, 9, 50, 1, 1, 1);
        when(lectureService.addLecture(lecture)).thenReturn(true);

        ResponseEntity<Void> result = lectureController.insertLecture(lecture);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(lectureService, times(1)).addLecture(lecture);
    }

    @Test
    public void testUpdateLecture() throws SQLException {
        Lecture existingLecture = new Lecture(1, 9, 50, 1, 1, 1);
        Lecture newLecture = new Lecture(1, 10, 40, 2, 2, 2);
        when(lectureService.getLecturerById(1)).thenReturn(existingLecture);
        when(lectureService.updateLecture(existingLecture)).thenReturn(true);

        ResponseEntity<Void> result = lectureController.updateLecture(newLecture, 1);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(10, existingLecture.getTime());
        assertEquals(40, existingLecture.getPlaces());
        assertEquals(2, existingLecture.getTeacher_id());
        assertEquals(2, existingLecture.getClassroom_id());
        assertEquals(2, existingLecture.getSubject_id());
        verify(lectureService, times(1)).getLecturerById(1);
        verify(lectureService, times(1)).updateLecture(existingLecture);
    }

    @Test
    public void testDeleteLecture() throws SQLException {
        when(lectureService.deleteLecture(1)).thenReturn(true);

        ResponseEntity<Void> result = lectureController.deleteLecture(1);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(lectureService, times(1)).deleteLecture(1);
    }

    @Test
    public void testGetLectureByTeacherId() throws SQLException {
        int teacherId = 1;
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 40, 1, 2, 2)
        );
        when(lectureService.getLectureByTeacherId(teacherId)).thenReturn(lectures);

        List<Lecture> result = lectureController.getLectureByTeacherId(teacherId);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(9, result.get(0).getTime());
        assertEquals(50, result.get(0).getPlaces());
        assertEquals(1, result.get(0).getTeacher_id());
        assertEquals(1, result.get(0).getClassroom_id());
        assertEquals(1, result.get(0).getSubject_id());
        verify(lectureService, times(1)).getLectureByTeacherId(teacherId);
    }

    @Test
    public void testGetLectureBySubjectId() throws SQLException {
        int subjectId = 1;
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 40, 2, 2, 1)
        );
        when(lectureService.getLectureBySubjectId(subjectId)).thenReturn(lectures);

        List<Lecture> result = lectureController.getLectureBySubjectId(subjectId);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(9, result.get(0).getTime());
        assertEquals(50, result.get(0).getPlaces());
        assertEquals(1, result.get(0).getTeacher_id());
        assertEquals(1, result.get(0).getClassroom_id());
        assertEquals(1, result.get(0).getSubject_id());
        verify(lectureService, times(1)).getLectureBySubjectId(subjectId);
    }

    @Test
    public void testGetLectureByClassroom() throws SQLException {
        int classroomId = 1;
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 40, 2, 1, 2)
        );
        when(lectureService.getLectureByClassroomId(classroomId)).thenReturn(lectures);

        List<Lecture> result = lectureController.getLectureByClassroom(classroomId);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(9, result.get(0).getTime());
        assertEquals(50, result.get(0).getPlaces());
        assertEquals(1, result.get(0).getTeacher_id());
        assertEquals(1, result.get(0).getClassroom_id());
        assertEquals(1, result.get(0).getSubject_id());
        verify(lectureService, times(1)).getLectureByClassroomId(classroomId);
    }
    @Test
    void testGetLectureByTime() throws SQLException {
        int time = 9;
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 9, 60, 2, 2, 2)
        );
        when(lectureService.getLectureByTime(time)).thenReturn(lectures);

        List<Lecture> result = lectureController.getLectureByTime(time);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
        verify(lectureService, times(1)).getLectureByTime(time);
    }

    @Test
    void testGetLectureByStudentsPlaces() throws SQLException {
        int places = 50;
        List<Lecture> lectures = Arrays.asList(
                new Lecture(1, 9, 50, 1, 1, 1),
                new Lecture(2, 10, 50, 2, 2, 2)
        );
        when(lectureService.getLectureByStudentsPlaces(places)).thenReturn(lectures);

        List<Lecture> result = lectureController.getLectureByStudentsPlaces(places);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
        verify(lectureService, times(1)).getLectureByStudentsPlaces(places);
    }

}

