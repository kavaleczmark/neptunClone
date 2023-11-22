package org.example.neptunClone.controller;

import org.example.neptunClone.Model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassroomController {

    @Autowired
    private Classroom classroom;
}
