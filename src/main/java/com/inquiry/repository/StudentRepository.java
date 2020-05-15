package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inquiry.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public int countByDel(int del);
	
	@Query("SELECT count(*) FROM Student s where s.fees!=s.fees_paid")
	public int countPendingFees();
	
	public List<Student> findByDel(int del);
	
	public Student findByID(int id);
	
	@Query("SELECT s FROM Student s where s.fees = s.fees_paid")
	public List<Student> findAllPaidFees();
	
	@Query("SELECT s FROM Student s where s.fees != s.fees_paid")
	public List<Student> findAllPendingFees();

}
