package com.salottoinformatica.workshift.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="employeePersonalData")
public class
EmployeePersonalData {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="age")
    private int age;

    @Column(name="task")
    private String task;

    @Column(name="seniority")
    private boolean seniority;

    @Column(name="isAssociate")
    private boolean isAssociate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "EMPLOYEE_PERSONAL_DATA_id"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_SKILLS_id"))
    Set<EmployeeSkills> employeeSkills;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "EMPLOYEE_PERSONAL_DATA_id"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_SHIFTS_id"))
    Set<EmployeeShifts> employeeShifts;

    public EmployeePersonalData() {

    }
    public EmployeePersonalData(String name, String surname, int age, String task, boolean seniority, boolean isAssociate, Set<EmployeeSkills> employeeSkills) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.task = task;
        this.seniority = seniority;
        this.isAssociate = isAssociate;
        this.employeeSkills = employeeSkills;
    }

    public EmployeePersonalData(long id) {
		this.id = id;
	}

    public EmployeePersonalData(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isSeniority() {
        return seniority;
    }

    public void setSeniority(boolean seniority) {
        this.seniority = seniority;
    }

    public boolean isAssociate() {
        return isAssociate;
    }

    public void setAssociate(boolean associate) {
        isAssociate = associate;
    }

    @Override
    public String toString() {
        return "EmployeePersonalData{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", surname=" + surname +
                ", age=" + age +
                ", task=" + task +
                ", seniority=" + seniority +
                ", isAssociate=" + isAssociate +
                '}';
    }
}
