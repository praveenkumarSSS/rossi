package com.hospital.enquiry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.enquiry.model.AppointmentInfo;

@Repository
public interface AppointmentDao extends JpaRepository<AppointmentInfo,Integer>{

AppointmentInfo findByHospitalName(String hospitalName);

}
