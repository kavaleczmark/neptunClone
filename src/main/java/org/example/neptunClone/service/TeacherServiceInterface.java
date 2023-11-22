package org.example.neptunClone.service;


import org.example.neptunClone.Model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherServiceInterface {

    List<Object[]> getAllTeacher();
    Optional<Teacher> getTeacherById(Long id);
    Teacher getTeacherByName(String name);
    Teacher getTeacherBySubject(String subject);
}
