package com.hospital.enquiry.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.enquiry.model.AppointmentConsumeInfo;
import com.hospital.enquiry.model.AppointmentInfo;
import com.inventoryManagement.project.exceptionData.EnquiryException;

@RestController
@PropertySource("classpath:application.properties")
@PropertySource("classpath:specialist.properties")
public class AppointmentRestClientController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/consumeSave-AppoinmentInfo")
			public  ResponseEntity<List<Object>> getAppointmentinfos(
					@Value("${admissionVacancy}")String uri) throws EnquiryException
			{
		String url=uri;
	
		Object[] objects=template.getForObject(url, Object[].class);
	
		if(objects==null)
		{
			throw new EnquiryException(objects + "Object not found" );
		}
		
		return new ResponseEntity<List<Object>>(Arrays.asList(objects),HttpStatus.OK);
		
			}
	
	@GetMapping("/consumeSave-AppoinmentInfo/{hospitalName}/{type}")
	public  ResponseEntity<List<Object>> getAppointmentinfo(
			@PathVariable String hospitalName,@PathVariable String type,
			@Value("${admissionVacancy}")String uri) throws EnquiryException
	{
		HashMap<String,String> params=new HashMap<String,String>();
		
		String urlinfo=uri;
		
		params.put("hospitalName", "Apollo");
		
		params.put("type", "Dentist");
		
		String url = urlinfo + "/{hospitalName}/{type}";
		
		Object[] objects=template.getForObject(url, Object[].class,params);
		
		if (objects==null)
		{
			 throw new EnquiryException(objects + "Object not found" );
		}
		
		return new ResponseEntity<List<Object>>(Arrays.asList(objects),HttpStatus.OK);
	
}
	
	
	@GetMapping("/consumeSave-SpecialistInfo")
	public ResponseEntity<List<Object>> getSpecialistinfo() throws EnquiryException
	{
		
		String url = "http://localhost:8282/specialist-InfoRetrieval";
		
		Object[] objectData=template.getForObject(url, Object[].class);
		if (objectData==null)
		{
			 throw new EnquiryException(objectData + "specialist-info not found");
		}
		
		return new ResponseEntity<List<Object>>(Arrays.asList(objectData),HttpStatus.OK);
	
}
	
}
