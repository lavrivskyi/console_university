package com.console.university.repository;

import com.console.university.model.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, Long> {
    Optional<Department> findDepartmentByName(String name);
}
