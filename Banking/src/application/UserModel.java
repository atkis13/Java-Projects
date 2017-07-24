package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserModel{
	Connection conection;	
	public UserModel() {		
		conection = SQLiteConnection.Connector();
		if (conection == null) System.exit(1);
		// TODO Auto-generated constructor stub
	}
	
public String getName(String iuser) throws SQLException{
		
		
		String iname = null;
		
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		String query = "select * from Accounts where User = ?";
		try {
			prepareStatement = conection.prepareStatement(query);
			prepareStatement.setString(1, iuser);
						
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				iname = rs.getString("Name");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iname;
	}

public String getSuname(String iuser) throws SQLException{
	
	
	String suname = null;
	
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "select * from Accounts where User = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setString(1, iuser);
					
		rs = prepareStatement.executeQuery();
		while(rs.next()) {
			suname = rs.getString("Surname");
		}
		
	} catch (SQLException se) {
		se.printStackTrace();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return suname;
}

public String getAccountNo(String iuser) throws SQLException{
	String accno = null;
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "select * from Accounts where User = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setString(1, iuser);
		rs = prepareStatement.executeQuery();
	while(rs.next()) {
		accno = rs.getString("Account");
	}
} catch (SQLException se) {
	se.printStackTrace();	
	
}
	return accno;
	
	
}

public int getDepo(String iuser) throws SQLException{
	
	
	int idepo = 0;
	
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "select * from Accounts where User = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setString(1, iuser);
					
		rs = prepareStatement.executeQuery();
		while(rs.next()) {
			idepo = rs.getInt("Deposit");
		}
		
	} catch (SQLException se) {
		se.printStackTrace();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return idepo;
}
public int getDepoacc(String acc) throws SQLException{ //transfer module
	
	
	int idepo = 0;
	
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "select * from Accounts where Account = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setString(1, acc);
					
		rs = prepareStatement.executeQuery();
		while(rs.next()) {
			idepo = rs.getInt("Deposit");
		}
		
	} catch (SQLException se) {
		se.printStackTrace();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return idepo;
}

public void updateDepo (String name, int sum) throws SQLException{
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "Update Accounts SET Deposit = ?  where User = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setInt(1, sum);
		prepareStatement.setString(2, name);
					
		prepareStatement.executeUpdate();
		
		
	} catch (SQLException se) {
		se.printStackTrace();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}



public void updateAccount (String acc, int sum) throws SQLException{ //transfer  module
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	String query = "Update Accounts SET Deposit = ?  where Account = ?";
	try {
		prepareStatement = conection.prepareStatement(query);
		prepareStatement.setInt(1, sum);
		prepareStatement.setString(2, acc);
					
		prepareStatement.executeUpdate();
		
		
	} catch (SQLException se) {
		se.printStackTrace();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}





}
