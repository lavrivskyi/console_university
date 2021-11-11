package com.console.university.config;

import com.console.university.model.Degree;
import com.console.university.model.Department;
import com.console.university.model.Lector;
import com.console.university.repository.DepartmentsRepository;
import com.console.university.repository.LectorsRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final LectorsRepository lectorsRepository;
    private final DepartmentsRepository departmentsRepository;

    @Autowired
    public DataInitializer(LectorsRepository lectorsRepository,
                           DepartmentsRepository departmentsRepository) {
        this.lectorsRepository = lectorsRepository;
        this.departmentsRepository = departmentsRepository;
    }

    @PostConstruct
    public void init() {
        setData();
    }

    private void setData() {
        Lector semenSemenov = new Lector();
        semenSemenov.setName("Semen");
        semenSemenov.setLastName("Semenov");
        semenSemenov.setSalary(BigDecimal.valueOf(25500.0));
        semenSemenov.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector olesyaIvanova = new Lector();
        olesyaIvanova.setName("Olesya");
        olesyaIvanova.setLastName("Ivanova");
        olesyaIvanova.setSalary(BigDecimal.valueOf(27370.0));
        olesyaIvanova.setDegree(Degree.PROFESSOR);

        Lector stepanMelnyk = new Lector();
        stepanMelnyk.setName("Stepan");
        stepanMelnyk.setLastName("Melnyk");
        stepanMelnyk.setSalary(BigDecimal.valueOf(18770.0));
        stepanMelnyk.setDegree(Degree.ASSISTANT);

        Lector andriyKuzmenko = new Lector();
        andriyKuzmenko.setName("Andriy");
        andriyKuzmenko.setLastName("Kuzmenko");
        andriyKuzmenko.setSalary(BigDecimal.valueOf(17540.0));
        andriyKuzmenko.setDegree(Degree.ASSISTANT);

        Lector olenaBondarenko = new Lector();
        olenaBondarenko.setName("Olena");
        olenaBondarenko.setLastName("Bondarenko");
        olenaBondarenko.setSalary(BigDecimal.valueOf(20475.0));
        olenaBondarenko.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector romanShevchuk = new Lector();
        romanShevchuk.setName("Roman");
        romanShevchuk.setLastName("Shevchuk");
        romanShevchuk.setSalary(BigDecimal.valueOf(28770.0));
        romanShevchuk.setDegree(Degree.PROFESSOR);

        Lector petroKovalenko = new Lector();
        petroKovalenko.setName("Petro");
        petroKovalenko.setLastName("Kovalenko");
        petroKovalenko.setSalary(BigDecimal.valueOf(23770.0));
        petroKovalenko.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector marynaKoval = new Lector();
        marynaKoval.setName("Maryna");
        marynaKoval.setLastName("Koval");
        marynaKoval.setSalary(BigDecimal.valueOf(29770.0));
        marynaKoval.setDegree(Degree.PROFESSOR);

        Lector dmytroSavchuk = new Lector();
        dmytroSavchuk.setName("Dmytro");
        dmytroSavchuk.setLastName("Savchuk");
        dmytroSavchuk.setSalary(BigDecimal.valueOf(21650.0));
        dmytroSavchuk.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector bogdanPonomarenko = new Lector();
        bogdanPonomarenko.setName("Bogdan");
        bogdanPonomarenko.setLastName("Ponomarenko");
        bogdanPonomarenko.setSalary(BigDecimal.valueOf(15320.0));
        bogdanPonomarenko.setDegree(Degree.ASSISTANT);

        List<Lector> lectorList = List.of(semenSemenov, olesyaIvanova, petroKovalenko,
                stepanMelnyk, olenaBondarenko, romanShevchuk,
                andriyKuzmenko, marynaKoval, dmytroSavchuk, bogdanPonomarenko);
        lectorsRepository.saveAll(lectorList);

        Department chemistryDepartment = new Department();
        chemistryDepartment.setName("Chemistry");
        chemistryDepartment.setLectorsList(List.of(semenSemenov, olesyaIvanova, stepanMelnyk,
                andriyKuzmenko, marynaKoval, dmytroSavchuk));
        chemistryDepartment.setHeadLectorId(olesyaIvanova.getId());

        Department mathDepartment = new Department();
        mathDepartment.setName("Math");
        mathDepartment.setLectorsList(List.of(stepanMelnyk, olenaBondarenko, romanShevchuk,
                semenSemenov, olesyaIvanova, bogdanPonomarenko));
        mathDepartment.setHeadLectorId(olesyaIvanova.getId());

        Department physicsDepartment = new Department();
        physicsDepartment.setName("Physics");
        physicsDepartment.setLectorsList(List.of(andriyKuzmenko, marynaKoval, dmytroSavchuk,
                bogdanPonomarenko, stepanMelnyk, olenaBondarenko, romanShevchuk));
        physicsDepartment.setHeadLectorId(marynaKoval.getId());

        List<Department> departmentList = List.of(chemistryDepartment, mathDepartment, physicsDepartment);
        departmentsRepository.saveAll(departmentList);
    }
}
