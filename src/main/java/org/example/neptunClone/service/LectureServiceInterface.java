package org.example.neptunClone.service;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Lecture;

import java.sql.SQLException;
import java.util.List;

public interface LectureServiceInterface {

    boolean addLecture(Lecture lecture) throws SQLException;
    boolean updateLecture(Lecture lecture);
    List<Lecture> getAllLecture() throws SQLException;
    Lecture getLecturerById(int id) throws SQLException;
    List<Lecture> getLectureByTeacherId(int id) throws SQLException;
    List<Lecture> getLectureBySubjectId(int id) throws SQLException;
    List<Lecture> getLectureByTime(int time) throws SQLException;
    List<Lecture> getLectureByClassroomId(int id) throws SQLException;
    List<Lecture> getLectureByStudentsPlaces(int places) throws SQLException;
    boolean deleteLecture(int id) throws SQLException;
}
