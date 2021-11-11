package com.console.university.service;

import java.util.List;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);

    String getDepartmentStats(String departmentName);

    String getAvgDepartmentSalary(String departmentName);

    String getDepartmentEmployeesCount(String departmentName);

    List<String> getAllDepartments();
}
