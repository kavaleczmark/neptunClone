package org.example.neptunClone.controller;

import org.example.neptunClone.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    Subject subject;

}
