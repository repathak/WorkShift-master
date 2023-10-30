package com.salottoinformatica.workshift.controller;

import com.salottoinformatica.workshift.jpa.entity.*;
import com.salottoinformatica.workshift.jpa.service.EmployeeShiftsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

@RestController
public class EmployeeShiftsController {
    private final EmployeeShiftsService employeeShiftsService;

    public EmployeeShiftsController(EmployeeShiftsService employeeShiftsService) {
        this.employeeShiftsService = employeeShiftsService;
    }

    @RequestMapping("/employeeShifts")
    public List<EmployeeShifts> getAllEmployeeShifts(){
        return employeeShiftsService.getAllEmployeeShifts();
    }

    @RequestMapping("/employeeShifts/{id}")
    public EmployeeShifts getEmployeeShifts(@PathVariable String id) {
        return employeeShiftsService.getEmployeeShifts(id);
    } 

    @RequestMapping("/employeeShiftAdd/{startShift}/{endShift}/{duration}/{isHoliday}/{isWeekend}/{idUtente}/{idUtente2}")
    public void addEmployeeShift(@PathVariable Timestamp startShift, @PathVariable Timestamp endShift, @PathVariable int duration, @PathVariable boolean isHoliday, @PathVariable boolean isWeekend, long idUtente1, long idUtente2) {
        HashSet<EmployeePersonalData> employees = new HashSet<EmployeePersonalData>();
        employees.add(new EmployeePersonalData(idUtente1));
        employees.add(new EmployeePersonalData(idUtente2));
    	employeeShiftsService.addEmployeeShifts(new EmployeeShifts(startShift,endShift,duration,isHoliday,isWeekend,employees));
    }
    
    //test
    @RequestMapping("/employeeShiftAddTest/{duration}/{isHoliday}/{isWeekend}/{idUtente1}/{idUtente2}")
    public void addEmployeeShiftTest( @PathVariable int duration, @PathVariable boolean isHoliday, @PathVariable boolean isWeekend, @PathVariable long idUtente1, @PathVariable long idUtente2) {
        HashSet<EmployeePersonalData> employees = new HashSet<EmployeePersonalData>();
        employees.add(new EmployeePersonalData(idUtente1));
        employees.add(new EmployeePersonalData(idUtente2));
    	employeeShiftsService.addEmployeeShifts(new EmployeeShifts(new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),duration,isHoliday,isWeekend,employees));
    }
}
