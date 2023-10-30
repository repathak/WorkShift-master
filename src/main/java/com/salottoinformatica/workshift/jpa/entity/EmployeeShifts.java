package com.salottoinformatica.workshift.jpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="employeeShifts")
public class EmployeeShifts {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="startShift")
    private Timestamp startShift;
    
    @Column(name="endShift")
    private Timestamp endShift;
    
    @Column(name="duration")
    private int duration;
    
    @Column(name="isHoliday")
    private boolean isHoliday;
    
    @Column(name="isWeekend")
    private boolean isWeekend;

    @ManyToMany(mappedBy = "employeeShifts")
    Set<EmployeePersonalData> employeePersonalData;

    public EmployeeShifts() {

    }

	public EmployeeShifts(Timestamp startShift, Timestamp endShift, int duration, boolean isHoliday,
			boolean isWeekend, Set<EmployeePersonalData> employeePersonalData) {
		this.startShift = startShift;
		this.endShift = endShift;
		this.duration = duration;
		this.isHoliday = isHoliday;
		this.isWeekend = isWeekend;
		this.employeePersonalData = employeePersonalData;
	}

	public EmployeeShifts(EmployeePersonalData employeePersonalData, EmployeeSkills shopName, LocalDateTime localDateTime, LocalDateTime localDateTime1) {
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getStartShift() {
		return startShift;
	}

	public void setStartShift(Timestamp startShift) {
		this.startShift = startShift;
	}

	public Timestamp getEndShift() {
		return endShift;
	}

	public void setEndShift(Timestamp endShift) {
		this.endShift = endShift;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public boolean isWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}


}
