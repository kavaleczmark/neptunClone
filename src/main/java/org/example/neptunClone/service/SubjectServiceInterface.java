package org.example.neptunClone.service;

import org.example.neptunClone.model.Subject;

import java.util.List;

public interface SubjectServiceInterface {
    List<Object[]> getAllSubject();
    Subject getSubjectById(Long id);
    Subject getSubjectByName(String name);
}
