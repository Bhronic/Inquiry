package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inquiry.model.Inquiry;
import com.inquiry.model.StudentDetails;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {
	
	public List<StudentDetails> findByDel(int del);
	
	public StudentDetails findByID(int id);
	
	@Query("SELECT i from Inquiry i where i.ID=?1")
	public Inquiry findInquiryByID(int id);
	
	@Modifying
	@Query("DELETE FROM Inquiry i WHERE i.ID=:id")
	public void deleleInquiryByID(@Param("id") int id);

}
