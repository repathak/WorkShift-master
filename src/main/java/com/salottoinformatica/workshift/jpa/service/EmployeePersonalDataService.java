package com.salottoinformatica.workshift.jpa.service;

import com.salottoinformatica.workshift.jpa.entity.EmployeePersonalData;
import com.salottoinformatica.workshift.jpa.repository.EmployeePersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePersonalDataService {

    private final EmployeePersonalDataRepository employeePersonalDataRepository;

    public EmployeePersonalDataService(EmployeePersonalDataRepository employeePersonalDataRepository) {
        this.employeePersonalDataRepository = employeePersonalDataRepository;
    }

    /**
     *
     * @return: employeePersonalDataList - the list containing all the employeePersonalDataList
     */
    public List<EmployeePersonalData> getAllEmployeePersonalDataService(){
        List <EmployeePersonalData> employeePersonalDataList = new ArrayList<>();
        employeePersonalDataRepository.findAll()
                .forEach(employeePersonalDataList::add);

        return employeePersonalDataList;
    }

    /**
     *
     * @param newEmployeePersonalData: newEmployeePersonalData to be stored in db
     */
    public void addEmployeePersonalData(EmployeePersonalData newEmployeePersonalData) {
        employeePersonalDataRepository.save(newEmployeePersonalData);
    }

    /**
     *
     *
     * @param id: id of the league to be searched
     * @return: the data of the league
     */
    public EmployeePersonalData getEmployeePersonalData(String id) {
        return employeePersonalDataRepository.findById(id).get();
    }


}
