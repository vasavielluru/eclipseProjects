package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.College;
import com.mindtree.entity.Student;
import com.mindtree.exception.CollegeServiceException;

public interface CollegeService {
	
	public boolean insertCollegeToDB(College college) throws CollegeServiceException;
	public boolean insertStudentToDB(Student student) throws CollegeServiceException;
	public List<Student> getCollegeNamesAndStudentsData() throws CollegeServiceException;
	public List<Student> getStudentDeatils(String colName,String subName) throws CollegeServiceException;

}
