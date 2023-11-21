package org.example.neptunClone.controller;

import org.example.neptunClone.Model.TeacherAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherAvailabilityController {
    @Autowired
    private TeacherAvailability teacherAvailability;
}
