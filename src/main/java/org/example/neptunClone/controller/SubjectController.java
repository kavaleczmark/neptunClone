package org.example.neptunClone.controller;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Subject;
import org.example.neptunClone.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/")
    public List<Subject> getAllSubject() throws SQLException {
        return subjectService.getAllSubject();
    }

    @GetMapping(path = "/{id}")
    public Subject getSubjectById(@PathVariable int id) throws SQLException {
        return subjectService.getSubjectById(id);
    }

    @GetMapping(path = "/name", params = "name")
    public Subject getSubjectByName(@RequestParam("name") String name) throws SQLException {
        return subjectService.getSubjectByName(name);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Void> insertSubject(@RequestBody Subject subject) throws SQLException {
        boolean result = subjectService.addSubject(subject);
        if (result) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }
}
