package org.example.neptunClone.service;

import org.example.neptunClone.Model.Teacher;
import org.example.neptunClone.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TeacherService implements TeacherServiceInterface{

    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<Object[]> getAllTeacher() {
        return teacherRepository.getTeacher();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
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
