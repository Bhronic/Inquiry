package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inquiry.model.Fees;
import com.inquiry.model.Inquiry;
import com.inquiry.model.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByDel(int del);
	
	public Student findByID(int id);
	
	@Query("SELECT i from Inquiry i where i.ID=?1")
	public Inquiry findInquiryByID(int id);
	
	@Modifying
	@Query("DELETE FROM Inquiry i WHERE i.ID=:id")
	public void deleleInquiryByID(@Param("id") int id);
	
	@Query("SELECT f FROM Fees f WHERE f.studentId=?1")
	public List<Fees> findFeesHistoryById(int id);

}
