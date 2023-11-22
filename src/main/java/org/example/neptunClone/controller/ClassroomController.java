package org.example.neptunClone.controller;

import org.example.neptunClone.Model.Classroom;
import org.example.neptunClone.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassroomController {

    @Autowired
    private Classroom classroom;
    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping(path = "/classroom")
    public List getAllClassroom() {
        return classroomRepository.findAll();
    }

    /*
    *
    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String firstName, @RequestParam String email) {

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(firstName);
        user.setEmail(email);
        userRepository.save(user);
        return "User Created";
    }
*/
}
