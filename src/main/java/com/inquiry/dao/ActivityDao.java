package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.Activity;

public interface ActivityDao {
	
	public List<Activity> viewActivity(String uname);

}
