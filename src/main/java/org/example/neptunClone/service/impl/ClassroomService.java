package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.ClassroomRepository;
import org.example.neptunClone.service.ClassroomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements ClassroomServiceInterface {

//    @Autowired
    private ClassroomRepository classroomRepository;

    public ClassroomService() {}

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Object[]> getAllClassroom() {
        return classroomRepository.getClassroom();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepository.getClassroomById(id);
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
