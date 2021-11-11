package com.console.university.service.impl;

import com.console.university.model.Degree;
import com.console.university.model.Department;
import com.console.university.model.Lector;
import com.console.university.repository.DepartmentsRepository;
import com.console.university.service.DepartmentService;
import com.console.university.service.LectorsService;
import com.console.university.service.StringService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentsRepository departmentsRepository;
    private final LectorsService lectorsService;

    public DepartmentServiceImpl(DepartmentsRepository departmentsRepository,
                                 LectorsService lectorsService) {
        this.departmentsRepository = departmentsRepository;
        this.lectorsService = lectorsService;
    }

    @Override
    public String getHeadOfDepartment(String departmentName) {
        Department departmentByName = getDepartment(departmentName);
        Lector lector = lectorsService.getById(departmentByName.getHeadLectorId());
        return lector.getName() + " " + lector.getLastName();
    }

    @Override
    public String getDepartmentStats(String departmentName) {
        Department departmentByName = getDepartment(departmentName);
        List<Lector> lectorsList = departmentByName.getLectorsList();
        int assistantsNumber = getStaffNumber(lectorsList, Degree.ASSISTANT);
        int associateProfessorsNumber = getStaffNumber(lectorsList, Degree.ASSOCIATE_PROFESSOR);
        int professorsNumber = getStaffNumber(lectorsList, Degree.PROFESSOR);
        return "assistants - " + assistantsNumber + "\n"
                + "associate professors - " + associateProfessorsNumber + "\n"
                + "professors - " + professorsNumber;
    }

    @Override
    public String getAvgDepartmentSalary(String departmentName) {
        Department departmentByName = getDepartment(departmentName);
        List<Lector> lectorsList = departmentByName.getLectorsList();
        double averageSalary = lectorsList.stream()
                .map(Lector::getSalary)
                .mapToDouble(Number::shortValue)
                .average()
                .orElse(0);
        return "The average salary of " + departmentName + " is " + averageSalary;

    }

    @Override
    public String getDepartmentEmployeesCount(String departmentName) {
        return String.valueOf(getDepartment(departmentName).getLectorsList().size());
    }

    @Override
    public List<String> getAllDepartments() {
        return departmentsRepository.findAll().stream()
                .map(Department::getName)
                .collect(Collectors.toList());
    }

    private Department getDepartment(String departmentName) {
        return departmentsRepository
                .findDepartmentByName(StringService.capitalize(departmentName.toLowerCase()))
                .orElseThrow(() ->
                        new RuntimeException("Can't get department by name: " + departmentName));
    }

    private int getStaffNumber(List<Lector> lectorsList, Degree degree) {
        return (int) lectorsList.stream()
                .filter(lector -> lector.getDegree().equals(degree))
                .count();
    }
}
