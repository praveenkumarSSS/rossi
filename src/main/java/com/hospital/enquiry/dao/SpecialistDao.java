package com.hospital.enquiry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.enquiry.model.SpecialistInfo;

public interface SpecialistDao extends JpaRepository<SpecialistInfo,Integer>{

}
