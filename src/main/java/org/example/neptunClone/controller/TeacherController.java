package org.example.neptunClone.controller;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public List<Object[]> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/teacher/{ID}")
    public Teacher getTeacherById(@RequestParam("ID") Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teacher/{name}")
    public Teacher getTeacherByName(@RequestParam("name") String name) {
        return teacherService.getTeacherByName(name);
    }
    @GetMapping("/teacher/{subject}")
    public Teacher getTeacherBySubject(@RequestParam("subject") String subject) {
        return teacherService.getTeacherBySubject(subject);
    }




}
