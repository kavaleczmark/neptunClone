package org.example.neptunClone.controller;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subject")
    public List<Object[]> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @GetMapping("/subject/{ID}")
    public Subject getSubjectById(@RequestParam("ID") Long id) {
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/subject/{name}")
    public Subject getSubjectByName(@RequestParam("name") String name) {
        return subjectService.getSubjectByName(name);
    }
}
