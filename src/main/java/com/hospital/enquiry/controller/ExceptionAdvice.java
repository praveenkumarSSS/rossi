package com.hospital.enquiry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inventoryManagement.project.exceptionData.EnquiryException;
import com.inventoryManagement.project.exceptionData.ErrorMessageEnquiry;

@ControllerAdvice
public class ExceptionAdvice {

@ExceptionHandler(EnquiryException.class)

public ResponseEntity<ErrorMessageEnquiry> mapException(EnquiryException ex)throws EnquiryException
{
	ErrorMessageEnquiry error=new ErrorMessageEnquiry(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	
	return new ResponseEntity<ErrorMessageEnquiry>(error,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
