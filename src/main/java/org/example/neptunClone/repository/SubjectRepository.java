package org.example.neptunClone.repository;


import org.example.neptunClone.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// extends JpaRepository<Subject, Long>
public interface SubjectRepository{

    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    public List<Object[]> getSubject();

    @Query(value = "SELECT * FROM subject WHERE id=?1", nativeQuery = true)
    public Subject getSubjectById(Long name);

    @Query(value = "SELECT * FROM subject WHERE name=?1", nativeQuery = true)
    public Subject getSubjectByName(String name);
}
