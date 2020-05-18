package com.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inquiry.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);
	
	@Query("Select count(*) from Inquiry")
	public int countAllInquiry();
	
	@Query("select count(*) from Inquiry i where i.del=0")
	public int countPendingInquiry();
	
	@Query("select count(*) from Student s where s.del=0")
	public int countStudent();
	
	@Query("select count(*) from Student s where s.fees!=s.feesPaid")
	public int countPendingFees();

}
