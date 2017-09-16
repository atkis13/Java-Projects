package application;

import java.sql.*;

public class MainModel {
	Connection conection;
	public MainModel() {
		conection = SQLiteConnection.Connector();// creating new connection to database
		if (conection == null) System.exit(1);
	}
	
	//insertSum method, inserts the name and the sum to the database
	
	public void insertSum(String name, int sum) throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String query = "Insert into Income (Name, Sum) values (?, ?)"; //Table name "Income"
		try {
			prepareStatement = conection.prepareStatement(query);
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, sum);
			prepareStatement.execute();			
			prepareStatement.close();
			
			
		} catch (Exception e) {
			
		}finally {
			
			resultSet.close();
			
		}
	}
	
	//getSum method returns the sum of the Income column from the database
	
	public int getSum(){
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int sum = 0;
		String query = "SELECT SUM(sum) FROM Income";
		try {
			prepareStatement = conection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
			      int c = resultSet.getInt(1);
			      sum = sum + c;
			    }
			
		}
		catch(Exception e){
			
		}
		return sum;
	}

}
