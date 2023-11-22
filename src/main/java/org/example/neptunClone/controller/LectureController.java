package org.example.neptunClone.controller;

import org.example.neptunClone.Model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

    @Autowired
    private Lecture lecture;

}
