package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.InquiryDao;
import com.inquiry.model.Inquiry;
import com.inquiry.repository.InquiryRepository;

@Repository
public class InquiryDaoImpl implements InquiryDao {
	
	@Autowired
	InquiryRepository inquiryRepository;

	@Override
	public Inquiry addInquiry(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}

	@Override
	public List<Inquiry> viewAllInquiry() {
		return inquiryRepository.findAll();
	}

	@Override
	public List<Inquiry> viewDeletedInquiry(int del) {
		return inquiryRepository.findByDel(del);
	}

	@Override
	public List<Inquiry> viewPendingInquiry(int del) {
		return inquiryRepository.findByDel(del);
	}

	@Override
	public long countAllInquiry() {
		return inquiryRepository.count();
	}

	@Override
	public int countPengingInquiry(int del) {
		return inquiryRepository.countByDel(del);
	}

	@Override
	public Inquiry findById(int id) {
		return inquiryRepository.findByID(id);
	}

}
