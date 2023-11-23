package org.example.neptunClone.service;

import java.util.List;

public interface LectureServiceInterface {

    List<Object[]> getAllLecture();
    List<Object[]> getLecturerById(Long id);
    List<Object[]> getLectureByTeacher(String teacher);
    List<Object[]> getLectureByTeacherId(Long id);
    List<Object[]> getLectureBySubject(String subject);
    List<Object[]> getLectureByTime(int time);
    List<Object[]> getLectureByClassroom(String name);
    List<Object[]> getLectureByStudentsPlaces(int places);

    /****************************/
    void deleteLecture(Long id);
    void insertLecture(String teacher, String subject, int time, String classroom, int places);


    void updateLectureTeacher(Long id, String teacher);
    void updateLectureSubject(Long id, String subject);
    void updateLectureTime(Long id, int time);
    void updateLectureClassroom(Long id, String classroom);
    void updateLecturePlaces(Long id, int places);
}
