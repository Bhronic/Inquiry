package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inquiry.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	
	public List<Activity> findAllByAdminName(String uname);

}
