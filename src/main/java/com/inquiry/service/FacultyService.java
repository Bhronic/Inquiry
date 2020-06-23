package com.inquiry.service;

import java.util.List;

import com.inquiry.model.FacultyDetails;

public interface FacultyService {
	
	public FacultyDetails addFaculty(FacultyDetails faculty);
	
	public List<FacultyDetails> findAll();
	
	public FacultyDetails findById(int id);
	
	public void deleteById(int id);

}
