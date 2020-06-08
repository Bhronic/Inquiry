package com.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inquiry.model.TeacherDetails;

public interface TeacherRepository extends JpaRepository<TeacherDetails, Integer>{

}
