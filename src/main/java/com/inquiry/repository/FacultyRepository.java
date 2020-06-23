package com.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inquiry.model.FacultyDetails;

public interface FacultyRepository extends JpaRepository<FacultyDetails, Integer>{
	
	public FacultyDetails findByID(int id);

}
