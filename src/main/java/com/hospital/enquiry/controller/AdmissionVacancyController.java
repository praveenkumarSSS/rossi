package com.hospital.enquiry.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.enquiry.dao.AdmissionVacancyDao;
import com.hospital.enquiry.model.AdmisssionVacancy;
import com.inventoryManagement.project.exceptionData.EnquiryException;

@RestController
public class AdmissionVacancyController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<AdmisssionVacancy> admissioninfo = new ArrayList<AdmisssionVacancy>();
    
	@Autowired
	AdmissionVacancyDao admissionVacancyDaos;

	@GetMapping("/admissionVacancy")
	
	public List<AdmisssionVacancy> infos(AdmisssionVacancy infoVacancy) throws EnquiryException {
		AdmisssionVacancy vacancies = new AdmisssionVacancy("Naveen", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 13));
		AdmisssionVacancy vacancies2 = new AdmisssionVacancy("Gokul", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 14));
		AdmisssionVacancy vacancies3 = new AdmisssionVacancy("Kumar", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 15));
		AdmisssionVacancy vacancies4 = new AdmisssionVacancy("David", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 16));
		AdmisssionVacancy vacancies10 = new AdmisssionVacancy("Mahi", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 17));
		AdmisssionVacancy vacancies5 = new AdmisssionVacancy("Ramesh", "Discharge", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 9));
		AdmisssionVacancy vacancies6 = new AdmisssionVacancy("Siva", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 11));
		AdmisssionVacancy vacancies7 = new AdmisssionVacancy("Nirmal", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 12));
		AdmisssionVacancy vacancies8 = new AdmisssionVacancy("Dinakar", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 17));
		AdmisssionVacancy vacancies9 = new AdmisssionVacancy("yaser", "Occupied", "Apollo", 10, 10,
				LocalDate.of(2020, 10, 13));

		admissioninfo.add(vacancies);
		admissioninfo.add(vacancies2);
		admissioninfo.add(vacancies3);
		admissioninfo.add(vacancies4);
		admissioninfo.add(vacancies5);
		admissioninfo.add(vacancies6);
		admissioninfo.add(vacancies7);
		admissioninfo.add(vacancies8);
		admissioninfo.add(vacancies9);
		admissioninfo.add(vacancies10);

		return admissionVacancyDaos.saveAll(admissioninfo);

	}
	


@Cacheable(value="usersCache", key="#patientStatus")
@GetMapping("/admissionVacancy/{patientStatus}")
public ResponseEntity<String> info(@PathVariable String patientStatus,String hospitalName) throws EnquiryException
{
	List<AdmisssionVacancy> vacancyInfo=infos(null);
	 
	 long count=vacancyInfo.stream().count();
	 
	if(patientStatus.equalsIgnoreCase("Discharge"))
		  {
		 long discharge=patientStatus.length();
		 long countNumberOfBed=count;
		 long occupied=countNumberOfBed-discharge;
		 long BedAvailability=countNumberOfBed-occupied;
   return new ResponseEntity<String>("number of bed is =" + count + "\n" + "discharge=" + occupied + "\n" +
	  "Number of Beds Available="+ BedAvailability , HttpStatus.OK); 
	  
	   }
		
		/*
		 * if(patientStatus.equalsIgnoreCase("Occupied")) { return new
		 * ResponseEntity<String>("Occupied=" + (count-1),HttpStatus.OK);
		 * 
		 * }
		 */
	  return null;
	  }
}

