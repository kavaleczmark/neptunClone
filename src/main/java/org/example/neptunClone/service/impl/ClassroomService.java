package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.ClassroomRepositoryInterface;
import org.example.neptunClone.service.ClassroomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClassroomService implements ClassroomServiceInterface {

    @Autowired
    private ClassroomRepositoryInterface classroomRepository;

    public ClassroomService() {}

    public ClassroomService(ClassroomRepositoryInterface classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public boolean addClassroom(Classroom classroom) {
        return classroomRepository.insertClassroom(classroom);
    }

    @Override
    public boolean updateClassroom(Classroom classroom) {
        return classroomRepository.updateClassroom(classroom);
    }

    @Override
    public List<Classroom> getAllClassroom() throws SQLException {
        return classroomRepository.getClassroom();
    }

    @Override
    public Classroom getClassroomById(int id) throws SQLException {
        return classroomRepository.getClassroomById(id);
    }

    @Override
    public Classroom getClassroomByName(String name) throws SQLException {
        return classroomRepository.getClassroomByName(name);
    }

    @Override
    public Classroom getClassroomByPlaces(int places) throws SQLException {
        return classroomRepository.getClassroomByPlaces(places);
    }
}
