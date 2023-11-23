package org.example.neptunClone.service.impl;

import org.example.neptunClone.repository.LectureRepository;
import org.example.neptunClone.service.LectureServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LectureService implements LectureServiceInterface {

    @Autowired
    private LectureRepository lectureRepository;
    @Override
    public List<Object[]> getAllLecture() {
        return lectureRepository.getLecture();
    }

    @Override
    public List<Object[]> getLecturerById(Long id) {
        return lectureRepository.getLectureById(id);
    }

    @Override
    public List<Object[]> getLectureByTeacher(String teacherName) {
        return lectureRepository.getLectureByTeacherName(teacherName);
    }

    @Override
    public List<Object[]> getLectureByTeacherId(Long id) {
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
    public void deleteLecture(Long id) {

    }

    @Override
    public void insertLecture(String teacher, String subject, int time, String classroom, int places) {

    }

    @Override
    public void updateLectureTeacher(Long id, String teacher) {

    }

    @Override
    public void updateLectureSubject(Long id, String subject) {

    }

    @Override
    public void updateLectureTime(Long id, int time) {

    }

    @Override
    public void updateLectureClassroom(Long id, String classroom) {

    }

    @Override
    public void updateLecturePlaces(Long id, int places) {

    }
}
