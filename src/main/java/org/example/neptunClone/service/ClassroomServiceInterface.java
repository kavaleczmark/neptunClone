package org.example.neptunClone.service;

import org.example.neptunClone.Model.Classroom;

import java.util.Collection;
import java.util.Optional;

public interface ClassroomServiceInterface {
    Collection<Classroom> getAllClassroom();
    Optional<Classroom> getClassroomById(Long id);
    Classroom getClassroomByName(String name);


    Classroom getClassroomByPlaces(int places);
}
