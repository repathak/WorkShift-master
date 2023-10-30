package com.salottoinformatica.workshift.jpa.service;


import com.salottoinformatica.workshift.jpa.entity.EmployeeSkills;
import com.salottoinformatica.workshift.jpa.repository.EmployeeSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSkillsService {

    private final EmployeeSkillsRepository employeeSkillsRepository;

    public EmployeeSkillsService(EmployeeSkillsRepository employeeSkillsRepository) {
        this.employeeSkillsRepository = employeeSkillsRepository;
    }

    /**
     *
     * @return: employeePersonalDataList - the list containing all the employeePersonalDataList
     */
    public List<EmployeeSkills> getAllEmployeeSkills(){
        List <EmployeeSkills> employeePersonalDataList = new ArrayList<>();
        employeeSkillsRepository.findAll()
                .forEach(employeePersonalDataList::add);

        return employeePersonalDataList;
    }

    /**
     *
     * @param newEmployeePersonalData: newEmployeePersonalData to be stored in db
     */
    public void addEmployeeSkills(EmployeeSkills newEmployeePersonalData) {
        employeeSkillsRepository.save(newEmployeePersonalData);
    }

    /**
     *
     *
     * @param id: id of the league to be searched
     * @return: the data of the league
     */
    public EmployeeSkills getEmployeeSkills(String id) {
        return employeeSkillsRepository.findById(id).get();
    }



}
