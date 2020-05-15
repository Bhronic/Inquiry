package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inquiry.model.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
	
	public int countByDel(int del);
	
	public List<Inquiry> findByDel(int del);
	
	public Inquiry findByID(int id);

}
