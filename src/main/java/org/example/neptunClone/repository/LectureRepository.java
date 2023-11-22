package org.example.neptunClone.repository;

import org.example.neptunClone.Model.Lecture;
import org.example.neptunClone.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query(value="SELECT * FROM lecture", nativeQuery = true)
    public List<Object[]> getLecture();

    @Query(value="SELECT * FROM lecture WHERE time=?1", nativeQuery = true)
    public List<Object[]> getLectureByTime(int time);

    @Query(value="SELECT * FROM lecture WHERE teacher_id=?1", nativeQuery = true)
    public List<Object[]> getLectureByTeacherId(int teacher_id);
    @Query(value="SELECT * FROM teacher JOIN lecture ON lecture.teacher_id=teacher.id WHERE teacher.name=?1", nativeQuery = true)
    public List<Object[]> getLectureByTeacherName(String name);

    @Query(value="SELECT * FROM lecture JOIN subject ON lecture.subject_id=subject.id WHERE subject.name=?1", nativeQuery = true)
    public List<Object[]> getLectureBySubjectName(String name);

    @Query(value="SELECT * FROM lecture WHERE classroom_id=?1", nativeQuery = true)
    public List<Object[]> getLectureByClassroomId(int classroom_id);

    @Query(value="SELECT * FROM teacher JOIN classroom ON lecture.classroom_id=classroom.id WHERE classroom.name=?1", nativeQuery = true)
    public List<Object[]> getLectureByClassroomName(String name);
    @Query(value="SELECT * FROM lecture WHERE students_places=?1", nativeQuery = true)
    public List<Object[]> getLectureByStudentsPlaces(int students_places);

}
