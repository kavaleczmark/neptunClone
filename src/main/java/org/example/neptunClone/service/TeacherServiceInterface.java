package org.example.neptunClone.service;


import org.example.neptunClone.model.Teacher;

import java.util.List;

public interface TeacherServiceInterface {

    List<Object[]> getAllTeacher();
    Teacher getTeacherById(Long id);
    Teacher getTeacherByName(String name);
    Teacher getTeacherBySubject(String subject);
}
