package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.FacultyDao;
import com.inquiry.model.FacultyDetails;
import com.inquiry.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	FacultyDao facultyDao;

	@Override
	public FacultyDetails addFaculty(FacultyDetails faculty) {
		return facultyDao.addFaculty(faculty);
	}

	@Override
	public List<FacultyDetails> findAll() {
		return facultyDao.findAll();
	}

	@Override
	public FacultyDetails findById(int id) {
		return facultyDao.findById(id);
	}

	@Override
	public void deleteById(int id) {

		facultyDao.deleteById(id);
		
	}

}
