package com.mindtree.entity;

public class College {

	private String collegeName;
	private int strengthOfStudents;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public College(String collegeName, int strengthOfStudents) {
		super();
		this.collegeName = collegeName;
		this.strengthOfStudents = strengthOfStudents;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public int getStrengthOfStudents() {
		return strengthOfStudents;
	}


	public void setStrengthOfStudents(int strengthOfStudents) {
		this.strengthOfStudents = strengthOfStudents;
	}
	
	
}
