package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inquiry.model.Fees;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Integer> {
	
	public List<Fees> findAllByStudentId(int student_id);

}
