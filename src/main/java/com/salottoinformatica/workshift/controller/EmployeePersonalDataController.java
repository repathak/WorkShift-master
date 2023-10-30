package com.salottoinformatica.workshift.controller;

import com.salottoinformatica.workshift.jpa.entity.EmployeePersonalData;
import com.salottoinformatica.workshift.jpa.entity.EmployeeSkills;
import com.salottoinformatica.workshift.jpa.service.EmployeePersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class EmployeePersonalDataController {
    private final EmployeePersonalDataService employeePersonalDataService;

    public EmployeePersonalDataController(EmployeePersonalDataService employeePersonalDataService) {
        this.employeePersonalDataService = employeePersonalDataService;
    }

    @RequestMapping("/employee")
    public List<EmployeePersonalData> getAllEmployeePersonalData(){
        return employeePersonalDataService.getAllEmployeePersonalDataService();
    }

    @RequestMapping("/employeePersonalData/{id}")
    public EmployeePersonalData getEmployeePersonalData(@PathVariable String id) {
        return employeePersonalDataService.getEmployeePersonalData(id);
    }

    @RequestMapping("/employeeAdd/{name}/{surname}/{age}/{task}/{seniority}/{isAssociate}/{skillName}")
    public void addEmployeePersonalData(@PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String task, @PathVariable boolean seniority, @PathVariable boolean isAssociate, @PathVariable String skillName) {
        HashSet<EmployeeSkills> skills = new HashSet<EmployeeSkills>();
        skills.add(new EmployeeSkills(skillName));
        employeePersonalDataService.addEmployeePersonalData(new EmployeePersonalData(name, surname, age, task, seniority, isAssociate, skills));
    }



}
