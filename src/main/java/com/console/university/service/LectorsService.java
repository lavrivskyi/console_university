package com.console.university.service;

import com.console.university.model.Lector;
import java.util.List;

public interface LectorsService {
    public List<String> getAllLectors();

    public Lector getById(Long id);
}
