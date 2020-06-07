package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.ActivityDao;
import com.inquiry.model.Activity;
import com.inquiry.repository.ActivityRepository;

@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	ActivityRepository activityRepository;
	
	@Override
	public List<Activity> viewActivity(String uname) {
		return activityRepository.findAllByAdminName(uname);
	}

	@Override
	public Activity addActivity(Activity activity) {
		return activityRepository.save(activity);
	}

}
