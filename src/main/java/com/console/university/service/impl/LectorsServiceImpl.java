package com.console.university.service.impl;

import com.console.university.model.Lector;
import com.console.university.repository.LectorsRepository;
import com.console.university.service.LectorsService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorsServiceImpl implements LectorsService {
    private final LectorsRepository lectorsRepository;

    @Autowired
    public LectorsServiceImpl(LectorsRepository lectorsRepository) {
        this.lectorsRepository = lectorsRepository;
    }

    @Override
    public List<String> getAllLectors() {
        return lectorsRepository.findAll().stream()
                .map(lector -> lector.getName() + " "
                        + lector.getLastName())
                .collect(Collectors.toList());
    }

    @Override
    public Lector getById(Long id) {
        return lectorsRepository.getLectorById(id).orElseThrow(() ->
                new RuntimeException("Can't get lector by id: " + id));
    }
}
