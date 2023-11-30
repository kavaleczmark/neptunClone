package org.example.neptunClone.controller;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Lecture;
import org.example.neptunClone.service.impl.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    private LectureService lectureService;


    /*          READ         */

    @GetMapping(path = "/")
    public List<Lecture> getAllLecture() throws SQLException {
        return lectureService.getAllLecture();
    }

    @GetMapping(path = "/{id}")
    public Lecture getLectureById(@PathVariable int id) throws SQLException {
        return lectureService.getLecturerById(id);
    }

    @GetMapping(path = "/teacher_id", params = "teacherId")
    public List<Lecture> getLectureByTeacherId(@RequestParam("teacherId") int id) throws SQLException {
        return lectureService.getLectureByTeacherId(id);
    }

    @GetMapping(path = "/subject_id", params = "subjectId")
    public List<Lecture> getLectureBySubjectId(@RequestParam("subjectId") int id) throws SQLException {
        return lectureService.getLectureBySubjectId(id);
    }
    @GetMapping(path = "/classroom_id", params = "classroomId")
    public List<Lecture> getLectureByClassroom(@RequestParam("classroomId") int id) throws SQLException {
        return lectureService.getLectureByClassroomId(id);
    }

    @GetMapping(path = "/time", params = "time")
    public List<Lecture> getLectureByTime(@RequestParam("time") int time) throws SQLException {
        return lectureService.getLectureByTime(time);
    }

    @GetMapping(path = "/places", params = "count")
    public List<Lecture> getLectureByStudentsPlaces(@RequestParam("count") int places) throws SQLException {
        return lectureService.getLectureByStudentsPlaces(places);
    }

    /*          CREATE         */

    @PostMapping(path = "/")
    public ResponseEntity<Void> insertLecture(@RequestBody Lecture lecture) throws SQLException {
        boolean result = lectureService.addLecture(lecture);
        if (result) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }

    /*          UPDATE         */

    @PutMapping(path = "/", params = "id")
    public ResponseEntity<Void> updateLecture(@RequestBody Lecture newLecture, @RequestParam int id) throws SQLException {
        Lecture lecture = lectureService.getLecturerById(id);
        lecture.setTime(newLecture.getTime());
        lecture.setPlaces(newLecture.getPlaces());
        lecture.setTeacher_id(newLecture.getTeacher_id());
        lecture.setClassroom_id(newLecture.getClassroom_id());
        lecture.setSubject_id(newLecture.getSubject_id());
        if(lectureService.updateLecture(lecture)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }
}
