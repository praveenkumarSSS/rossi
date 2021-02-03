package com.hospital.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.enquiry.dao.SpecialistDao;
import com.hospital.enquiry.model.SpecialistInfo;
import com.inventoryManagement.project.exceptionData.EnquiryException;

@Service
@PropertySource("classpath:specialist.properties")
public class SpecialistService {
	
	@Autowired
	SpecialistDao daos;
	
	@Value("${specialistName}")
	private String specialistName;
	
	@Value("${patientName}")
	private String patientName;
	
	@Value("${appointmentDay}")
	private String appointmentDay;
	
	@Value("${appointmentTime}")
	private String appointmentTime;
	
	
	
	@SuppressWarnings("unused")
	@Cacheable(value="usersCache")
	public ResponseEntity<SpecialistInfo> specilaistData()throws EnquiryException
	{
		
	SpecialistInfo infos=null;
	
	infos=new SpecialistInfo();
	
	if(infos==null)
	{
		throw new EnquiryException("Specialist data not available"+ null);
	}
	
	
    infos.setSpecialistName(specialistName);
    infos.setPatientName(patientName);
    infos.setAppointmentDay(appointmentDay);
    infos.setAppointmentTime(appointmentTime);


return new ResponseEntity<SpecialistInfo>(infos,HttpStatus.OK);
	}
	
}


