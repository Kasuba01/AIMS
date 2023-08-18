package com.aims.asset;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AssetDbUtil {

	 private DataSource dataSource;
	 
	public AssetDbUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetDbUtil(DataSource theDataSource) {
		
		// assign variable connection pool
		dataSource = theDataSource;
	}
    
	  
	public List<Computer> getComputers() throws SQLException {
		 // create an empty that will store the list of computers
		
		List<Computer> computer = new ArrayList<>();
		
		// create jdbc objects
		  
		  Connection myConn= null;
		  Statement myStmt = null;
		  ResultSet myRs = null;
		  
		  
		
		// implement try finally
		try {
		// get a connection
		   myConn = dataSource.getConnection();
		// create an sql statement
		   String sql = "select * from computer order by computer_model";
		// create a prepared statement
		  myStmt = myConn.createStatement();
		
		// execute the query
		   myRs = myStmt.executeQuery(sql);
		// process the query
		    
		   while(myRs.next()) {
			   
			   try {
				   
			int id = myRs.getInt("id");
			String computerModel = myRs.getString("computer_model");
			String computerNumber = myRs.getString("computer_number");
			String computerYear = myRs.getString("computer_year");
			
			Computer temComputer = new Computer (id,computerModel, computerNumber, computerYear);
			
			
			// we add it to the array
			
			computer.add(temComputer);
			   }catch(Exception exc) {
				   exc.printStackTrace();
			   }
			    
		   }
		   // create an object
		
		}finally {
			
			close(myConn,myStmt,myRs);
			
		}
		
		return computer;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		
		// implement a try catch
		try {
			// check if objects are not null
			
			if(myConn != null) {
				myConn.close();
			}
			
			if(myStmt != null) {
				myStmt.close();
			}
			if(myRs != null) {
				myRs.close();
			}
			
			
		}catch(Exception exc) {
			throw new SQLException();
		}
		
		
	}
	
	

}
