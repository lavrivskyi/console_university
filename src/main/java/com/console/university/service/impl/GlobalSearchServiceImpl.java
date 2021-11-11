package com.console.university.service.impl;

import com.console.university.repository.LectorsRepository;
import com.console.university.service.GlobalSearchService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {
    private final LectorsRepository lectorsRepository;

    @Autowired
    public GlobalSearchServiceImpl(LectorsRepository lectorsRepository) {
        this.lectorsRepository = lectorsRepository;
    }

    @Override
    public String getGlobalSearchResult(String template) {
        return lectorsRepository.getLectorsByNameIsLikeAOrLastNameLike(template.toLowerCase())
                .stream()
                .map(lector -> lector.getName() + " " + lector.getLastName())
                .collect(Collectors.joining(", "));
    }
}
