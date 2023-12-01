package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.repository.LectureRepositoryInterface;
import org.example.neptunClone.service.LectureServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LectureService implements LectureServiceInterface {

    @Autowired
    private LectureRepositoryInterface lectureRepositoryInterface;

    public LectureService() {
    }

    public LectureService(LectureRepositoryInterface lectureRepositoryInterface) {
        this.lectureRepositoryInterface = lectureRepositoryInterface;
    }

    @Override
    public boolean addLecture(Lecture lecture) throws SQLException {
        return lectureRepositoryInterface.insertLecture(lecture);
    }

    @Override
    public boolean updateLecture(Lecture lecture) {
        return lectureRepositoryInterface.updateLecture(lecture);
    }

    @Override
    public List<Lecture> getAllLecture() throws SQLException {
        return lectureRepositoryInterface.getLecture();
    }

    @Override
    public Lecture getLecturerById(int id) throws SQLException {
        return lectureRepositoryInterface.getLectureById(id);
    }

    @Override
    public List<Lecture> getLectureByTeacherId(int id) throws SQLException {
        return lectureRepositoryInterface.getLectureByTeacherId(id);
    }

    @Override
    public List<Lecture> getLectureByClassroomId(int classroom_id) throws SQLException {
        return lectureRepositoryInterface.getLectureByClassroomId(classroom_id);
    }

    @Override
    public List<Lecture> getLectureBySubjectId(int subject_id) throws SQLException {
        return lectureRepositoryInterface.getLectureBySubjectId(subject_id);
    }
    @Override
    public List<Lecture> getLectureByTime(int time) throws SQLException {
        return lectureRepositoryInterface.getLectureByTime(time);
    }

    @Override
    public List<Lecture> getLectureByStudentsPlaces(int places) throws SQLException {
        return lectureRepositoryInterface.getLectureByStudentsPlaces(places);
    }

    @Override
    public boolean deleteLecture(int id) throws SQLException {
        return lectureRepositoryInterface.deleteLecture(id);
    }
}
