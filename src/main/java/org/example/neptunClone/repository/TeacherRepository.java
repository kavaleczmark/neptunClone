package org.example.neptunClone.repository;

import org.example.neptunClone.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository{
    @Query(value="SELECT * FROM teacher", nativeQuery = true)
    public List<Object[]> getTeacher();

    @Query(value="SELECT * FROM teacher WHERE id='?1'", nativeQuery = true)
    public Teacher getTeacherById(Long id);

    @Query(value="SELECT * FROM teacher WHERE name='?1'", nativeQuery = true)
    public Teacher getTeacherByName(String name);

    @Query(value="SELECT * FROM teacher WHERE subject='?1'", nativeQuery = true)
    public Teacher getTeacherBySubject(String subject);

}
