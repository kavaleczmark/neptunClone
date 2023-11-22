package org.example.neptunClone.service;

import org.example.neptunClone.Model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectServiceInterface {
    List<Object[]> getAllSubject();
    Optional<Subject> getSubjectById(Long id);
    Subject getSubjectByName(String name);
}
