package com.hospital.enquiry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.enquiry.model.AdmisssionVacancy;

@Repository
public interface AdmissionVacancyDao extends JpaRepository<AdmisssionVacancy,Integer> {

}
