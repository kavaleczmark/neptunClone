package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.repository.TeacherRepositoryInterface;
import org.example.neptunClone.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceInterface {

    @Autowired
    private TeacherRepositoryInterface teacherRepositoryInterface;

    public TeacherService() {}

    public TeacherService(TeacherRepositoryInterface teacherRepositoryInterface) {
        this.teacherRepositoryInterface = teacherRepositoryInterface;
    }

    @Override
    public List<Teacher> getAllTeacher() throws SQLException {
        return teacherRepositoryInterface.getTeacher();
    }

    @Override
    public Teacher getTeacherById(int id) throws SQLException {
        return teacherRepositoryInterface.getTeacherById(id);
    }

    @Override
    public Teacher getTeacherByName(String name) throws SQLException {
        return teacherRepositoryInterface.getTeacherByName(name);
    }

    @Override
    public List<Teacher> getTeacherBySubjectId(int subject_id) throws SQLException {
        return teacherRepositoryInterface.getTeacherBySubjectId(subject_id);
    }
}
