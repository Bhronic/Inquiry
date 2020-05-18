package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.FeesDao;
import com.inquiry.model.Fees;
import com.inquiry.model.Student;
import com.inquiry.service.FeesService;

@Service
public class FeesServiceImpl implements FeesService {
	
	@Autowired
	FeesDao feesDao;

	@Override
	public Fees payFees(Fees fees) {
		return feesDao.payFees(fees);
	}

	@Override
	public List<Student> findAllPaidFees() {
		return feesDao.findAllPaidFees();
	}

	@Override
	public List<Student> findAllPendingFees() {
		return feesDao.findAllPendingFees();
	}

	@Override
	public Student findStudentById(int id) {
		return feesDao.findStudentById(id);
	}

	@Override
	public void saveStudent(int id, double feesPaid) {
		feesDao.saveStudent(id, feesPaid);
	}

	@Override
	public int countPendingFees() {
		return feesDao.countPendingFees();
	}

}
