package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.repository.TeacherRepository;
import org.example.neptunClone.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService implements TeacherServiceInterface {

    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<Object[]> getAllTeacher() {
        return teacherRepository.getTeacher();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.getTeacherById(id);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        return teacherRepository.getTeacherByName(name);
    }

    @Override
    public Teacher getTeacherBySubject(String subject) {
        return teacherRepository.getTeacherBySubject(subject);
    }
}
