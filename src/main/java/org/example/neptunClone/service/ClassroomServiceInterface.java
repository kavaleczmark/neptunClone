package org.example.neptunClone.service;

import org.example.neptunClone.model.Classroom;

import java.util.List;

public interface ClassroomServiceInterface {
    List<Object[]> getAllClassroom();
    Classroom getClassroomById(Long id);
    Classroom getClassroomByName(String name);


    Classroom getClassroomByPlaces(int places);
}
