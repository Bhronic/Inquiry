package com.inquiry.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.FeesDao;
import com.inquiry.model.Fees;
import com.inquiry.service.FeesService;

@Service
public class FeesServiceImpl implements FeesService {
	
	@Autowired
	FeesDao feesDao;

	@Override
	public Fees payFees(Fees fees) {
		return feesDao.payFees(fees);
	}

}
