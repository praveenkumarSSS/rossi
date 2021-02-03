package com.hospital.enquiry.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class AdmisssionVacancy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
    private String exsistingPatientName;
	
	private String patientStatus;
	
	
	private String hospitalName;
	
	private int totalnoOfBeds;
	
	private int noOfBedsAvailable;

	private LocalDate dischargeDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExsistingPatientName() {
		return exsistingPatientName;
	}

	public void setExsistingPatientName(String exsistingPatientName) {
		this.exsistingPatientName = exsistingPatientName;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getTotalnoOfBeds() {
		return totalnoOfBeds;
	}

	public void setTotalnoOfBeds(int totalnoOfBeds) {
		this.totalnoOfBeds = totalnoOfBeds;
	}

	public int getNoOfBedsAvailable() {
		return noOfBedsAvailable;
	}

	public void setNoOfBedsAvailable(int noOfBedsAvailable) {
		this.noOfBedsAvailable = noOfBedsAvailable;
	}

	public LocalDate getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public AdmisssionVacancy(String exsistingPatientName, String patientStatus, String hospitalName,
			int totalnoOfBeds, int noOfBedsAvailable, LocalDate dischargeDate) {
		super();
		//this.id = id;
		this.exsistingPatientName = exsistingPatientName;
		this.patientStatus = patientStatus;
		this.hospitalName = hospitalName;
		this.totalnoOfBeds = totalnoOfBeds;
		this.noOfBedsAvailable = noOfBedsAvailable;
		this.dischargeDate = dischargeDate;
	}

	public AdmisssionVacancy() {
		super();
		// TODO Auto-generated constructor stub
	}

}

