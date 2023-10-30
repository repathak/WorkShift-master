package com.salottoinformatica.workshift.jpa.repository;

import com.salottoinformatica.workshift.jpa.entity.EmployeePersonalData;
import org.springframework.data.repository.CrudRepository;

public interface EmployeePersonalDataRepository extends CrudRepository<EmployeePersonalData, String> {
}
