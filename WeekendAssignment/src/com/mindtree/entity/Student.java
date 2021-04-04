package com.mindtree.entity;

public class Student {

		
	private String studentName;
	private int studentAge,collegeStrength;
	private String studentSubject;
	private College college;
	private String collegeName;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String studentName, int studentAge, String studentSubject) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentSubject = studentSubject;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentSubject() {
		return studentSubject;
	}
	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}
	public Student(String studentName, int studentAge, String studentSubject, College college) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentSubject = studentSubject;
		this.college = college;
	}
	public Student(String string, int int1, String string2, String string3, int int2) {
		studentName=string;
		studentAge=int1;
		studentSubject=string2;
		collegeName=string3;
		collegeStrength=int2;
	}
	public Student(String string, int int1, String string2, String string3) {
		studentName=string;
		studentAge=int1;
		studentSubject=string2;
		collegeName=string3;
	}
	public int getCollegeStrength() {
		return collegeStrength;
	}
	public void setCollegeStrength(int collegeStrength) {
		this.collegeStrength = collegeStrength;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}
