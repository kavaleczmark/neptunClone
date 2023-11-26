package org.example.neptunClone.controller;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.service.impl.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping(path = "/")
    public List<Classroom> getAllClassroom() throws SQLException {
        return classroomService.getAllClassroom();
    }

    @GetMapping(path = "/{id}")
    public Classroom getClassroomById(@PathVariable int id) throws SQLException {
        return classroomService.getClassroomById(id);
    }

    @GetMapping(path = "/name",params = "name")
    public Classroom getClassroomByName(@RequestParam("name") String name) throws SQLException {
        return classroomService.getClassroomByName(name);
    }

    @GetMapping(path="/places", params = "count")
    public Classroom getClassroomByPlaces(@RequestParam("count") int places) throws SQLException {
        return classroomService.getClassroomByPlaces(places);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Void> insertClassroom(@RequestBody Classroom classroom) {
        boolean result = classroomService.addClassroom(classroom);
        if (result) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }
}
