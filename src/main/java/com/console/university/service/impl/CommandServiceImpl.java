package com.console.university.service.impl;

import com.console.university.service.CommandService;
import com.console.university.service.DepartmentService;
import com.console.university.service.GlobalSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {
    private static final String COMMAND_HEAD_TEMPLATE = "who\\s{1}is\\s{1}head\\s{1}of\\s{1}\\w+\\s{1}\\w+";
    private static final String COMMAND_STATS_TEMPLATE = "show\\s{1}\\w+\\s{1}statistics";
    private static final String COMMAND_AVG_SALARY_TEMPLATE = "show\\s{1}the\\s{1}average\\s{1}salary"
            + "\\s{1}for\\s{1}the\\s{1}department\\s{1}\\w+";
    private static final String COMMAND_EMPLOYEES_COUNT_TEMPLATE = "show\\s{1}count\\s{1}of\\s{1}employee\\s{1}for\\s{1}\\w+";
    private static final String COMMAND_GLOBAL_SEARCH_TEMPLATE = "global\\s{1}search\\s{1}by\\s{1}\\w+";
    private final DepartmentService departmentService;
    private final GlobalSearchService globalSearchService;

    @Autowired
    public CommandServiceImpl(DepartmentService departmentService,
                              GlobalSearchService globalSearchService) {
        this.departmentService = departmentService;
        this.globalSearchService = globalSearchService;
    }

    @Override
    public String processCommand(String input) {
        if (input.toLowerCase().matches(COMMAND_HEAD_TEMPLATE)) {
            return departmentService
                    .getHeadOfDepartment(input.substring(input.lastIndexOf(" ") + 1));
        }
        if (input.toLowerCase().matches(COMMAND_STATS_TEMPLATE)) {
            return departmentService.getDepartmentStats(input.split(" ")[1]);
        }
        if (input.toLowerCase().matches(COMMAND_AVG_SALARY_TEMPLATE)) {
            return departmentService
                    .getAvgDepartmentSalary(input.substring(input.lastIndexOf(" ") + 1));
        }
        if (input.toLowerCase().matches(COMMAND_EMPLOYEES_COUNT_TEMPLATE)) {
            return departmentService
                    .getDepartmentEmployeesCount(input.substring(input.lastIndexOf(" ") + 1));
        }
        if (input.toLowerCase().matches(COMMAND_GLOBAL_SEARCH_TEMPLATE)) {
            return globalSearchService
                    .getGlobalSearchResult(input.substring(input.lastIndexOf(" ") + 1));
        }
        return "Repeat please";
    }

}
