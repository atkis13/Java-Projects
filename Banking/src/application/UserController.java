package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UserController implements Initializable {
	
	
	
	UserModel umm = new UserModel();
	
	
	@FXML Label user1_txt;
	@FXML Label name1_txt;
	@FXML Label surname1_txt;
	@FXML Label balance1_txt;
	@FXML Label acc_txt;
	@FXML Label lbl_name;
	@FXML Label lbl_surname;
	@FXML Label lbl_balance;
	@FXML Label acc_lbl;
	@FXML TextField txt_sum;
	
	public void GetUser(String user){
		user1_txt.setText(user);
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*try {
		FXMLLoader loader = new FXMLLoader();		
		LoginController  lg = (LoginController)loader.getController();
		
		user1_txt.setText(lg.user_txt.getText());
		}
		catch (Exception e) {
			
		}*/
		
			
		
	}
	
	public void checkUser(ActionEvent event){
		String iname = user1_txt.getText();
		try {
			name1_txt.setText(umm.getName(iname));
			surname1_txt.setText(umm.getSuname(iname));
			balance1_txt.setText(String.valueOf((umm.getDepo(iname))));
			acc_txt.setText(umm.getAccountNo(iname));
			name1_txt.setVisible(true);
			acc_txt.setVisible(true);
			surname1_txt.setVisible(true);
			balance1_txt.setVisible(true);
			lbl_name.setVisible(true);
			lbl_surname.setVisible(true);
			lbl_balance.setVisible(true);
			acc_lbl.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void Deposit(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
		 	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/application/Deposit.fxml").openStream());
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
		
	}
	public void Transfer(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
		 	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/application/Transfer.fxml").openStream());
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
	}
	
	public void Withdraw(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
		 	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/application/Withdraw.fxml").openStream());
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
		
	}
	public void LogOut(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
		 	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/application/Login.fxml").openStream());
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
		
	}
	
	
	
	
	
	
}
	
	
	
	
	