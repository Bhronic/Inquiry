package com.inquiry.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.FeesDao;
import com.inquiry.model.Fees;
import com.inquiry.repository.FeesRepository;

@Repository
public class FeesDaoImpl implements FeesDao {
	
	@Autowired
	FeesRepository feesRepository;

	@Override
	public Fees payFees(Fees fees) {
		return feesRepository.save(fees);
	}

}
