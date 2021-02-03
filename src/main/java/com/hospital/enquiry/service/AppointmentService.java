package com.hospital.enquiry.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.hospital.dataInfo.model.AppointmentInfo;
import com.hospital.enquiry.model.AppointmentInfo;
import com.inventoryManagement.project.exceptionData.EnquiryException;
import com.hospital.enquiry.dao.AppointmentDao;

@Service
public class AppointmentService {

@Autowired
private AppointmentDao enquiryDao;


List<AppointmentInfo> information=new ArrayList<AppointmentInfo>();

@PostConstruct

public void PostAppointmentInfo()
{
	/*
	 * AppointmentInfo info=new AppointmentInfo("Dentist", "sandya",
	 * "Monday,Thrusday", "6 to 8", "N", 946,"Apollo"); AppointmentInfo infos=new
	 * AppointmentInfo("Dentist", "sandya", "Monday,Wednesday", "5 to 6", "Y",
	 * 946,"Apollo");
	 * 
	 * appointments.add(infos); appointments.add(info);
	 */
	
	AppointmentInfo info=new AppointmentInfo("Dentist", "sandya", "Monday,Wednesday", "5 to 6", "Y", 946, "Apollo");
	
	AppointmentInfo infos=new AppointmentInfo("Dentist", "sandya", "Monday,Thrusday", "6 to 8", "N", 946, "Apollo");
	
	information.add(info);
	information.add(infos);
	
}
@CachePut(value="usersCache")
public List<AppointmentInfo> saveInfo()
{
 List<AppointmentInfo> dataEnquiry=enquiryDao.saveAll(information);
 
 return dataEnquiry;

}
@Cacheable(value="usersCache")
public List<AppointmentInfo> retrieveInfo() {
	return information;}
@Cacheable(value="usersCache", key="#hospitalName")
public ResponseEntity<AppointmentInfo> availabilityEnquiry(String hospitalName,
		String type) throws EnquiryException{
	try
	{
	for(AppointmentInfo infos:information)
	{
	if(infos.getHospitalName().equalsIgnoreCase(hospitalName)
			&&infos.getType().equalsIgnoreCase(type))
	{		
		return new ResponseEntity<AppointmentInfo>(infos,HttpStatus.OK);
	
}}}
	catch(Exception e)
	{
	
	e.getStackTrace();
	
}
	throw new EnquiryException("HospitalName" +  " " + " " + 
      hospitalName + " " + " " + "not found" );}}