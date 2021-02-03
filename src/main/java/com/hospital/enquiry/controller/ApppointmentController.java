package com.hospital.enquiry.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.enquiry.model.AppointmentInfo;
import com.hospital.enquiry.service.AppointmentService;
import com.inventoryManagement.project.exceptionData.EnquiryException;

@RestController

public class ApppointmentController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	AppointmentService services;
	
	@PostMapping("/save-AppoinmentInfo")
	public ResponseEntity<List<AppointmentInfo>> saveInfo() throws EnquiryException
	{
		if(services.saveInfo()==null)
		{
			throw new EnquiryException(null);
		}
		
	 return new ResponseEntity<List<AppointmentInfo>>(services.saveInfo(),HttpStatus.OK);
     
	}
	
	@GetMapping("/save-AppoinmentInfo")
	public ResponseEntity<List<AppointmentInfo>> retrieveInfo() throws EnquiryException
	{
		if(services.retrieveInfo()==null)
		{
			throw new EnquiryException(null);
		}
		
	return new ResponseEntity<List<AppointmentInfo>> (services.retrieveInfo(),HttpStatus.OK);

	}

	@GetMapping("/save-AppoinmentInfo/{hospitalName}/{type}") 
	
		public ResponseEntity<AppointmentInfo> availability(@PathVariable String hospitalName,
				
				@PathVariable String type) throws EnquiryException
		{
			return services.availabilityEnquiry(hospitalName,type);
		}
	}
	

