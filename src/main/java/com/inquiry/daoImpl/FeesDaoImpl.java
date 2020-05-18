package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.FeesDao;
import com.inquiry.model.Fees;
import com.inquiry.model.Student;
import com.inquiry.repository.FeesRepository;

@Repository
public class FeesDaoImpl implements FeesDao {
	
	@Autowired
	FeesRepository feesRepository;

	@Override
	public Fees payFees(Fees fees) {
		return feesRepository.save(fees);
	}

	@Override
	public List<Student> findAllPaidFees() {
		return feesRepository.findAllPaidFees();
	}

	@Override
	public List<Student> findAllPendingFees() {
		return feesRepository.findAllPendingFees();
	}

	@Override
	public Student findStudentById(int id) {
		return feesRepository.findStudentByID(id);
	}

	@Override
	public void saveStudent(int id, double feesPaid) {
		feesRepository.saveStudent(id, feesPaid);
	}

	@Override
	public int countPendingFees() {
		return feesRepository.countPendingFees();
	}

}
