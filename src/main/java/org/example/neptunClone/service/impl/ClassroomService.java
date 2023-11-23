package org.example.neptunClone.service;

import org.example.neptunClone.Model.Classroom;
import org.example.neptunClone.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class ClassroomService implements ClassroomServiceInterface{

    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public Collection<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom getClassroomByName(String name) {
        return classroomRepository.getClassroomByName(name);
    }

    @Override
    public Classroom getClassroomByPlaces(int places) {
        return classroomRepository.getClassroomByPlaces(places);
    }
}
