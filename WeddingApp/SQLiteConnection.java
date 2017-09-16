package application;
import java.sql.*;
public class SQLiteConnection {
	public static Connection Connector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\user\\Desktop\\Wedding.sqlite");
			return conn;                                       //Location of the database
		}catch (Exception e){
			System.out.println(e); 
			return null;
		}
}
}

