package com.salottoinformatica.workshift;

import com.salottoinformatica.workshift.jpa.entity.EmployeePersonalData;
import com.salottoinformatica.workshift.jpa.entity.EmployeeShifts;
import com.salottoinformatica.workshift.jpa.entity.EmployeeSkills;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WorkShiftApplication {

    //static Timestamp startTime = Timestamp.valueOf(LocalDateTime.now());
    public static void main(String[] args) {
        SpringApplication.run(WorkShiftApplication.class);
    }

}


