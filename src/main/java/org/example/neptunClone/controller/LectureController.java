package org.example.neptunClone.controller;

import org.example.neptunClone.service.impl.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture")
    public List<Object[]> getAllLecture(){
        return lectureService.getAllLecture();
    }

    @GetMapping("/lecture/{ID}")
    public List<Object[]> getLectureById(@RequestParam("ID") Long id){
        return lectureService.getLecturerById(id);
    }

    @GetMapping("/lecture/{teacher_name}")
    public List<Object[]> getLectureByTeacherName(@RequestParam("teacher_name") String teacherName){
        return lectureService.getLectureByTeacher(teacherName);
    }

    @GetMapping("/lecture/{teacher_id}")
    public List<Object[]> getLectureByTeacherId(@RequestParam("teacher_id") Long id){
        return lectureService.getLectureByTeacherId(id);
    }

    @GetMapping("/lecture/{subject}")
    public List<Object[]> getLectureBySubjectName(@RequestParam("subject") String subject){
        return lectureService.getLectureBySubject(subject);
    }

    @GetMapping("/lecture/{time}")
    public List<Object[]> getLectureByTime(@RequestParam("time") int time){
        return lectureService.getLectureByTime(time);
    }

    @GetMapping("/lecture/{classroom}")
    public List<Object[]> getLectureByClassroom(@RequestParam("classroom") String classroom){
        return lectureService.getLectureByClassroom(classroom);
    }

    @GetMapping("/lecture/{studentsplaces}")
    public List<Object[]> getLectureByStudentsPlaces(@RequestParam("studentsplaces") int studentsPlaces){
        return lectureService.getLectureByTime(studentsPlaces);
    }
}
