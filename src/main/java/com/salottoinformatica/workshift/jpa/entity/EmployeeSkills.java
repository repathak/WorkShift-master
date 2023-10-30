package com.salottoinformatica.workshift.jpa.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="employeeSkills")
public class EmployeeSkills {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="skillName")
    private String skillName;

    @ManyToMany(mappedBy = "employeeSkills")
    Set<EmployeePersonalData> employeePersonalData;

    public EmployeeSkills() {

    }
    public EmployeeSkills(String skillName) {
        this.skillName = skillName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
