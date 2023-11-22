package org.example.neptunClone.repository;

import org.example.neptunClone.Model.Classroom;
import org.example.neptunClone.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query(value="SELECT * FROM classroom", nativeQuery = true)
    public List<Object[]> getClassroom();

    @Query(value="SELECT * FROM classroom WHERE name='?1'", nativeQuery = true)
    public Classroom getClassroomByName(String name);

    @Query(value="SELECT * FROM classroom WHERE places='?1'", nativeQuery = true)
    public Classroom getClassroomByPlaces(int places);

}
