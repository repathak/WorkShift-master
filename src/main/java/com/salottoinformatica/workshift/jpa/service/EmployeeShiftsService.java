package com.salottoinformatica.workshift.jpa.service;


import com.salottoinformatica.workshift.jpa.entity.EmployeeShifts;
import com.salottoinformatica.workshift.jpa.repository.EmployeeShiftsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeShiftsService {

    private final EmployeeShiftsRepository employeeShiftsRepository;

    public EmployeeShiftsService(EmployeeShiftsRepository employeeShiftsRepository) {
        this.employeeShiftsRepository = employeeShiftsRepository;
    }

    /**
     *
     * @return: employeeShiftsList - the list containing all the employeeShiftsList
     */
    public List<EmployeeShifts> getAllEmployeeShifts(){
        List <EmployeeShifts> employeeShiftsList = new ArrayList<>();
        employeeShiftsRepository.findAll()
                .forEach(employeeShiftsList::add);

        return employeeShiftsList;
    }

    /**
     *
     * @param newShiftsData: newShiftsData to be stored in db
     */
    public void addEmployeeShifts(EmployeeShifts newShiftsData) {
    	employeeShiftsRepository.save(newShiftsData);
    }

    /**
     *
     *
     * @param id: id of the shifts to be searched
     * @return: the data of the shifts
     */
    public EmployeeShifts getEmployeeShifts(String id) {
        return employeeShiftsRepository.findById(id).get();
    }



}
