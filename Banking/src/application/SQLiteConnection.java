package application;
import java.sql.*;
public class SQLiteConnection {
	public static Connection Connector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Desktop\\Bank.sqlite");
			                                                          //database location
			return conn;
		}catch (Exception e){
			System.out.println(e); 
			return null;
		}
}
}
