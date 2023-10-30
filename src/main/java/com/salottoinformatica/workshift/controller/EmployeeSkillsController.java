package com.salottoinformatica.workshift.controller;

import com.salottoinformatica.workshift.jpa.entity.EmployeeSkills;
import com.salottoinformatica.workshift.jpa.service.EmployeeSkillsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeSkillsController {
    private final EmployeeSkillsService employeeSkillsService;

    public EmployeeSkillsController(EmployeeSkillsService employeeSkillsService) {
        this.employeeSkillsService = employeeSkillsService;
    }

    @RequestMapping("/employeeSkills")
    public List<EmployeeSkills> getAllEmployeePersonalData(){
        return employeeSkillsService.getAllEmployeeSkills();
    }

    @RequestMapping("/employeeSkills/{id}")
    public EmployeeSkills getEmployeePersonalData(@PathVariable String id) {
        return employeeSkillsService.getEmployeeSkills(id);
    }
}
