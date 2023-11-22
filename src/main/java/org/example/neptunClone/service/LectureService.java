package org.example.neptunClone.service;

import org.example.neptunClone.Model.Lecture;
import org.example.neptunClone.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class LectureService implements LectureServiceInterface{

    @Autowired
    private LectureRepository lectureRepository;
    @Override
    public Collection<Lecture> getAllLecture() {
        return lectureRepository.findAll();
    }

    @Override
    public Optional<Lecture> getLecturerById(Long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public List<Object[]> getLectureByTeacher(String teacherName) {
        return lectureRepository.getLectureByTeacherName(teacherName);
    }

    @Override
    public List<Object[]> getLectureByTeacherId(int id) {
        return lectureRepository.getLectureByTeacherId(id);
    }

    @Override
    public List<Object[]> getLectureBySubject(String subjectName) {
        return lectureRepository.getLectureBySubjectName(subjectName);
    }

    @Override
    public List<Object[]> getLectureByTime(int time) {
        return lectureRepository.getLectureByTime(time);
    }

    @Override
    public List<Object[]> getLectureByClassroom(String classroomName) {
        return lectureRepository.getLectureByClassroomName(classroomName);
    }

    @Override
    public List<Object[]> getLectureByStudentsPlaces(int places) {
        return lectureRepository.getLectureByStudentsPlaces(places);
    }

    // TODO implement rest of CRUD

    @Override
    public void deleteLecture(int id) {

    }

    @Override
    public void insertLecture(String teacher, String subject, int time, String classroom, int places) {

    }

    @Override
    public void updateLectureTeacher(int id, String teacher) {

    }

    @Override
    public void updateLectureSubject(int id, String subject) {

    }

    @Override
    public void updateLectureTime(int id, int time) {

    }

    @Override
    public void updateLectureClassroom(int id, String classroom) {

    }

    @Override
    public void updateLecturePlaces(int id, int places) {

    }
}
