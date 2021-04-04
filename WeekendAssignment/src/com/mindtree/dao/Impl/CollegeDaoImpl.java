package com.mindtree.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.CollegeDao;
import com.mindtree.entity.College;
import com.mindtree.entity.Student;
import com.mindtree.exception.daoExceptions.CollegeNotFoundException;
import com.mindtree.exception.daoExceptions.DaoException;
import com.mindtree.exception.daoExceptions.DataBaseEmptyException;
import com.mindtree.utility.DBUtil;


public class CollegeDaoImpl implements CollegeDao {

	private DBUtil dbUtil=new DBUtil();
	
	@Override
	public boolean insertCollegeToDB(College college) throws DaoException {
		
		boolean isInserted=false;
		Connection con=null;
		PreparedStatement st=null;
		try
		{
			con=dbUtil.getMyConnection();
			String insertQuery="insert into Colleges values(?,?)";
			st=con.prepareStatement(insertQuery);
			
			st.setString(1, college.getCollegeName());
			st.setInt(2, college.getStrengthOfStudents());
			
			
			st.executeUpdate();
			isInserted=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbUtil.closeResource(st);
			dbUtil.closeResource(con);
		}
	
	return isInserted;
}

	@Override
	public boolean insertStudentToDB(Student student) throws DaoException {
		boolean isInserted=false;
		Connection con=null;
		PreparedStatement st=null;
		try
		{
			con=dbUtil.getMyConnection();
			String insertQuery="insert into Colleges values(?,?,?,?)";
			st=con.prepareStatement(insertQuery);
			
			st.setString(1, student.getStudentName());
			st.setInt(2, student.getStudentAge());
			st.setString(3, student.getStudentSubject());
			st.setString(4, student.getCollege().getCollegeName());
			
			
			st.executeUpdate();
			isInserted=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbUtil.closeResource(st);
			dbUtil.closeResource(con);
		}
	
	return isInserted;

}

	@Override
	public List<Student> getCollegeNamesAndStudentData() throws DaoException {
		List<Student> students=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			
			
			con=dbUtil.getMyConnection();
			String query="select s.StudentName,s.StudentAge,s.StudentSubject,s.Student_College,c.strengthOfStudents from Colleges c inner join Students s on c.CollegeName=s.Student_College order by c.CollegeName asc";
			st=con.createStatement();
			 rs=st.executeQuery(query);
			if(rs==null)
			{
				throw new DataBaseEmptyException();
			}
			else {
			while(rs.next())
			{
				students.add(new Student(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
			}
		}
		catch(DataBaseEmptyException e)
		{
			throw new DaoException("DataBase is empty",e);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbUtil.closeResource(rs);
			dbUtil.closeResource(st);
			dbUtil.closeResource(con);
		}
		
		return students;
	}

	@Override
	public List<Student> getStudentDetails(String colName,String subName) throws DaoException {
		List<Student> studentsdetails=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			
			
			con=dbUtil.getMyConnection();
			String query="select * from Students where Student_College="+"'"+colName+"'"+" and StudentSubject="+"'"+subName+"'"+" order by StudentName desc ";
			st=con.createStatement();
			 rs=st.executeQuery(query);
			
			if(rs.next()==false)
			{
				throw new CollegeNotFoundException("No Such College Named "+colName);
			}
			else {
				studentsdetails.add(new Student(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
			while(rs.next())
			{
				studentsdetails.add(new Student(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
							}
			}
			
		}
		catch(CollegeNotFoundException e)
		{
			
			throw new DaoException(e.getMessage());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbUtil.closeResource(rs);
			dbUtil.closeResource(st);
			dbUtil.closeResource(con);
		}
		
		return studentsdetails;
	}
}
