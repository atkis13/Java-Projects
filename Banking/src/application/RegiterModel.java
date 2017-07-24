package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegiterModel {
	Connection conection;
	public RegiterModel() {
		conection = SQLiteConnection.Connector();
		if (conection == null) System.exit(1);

}
	
	public void RegisterUser(String name, String surname, String username, String password, int deposit, String account) throws SQLException {
		//(String name, String surname, String username, String password, int deposit, String account)
		PreparedStatement prepareStatement = null;
		
		String query = "Insert into Accounts (Name, Surname, User, Password, Deposit, Account) values (?, ?, ?, ?, ?, ?)";
		//"Insert into Accounts (Name, Surname, User, Password, Deposit, Account) values (?, ?, ?, ?, ?, ?)";
		try {
			prepareStatement = conection.prepareStatement(query);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, surname);
			prepareStatement.setString(3, username);
			prepareStatement.setString(4, password);
			prepareStatement.setInt(5, deposit);
			prepareStatement.setString(6, account); 
			//prepareStatement.execute();
			prepareStatement.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("The same username already exists");
			alert.showAndWait();
			
		}
		
				
		
		finally {
			prepareStatement.close();
			
			
		}
	}
}
