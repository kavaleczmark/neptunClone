package org.example.neptunClone.repository.impl;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.repository.LectureRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LectureRepository extends GenericDataAccess<Lecture> implements LectureRepositoryInterface {
    @Override
    public List<Lecture> getLecture() throws SQLException {
        String sqlQuery = "SELECT * FROM lecture;";
        return query(sqlQuery);
    }

    @Override
    public Lecture getLectureById(int id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where id = %d;", id);
        return query(sqlQuery).get(0);
    }

    @Override
    public List<Lecture> getLectureByTime(int time) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where time = %d;", time);
        return query(sqlQuery);
    }

    @Override
    public List<Lecture> getLectureByTeacherId(int teacher_id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where teacher_id = %d;", teacher_id);
        return query(sqlQuery);
    }

    @Override
    public List<Lecture> getLectureByClassroomId(int classroom_id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where classroom_id = %d;", classroom_id);
        return query(sqlQuery);
    }

    @Override
    public List<Lecture> getLectureBySubjectId(int subject_id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where subject_id = %d;", subject_id);
        return query(sqlQuery);
    }

    @Override
    public List<Lecture> getLectureByStudentsPlaces(int places) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM lecture where places = %d;", places);
        return query(sqlQuery);
    }

    @Override
    public boolean insertLecture(Lecture lecture) {
        int rowsAffected = upsert(String.format("INSERT INTO lecture (time, places, teacher_id, classroom_id, subject_id) VALUES (%d, %d, %d, %d, %d);", lecture.getTime(), lecture.getPlaces(), lecture.getTeacher_id(), lecture.getClassroom_id(), lecture.getSubject_id()));
        return rowsAffected == 1;
    }

    @Override
    List<Lecture> map(ResultSet resultSet) throws SQLException {
        List<Lecture> lectures = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            int time = resultSet.getInt(2);
            int places = resultSet.getInt(3);
            int teacher_id = resultSet.getInt(4);
            int classroom_id = resultSet.getInt(5);
            int subject_id = resultSet.getInt(6);
            lectures.add(new Lecture(id, time, places, teacher_id, classroom_id, subject_id));
        }
        return lectures;
    }
}
