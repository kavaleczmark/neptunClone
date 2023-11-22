package org.example.neptunClone.service;

import org.example.neptunClone.Model.Lecture;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LectureServiceInterface {

    Collection<Lecture> getAllLecture();
    Optional<Lecture> getLecturerById(Long id);
    List<Object[]> getLectureByTeacher(String teacher);
    List<Object[]> getLectureByTeacherId(int id);
    List<Object[]> getLectureBySubject(String subject);
    List<Object[]> getLectureByTime(int time);
    List<Object[]> getLectureByClassroom(String name);
    List<Object[]> getLectureByStudentsPlaces(int places);

    /****************************/
    void deleteLecture(int id);
    void insertLecture(String teacher, String subject, int time, String classroom, int places);


    void updateLectureTeacher(int id, String teacher);
    void updateLectureSubject(int id, String subject);
    void updateLectureTime(int id, int time);
    void updateLectureClassroom(int id, String classroom);
    void updateLecturePlaces(int id, int places);
}
