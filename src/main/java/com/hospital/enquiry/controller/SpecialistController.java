package com.hospital.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.enquiry.model.SpecialistInfo;
import com.hospital.enquiry.service.SpecialistService;
import com.inventoryManagement.project.exceptionData.EnquiryException;

@RestController
public class SpecialistController {

	@Autowired 
	SpecialistService services;
	
	@GetMapping("/specialist-InfoRetrieval")
	public ResponseEntity<SpecialistInfo> infoData(EnquiryException e) throws EnquiryException
	{
		if(services.specilaistData()==null)
		{
			throw new EnquiryException(null + e.getMessage());
		}
		return services.specilaistData();
		
}
	
}