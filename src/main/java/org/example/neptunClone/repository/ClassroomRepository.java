package org.example.neptunClone.repository;

import org.example.neptunClone.model.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository {

    @Query(value="SELECT * FROM classroom", nativeQuery = true)
    public List<Object[]> getClassroom();

    @Query(value="SELECT * FROM classroom WHERE id='?1'", nativeQuery = true)
    public Classroom getClassroomById(Long id);

    @Query(value="SELECT * FROM classroom WHERE name='?1'", nativeQuery = true)
    public Classroom getClassroomByName(String name);

    @Query(value="SELECT * FROM classroom WHERE places='?1'", nativeQuery = true)
    public Classroom getClassroomByPlaces(int places);

}
