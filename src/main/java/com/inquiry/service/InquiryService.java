package com.inquiry.service;

import java.util.List;

import com.inquiry.model.Inquiry;

public interface InquiryService {

	public Inquiry addInquiry(Inquiry inquiry);
	
	public List<Inquiry> viewAllInquiry();
	
	public List<Inquiry> viewDeletedInquiry(int del);
	
	public List<Inquiry> viewPendingInquiry(int del);
	
}
