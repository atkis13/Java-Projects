package application;
import java.sql.*;
public class LoginModel {
	Connection conection;
	public LoginModel () {
		conection = SQLiteConnection.Connector();
		if (conection == null) System.exit(1);
	}
	
	public boolean isDBConnected() {
		try {
			return !conection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String query = "select * from Accounts where User = ? and Password = ?";
		try {
			prepareStatement = conection.prepareStatement(query);
			prepareStatement.setString(1, user);
			prepareStatement.setString(2, pass);
			
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			
			else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}finally {
			prepareStatement.close();
			resultSet.close();
		}
	}
}