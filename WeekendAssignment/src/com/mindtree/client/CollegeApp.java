package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.College;
import com.mindtree.entity.Student;
import com.mindtree.exception.CollegeServiceException;
import com.mindtree.service.CollegeService;
import com.mindtree.service.Impl.CollegeServiceImpl;


public class CollegeApp {

	private static Scanner obj=new Scanner(System.in);
	private static CollegeService collegeservice=new CollegeServiceImpl();
	static List<College> colleges=new ArrayList<>();
	static College college=new College();
	static Student student=new Student();
	public static void main(String[] args) {
		
		int p=1;
		
		do
		{
			int choice=CollegeServiceImpl.displayMenu();
			switch(choice)
			{
			case 1:
				 college=createCollege();
				boolean isInsertedSuccessfully=false;
				try
				{
					isInsertedSuccessfully=collegeservice.insertCollegeToDB(college);
				}
				catch(CollegeServiceException e)
				{
					System.out.println(e.getLocalizedMessage());
				}
				if(isInsertedSuccessfully)
				{
					System.out.println("College  added successfully");
				}
				else
					System.out.println("Something went wrong");
					
				
				break;
				case 2:
				 student= createStudents();

					
					boolean isInsertedSuccessfully1=false;
				try
				{
					isInsertedSuccessfully1=collegeservice.insertStudentToDB(student);
				}
				catch(CollegeServiceException e)
				{
					System.out.println(e.getLocalizedMessage());
				}
				if(isInsertedSuccessfully1)
				{
					System.out.println("Student  added successfully");
				}
				else
					System.out.println("Something went wrong");
					
				
				break;
				case 3:
					List<Student> getStudents=new ArrayList<>();
					try
					{
						getStudents=collegeservice.getCollegeNamesAndStudentsData();
						displayStudentsFromDB(getStudents);
					}
					catch(CollegeServiceException e)
					{
						System.out.println(e.getMessage());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					break;
				case 4:
					List<Student> getStudentsdetails=new ArrayList<>();
					System.out.println("Enter the name of the College Whose students data is to be displayed");
					String colName=obj.next();
					System.out.println("Enter the subject name of those students to be displayed");
					String subName=obj.next();
					try
					{
						getStudentsdetails=collegeservice.getStudentDeatils( colName,subName);
						displayStudentsDetailsFromDB(getStudentsdetails);
					}
					catch(CollegeServiceException e)
					{
						System.out.println(e.getMessage());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					break;
					
				case 5:
					System.out.println("Enter P to 0 to stop the program or else enter any other number");
					p=obj.nextInt();
					break;
			}
					
			
		}while(p!=0);
	}

	public static void displayStudentsDetailsFromDB(List<Student> getStudentsdetails) {
		System.out.println("StudentName\tStudentAge\tStudentSubject\tCollegeName\n------------------------------------------------------");
		for(Student students:getStudentsdetails)
		{
			System.out.println(students.getStudentName()+"\t\t"+students.getStudentAge()+"\t\t"+students.getStudentSubject()+"\t\t"+students.getCollegeName());
		
	}
		System.out.println("-----------------------------------------------");
		
	}

	public static void displayStudentsFromDB(List<Student> getStudents) {
		
		System.out.println("StudentName\tStudentAge\tStudentSubject\tCollegeName\tCollegeStrength\n-------------------------------------------");
		for(Student students:getStudents)
		{
			System.out.println(students.getStudentName()+"\t"+students.getStudentAge()+"\t"+students.getStudentSubject()+"\t"+students.getCollegeName()+"\t"+students.getCollegeStrength());
		
	}
		System.out.println("------------------------------------------------------");

	}


	private static Student createStudents() {
		
		System.out.println("Enter the name of  the student:");
		String studentName=obj.next();
		System.out.println("Enter the age of respective Student");
		int studentAge=obj.nextInt();
		System.out.println("Enter the subject of respective Student:");
		String studentSubject=obj.next();
		Student student=new Student(studentName,studentAge,studentSubject,college);
		
		return student;
	}


	public static College createCollege() {
		
		System.out.println("Enter the name of the College:");
		String collegeName=obj.next();
		System.out.println("Enter the Strength of Students in particular College:");
		int strengthOfStudents=obj.nextInt();
		College college=new College(collegeName,strengthOfStudents);
		colleges.add(college);
		
		return college;
	}

}
