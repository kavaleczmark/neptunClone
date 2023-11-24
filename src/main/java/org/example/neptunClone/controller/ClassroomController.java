package org.example.neptunClone.controller;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.service.impl.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping(path = "/classroom")
    public List<Object[]> getAllClassroom() {
        return classroomService.getAllClassroom();
    }

    @GetMapping(path = "/classroom/{ID}")
    public Classroom getClassroomById(@RequestParam("ID") Long id) {
        return classroomService.getClassroomById(id);
    }

    @GetMapping(path = "/classroom/{name}")
    public Classroom getClassroomByName(@RequestParam("name") String name) {
        return classroomService.getClassroomByName(name);
    }


    @GetMapping(path = "/classroom/{places}")
    public Classroom getClassroomByPlaces(@RequestParam("places") int places) {
        return classroomService.getClassroomByPlaces(places);
    }

    @GetMapping(path = "/classroomhard")
    public String getClassroomByPlaces() {
        return "hehe";
    }
}
    /*
    *
    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestSParam String firstName, @RequestParam String firstName, @RequestParam String email) {

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(firstName);
        user.setEmail(email);
        userRepository.save(user);
        return "User Created";
    }
*/

