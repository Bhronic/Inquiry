package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inquiry.model.Fees;
import com.inquiry.model.Student;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Integer> {
	
	@Query("SELECT s FROM Student s where s.fees = s.feesPaid")
	public List<Student> findAllPaidFees();
	
	@Query("SELECT s FROM Student s where s.fees != s.feesPaid")
	public List<Student> findAllPendingFees();
	
	@Query("select s from Student s where s.ID=?1")
	public Student findStudentByID(int id);
	
	@Modifying
    @Query(value = "update Student set fees_paid=?2 where ID=?1", nativeQuery = true)
    @Transactional
	public void saveStudent(int id, double feesPaid);
	
	@Query("SELECT count(*) FROM Student s where s.fees!=s.feesPaid")
	public int countPendingFees();

}
