package com.salottoinformatica.workshift;

import com.salottoinformatica.workshift.jpa.entity.EmployeePersonalData;
import com.salottoinformatica.workshift.jpa.entity.EmployeeShifts;
import com.salottoinformatica.workshift.jpa.entity.EmployeeSkills;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WorkShiftApplicationTests {

    private List<EmployeeShifts> shifts;


    @Test
    void contextLoads() {
    }

    @Test
    public void testEmployeeWorkHours() {
        // Create an instance of the Employee class and a list of Shifts
      //  EmployeePersonalData employee = new EmployeePersonalData(123);
        EmployeeSkills shopA = new EmployeeSkills("Shop A");
        EmployeeSkills shopB = new EmployeeSkills("Shop B");
        Timestamp startTime = Timestamp.valueOf("2023-10-11 08:00:00");
        Timestamp endTime = Timestamp.valueOf("2023-10-11 14:00:00");
        List<EmployeeShifts> shifts = new ArrayList<>();

        Set<EmployeePersonalData> employeePersonalData = getEmployeePersonalData();

        Timestamp startShiftTimestamp = Timestamp.valueOf("2023-10-26 09:00:00");
        Timestamp endShiftTimestamp = Timestamp.valueOf("2023-10-26 17:00:00");

        // Duration in hours
        int duration = 0;

        // Whether it's a holiday or weekend (true or false)
        boolean isHoliday = false;
        boolean isWeekend = false;


        long timeDifferenceMillis = endTime.getTime() - startTime.getTime();

        // Calculate hours, minutes, and seconds
        long seconds = (timeDifferenceMillis / 1000) % 60;
        long minutes = (timeDifferenceMillis / (1000 * 60)) % 60;
        long hours = (timeDifferenceMillis / (1000 * 60 * 60)) % 24;

        System.out.println("Time Difference: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");

        shifts.add(new EmployeeShifts(startTime,endTime, (int) hours,false,false,employeePersonalData));  // Reena works 8 hours in Shop

        // Calculate the total hours worked in a day
        int totalHours = 0;
        for (EmployeeShifts shift : shifts) {
            totalHours += shift.getDuration();
            System.out.println("totalHours" + totalHours);
        }

        // Assert that the total hours worked in a day is not more than 8
        assertFalse(totalHours > 8, "Employee worked more than 8 hours in a day.");
    }

    private static Set<EmployeePersonalData> getEmployeePersonalData() {
        EmployeeSkills skill1 = new EmployeeSkills("Java Programming");
        EmployeeSkills skill2 = new EmployeeSkills("Database Management");
        EmployeeSkills skill3 = new EmployeeSkills("quality assurance");

        // Create a Set of EmployeeSkills
        Set<EmployeeSkills> skills = new HashSet<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        // Create an instance of EmployeePersonalData
        EmployeePersonalData employeeData = new EmployeePersonalData(
                "Reena", "chaturvedi", 35, "Software Developer", true, false, skills
        );

        EmployeePersonalData employeeData1 = new EmployeePersonalData(
                "Sub", "chaturvedi", 30, "Database Management", true, false, skills
        );
        // Add shifts to the employee's schedule

        Set<EmployeePersonalData>  employeePersonalData = new HashSet<>();
        employeePersonalData.add(employeeData);
        employeePersonalData.add(employeeData1);
        return employeePersonalData;
    }


    @Test
    public void testUserCannotWorkMoreThan5DaysInARowInSameShop() {
     //   EmployeePersonalData employeePersonalData = new EmployeePersonalData(123);
        Timestamp startTime = Timestamp.valueOf("2023-10-11 08:00:00");
        Timestamp endTime = Timestamp.valueOf("2023-10-11 14:00:00");
        EmployeeSkills shopA = new EmployeeSkills("Shop A");
        LocalDateTime now = LocalDateTime.now();
        long timeDifferenceMillis = endTime.getTime() - startTime.getTime();

        // Calculate hours, minutes, and seconds
        long seconds = (timeDifferenceMillis / 1000) % 60;
        long minutes = (timeDifferenceMillis / (1000 * 60)) % 60;
        long hours = (timeDifferenceMillis / (1000 * 60 * 60)) % 24;



        EmployeeSkills skill1 = new EmployeeSkills("Java Programming");
        EmployeeSkills skill2 = new EmployeeSkills("Database Management");
        EmployeeSkills skill3 = new EmployeeSkills("quality assurance");

        // Create a Set of EmployeeSkills
        Set<EmployeeSkills> skills = new HashSet<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);


        System.out.println("Time Difference: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
        EmployeePersonalData employeeData = new EmployeePersonalData(
                "Reena", "chaturvedi", 35, "Software Developer", true, false, skills
        );

        EmployeePersonalData employeeData1 = new EmployeePersonalData(
                "Sub", "chaturvedi", 30, "Database Management", true, false, skills
        );

        Set<EmployeePersonalData>  employeePersonalData = new HashSet<>();
        employeePersonalData.add(employeeData);
        employeePersonalData.add(employeeData1);
        for (int i = 0; i < 5; i++) {
            shifts.add(new EmployeeShifts(startTime,endTime, (int) hours,false,false,employeePersonalData));  // Reena works 8 hours in Shop

        }

        assertFalse(canWorkInShop(shopA));

        EmployeeShifts sixthDayShift = new EmployeeShifts((EmployeePersonalData) employeePersonalData, shopA, now.plusDays(5), now.plusDays(5).plusHours(8));
        assertFalse(canWorkInShop(shopA));
        employeePersonalData.remove(employeePersonalData.size() - 1); // Remove the last shift
        assertTrue(canWorkInShop(shopA));
      //  employeePersonalData.add(sixthDayShift);
       // assertFalse(canWorkInShop(shopA));
    }



    @Test
    public void testUserCannotWorkInSameShopForMoreThan8HoursIn24HourWindow() {
        EmployeePersonalData user = new EmployeePersonalData(123);
        LocalDateTime now = LocalDateTime.now();

        EmployeeSkills shopA = new EmployeeSkills("Shop A");
        EmployeeShifts shift1 = new EmployeeShifts();

        EmployeeShifts shift2 = new EmployeeShifts();
        assertTrue(canWorkInShop(shopA));
        shifts.add(shift1);
        assertFalse(canWorkInShop(shopA));
        shifts.remove(shift1);
        assertTrue(canWorkInShop(shopA));
        shifts.add(shift2);
        assertFalse(canWorkInShop(shopA));
    }

    @Test
    public void testUserCanWorkInDifferentShops() {
        EmployeePersonalData user = new EmployeePersonalData(123);
        EmployeeSkills shopA = new EmployeeSkills("Shop A");
        EmployeeSkills shopB = new EmployeeSkills("Shop B");

        assertTrue(canWorkInShop(shopA));
        assertTrue(canWorkInShop(shopB));
    }


    public boolean canWorkInShop(EmployeeSkills shop) {

        List<EmployeeSkills> skills = new ArrayList<>();
        List<EmployeeShifts> shifts = new ArrayList<>();

        // Rule 1: A user can work in different shops
        for (EmployeeSkills skill : skills) {
            if (skill.getSkillName().equals(shop)) {
                return false; // User is already working in the same shop
            }
        }
        // Rule 1: A user can work in different shops


        // Rule 2: A user cannot work in multiple shops at the same time
        for (EmployeeShifts shift : shifts) {
            if (shift.getEndShift().after(Timestamp.valueOf(LocalDateTime.now()))) {
                return false; // User is already working in another shop
            }
        }


        // Add more rules here if needed

        return true; // User can work in the shop
    }
}





