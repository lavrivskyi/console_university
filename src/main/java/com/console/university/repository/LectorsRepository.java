package com.console.university.repository;

import com.console.university.model.Lector;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorsRepository extends JpaRepository<Lector, Long> {
    Optional<Lector> getLectorById(Long id);

    @Query(value = "SELECT DISTINCT l FROM Lector l WHERE LOWER(l.lastName) LIKE %?1% OR LOWER(l.name) LIKE %?1%")
    List<Lector> getLectorsByNameIsLikeAOrLastNameLike(String template);
}
