package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.ActivityDao;
import com.inquiry.model.Activity;
import com.inquiry.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	ActivityDao activityDao;

	@Override
	public List<Activity> viewActivity(String uname) {
		return activityDao.viewActivity(uname);
	}

	@Override
	public Activity addActivity(Activity activity) {
		return activityDao.addActivity(activity);
	}

}
