package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.College;
import com.mindtree.entity.Student;
import com.mindtree.exception.daoExceptions.DaoException;

public interface CollegeDao {

	boolean insertCollegeToDB(College college) throws DaoException;
	boolean insertStudentToDB(Student student) throws DaoException;
	List<Student> getCollegeNamesAndStudentData() throws DaoException;
	List<Student> getStudentDetails(String colName,String subName)throws DaoException;
}
