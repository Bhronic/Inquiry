package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.FacultyDao;
import com.inquiry.model.FacultyDetails;
import com.inquiry.repository.FacultyRepository;

@Repository
public class FacultyDaoImpl implements FacultyDao {
	
	@Autowired
	FacultyRepository facultyRepository;

	@Override
	public FacultyDetails addFaculty(FacultyDetails faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public List<FacultyDetails> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public FacultyDetails findById(int id) {
		return facultyRepository.findByID(id);
	}

	@Override
	public void deleteById(int id) {
		
		facultyRepository.deleteById(id);
		
	}

}
