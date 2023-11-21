package org.example.neptunClone.controller;

import org.example.neptunClone.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private Teacher teacher;
}
