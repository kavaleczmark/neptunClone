package org.example.neptunClone.repository;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface LectureRepositoryInterface {
    public List<Lecture> getLecture() throws SQLException;
    public Lecture getLectureById(int id)throws SQLException;
    public List<Lecture> getLectureByTime(int time) throws SQLException;
    public List<Lecture> getLectureByTeacherId(int teacher_id) throws SQLException;
    public List<Lecture> getLectureByClassroomId(int classroom_id) throws SQLException;
    public List<Lecture> getLectureBySubjectId(int subject_id) throws SQLException;
    public List<Lecture> getLectureByStudentsPlaces(int students_places) throws SQLException;

    public boolean insertLecture(Lecture lecture);

    public boolean updateLecture(Lecture lecture);

}
