package org.example.neptunClone.controller;

import org.example.neptunClone.Model.ClassroomAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassroomAvailabilityController {
    @Autowired
    private ClassroomAvailability classroomAvailability;
}
