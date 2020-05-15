package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.InquiryDao;
import com.inquiry.model.Inquiry;
import com.inquiry.service.InquiryService;

@Service
public class InquiryServiceImpl implements InquiryService {
	
	@Autowired
	InquiryDao inquiryDao;
	
	@Override
	public Inquiry addInquiry(Inquiry inquiry) {
		return inquiryDao.addInquiry(inquiry);
	}

	@Override
	public List<Inquiry> viewAllInquiry() {
		return inquiryDao.viewAllInquiry();
	}

	@Override
	public List<Inquiry> viewDeletedInquiry(int del) {
		return inquiryDao.viewDeletedInquiry(del);
	}

	@Override
	public List<Inquiry> viewPendingInquiry(int del) {
		return inquiryDao.viewPendingInquiry(del);
	}

}
