package com.console.university;

import com.console.university.service.CommandService;
import com.console.university.service.DepartmentService;
import com.console.university.service.LectorsService;
import java.util.Objects;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleUniversityApplication implements CommandLineRunner {
    private final DepartmentService departmentService;
    private final LectorsService lectorsService;
    private final CommandService commandService;

    public ConsoleUniversityApplication(DepartmentService departmentService,
                                        LectorsService lectorsService,
                                        CommandService commandService) {
        this.departmentService = departmentService;
        this.lectorsService = lectorsService;
        this.commandService = commandService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleUniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Our lectors:");
        lectorsService.getAllLectors().forEach(System.out::println);
        System.out.println();

        System.out.println("Our departments:");
        departmentService.getAllDepartments().forEach(System.out::println);
        System.out.println();

        System.out.println("Available commands:");
        System.out.println("Who is head of department {department_name}");
        System.out.println("Show {department_name} statistics");
        System.out.println("Show the average salary for the department {department_name}");
        System.out.println("Show count of employee for {department_name}");
        System.out.println("Global search by {template}");
        System.out.println("Exit");
        System.out.println();

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!Objects.equals(input.toLowerCase(), "exit")) {
            System.out.println("Enter command:");
            input = scanner.nextLine();
            System.out.println(commandService.processCommand(input));
        }
    }
}
