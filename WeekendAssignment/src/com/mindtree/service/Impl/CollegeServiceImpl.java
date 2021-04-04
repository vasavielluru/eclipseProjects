package com.mindtree.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.dao.CollegeDao;
import com.mindtree.dao.Impl.CollegeDaoImpl;
import com.mindtree.entity.College;
import com.mindtree.entity.Student;
import com.mindtree.exception.CollegeServiceException;
import com.mindtree.exception.daoExceptions.DaoException;
import com.mindtree.service.CollegeService;



public class CollegeServiceImpl implements CollegeService {
	
	private static Scanner obj=new Scanner(System.in);
	private static CollegeDao object=new CollegeDaoImpl();

	@Override
	public boolean insertCollegeToDB(College college) throws CollegeServiceException {
		try {
			return object.insertCollegeToDB(college);
			}
			catch(DaoException e)
			{
				throw new CollegeServiceException("Something wrong in DB",e);
			}
	}

	@Override
	public boolean insertStudentToDB(Student student) throws CollegeServiceException {
		try {
			return object.insertStudentToDB(student);
			}
			catch(DaoException e)
			{
				throw new CollegeServiceException("Something wrong in DB",e);
			}
	}

	public static int displayMenu() {
		
		System.out.println("-------------------------\nMenu:");
		System.out.println("1. Create College:");
		System.out.println("2. Create Students and Assign To college:");
		System.out.println("3. Fetch All Colleges and their student's data");
		System.out.println("4. Show all Students Data for given college and particular subject as input");
		System.out.println("5. Exit");
		System.out.println("------------------------\nChoose an option from the above displayed menu:");
		int ch=obj.nextInt();
		
		return ch;
	}

	@Override
	public List<Student> getCollegeNamesAndStudentsData() throws CollegeServiceException {
		List<Student> students=new ArrayList<>();
		try {
			students=object.getCollegeNamesAndStudentData();
			return students;
			}
			catch(DaoException e)
			{
				throw new CollegeServiceException("Something wrong in DB",e);
			}
	}

	@Override
	public List<Student> getStudentDeatils(String colName,String subName) throws CollegeServiceException {
		List<Student> studentsdetails=new ArrayList<>();
		try {
			studentsdetails=object.getStudentDetails(colName,subName);
			return studentsdetails;
			}
			catch(DaoException e)
			{
				
				throw new CollegeServiceException(e.getMessage(),e);
			}
	}

	
	

}
