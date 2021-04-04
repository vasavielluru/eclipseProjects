package com.mindtree.utility;
import java.sql.*;

import com.mindtree.exception.daoExceptions.DataBaseConnectionFailedException;





public class DBUtil {

	private final String URL = "jdbc:mysql://localhost:3306/CollegeDetails";
	private final String NAME = "root";
	private final String PASSWORD = "Vasu@123";

	public Connection getMyConnection() throws DataBaseConnectionFailedException {
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			throw new DataBaseConnectionFailedException("Database could not be found");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}

	public void closeResource(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void closeResource(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void closeResource(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void closeResource(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

