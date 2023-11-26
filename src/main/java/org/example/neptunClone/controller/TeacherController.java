package org.example.neptunClone.controller;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/")
    public List<Teacher> getAllTeacher() throws SQLException {
        return teacherService.getAllTeacher();
    }

    @GetMapping(path = "/{id}")
    public Teacher getTeacherById(@PathVariable int id) throws SQLException {
        return teacherService.getTeacherById(id);
    }

    @GetMapping(path = "/name", params = "name")
    public Teacher getTeacherByName(@RequestParam("name") String name) throws SQLException {
        return teacherService.getTeacherByName(name);
    }
    @GetMapping(path = "/subject_id", params = "subjectId")
    public List<Teacher> getTeacherBySubjectId(@RequestParam("subjectId") int subject_id) throws SQLException {
        return teacherService.getTeacherBySubjectId(subject_id);
    }
    @PostMapping(path = "/")
    public ResponseEntity<Void> insertTeacher(@RequestBody Teacher teacher) throws SQLException {
        boolean result = teacherService.addTeacher(teacher);
        if (result) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }

}
