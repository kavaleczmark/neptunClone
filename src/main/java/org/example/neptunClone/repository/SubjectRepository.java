package org.example.neptunClone.repository;


import org.example.neptunClone.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    public List<Object[]> getSubject();

    @Query(value = "SELECT * FROM subject WHERE name=?1", nativeQuery = true)
    public Subject getSubjectByName(String name);
}
