package com.hospital.enquiry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpecialistInfo {
	
	
	@Id
	@GeneratedValue
	private String specialistId;

	private String specialistName;
	
	private String patientName;
	
	private String appointmentDay;
	
	private String appointmentTime;

	public String getSpecialistName() {
		return specialistName;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAppointmentDay() {
		return appointmentDay;
	}

	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public SpecialistInfo(String specialistName, String patientName, String appointmentDay, String appointmentTime) {
		super();
		this.specialistName = specialistName;
		this.patientName = patientName;
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
	}

	public SpecialistInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
	

