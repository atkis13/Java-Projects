package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.sqlite.SQLiteException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterController implements Initializable{
	RegiterModel regmodel = new RegiterModel();
	LoginModel loginModel = new LoginModel();
	
	@FXML TextField name;
	@FXML TextField surname;
	@FXML TextField username;
	@FXML PasswordField pass;
	@FXML PasswordField pass_confirm;
	@FXML TextField deposit;
	@FXML TextField acc;
	@FXML Label stats;
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModel.isDBConnected()){
			stats.setText("Connected");
		}
		else{
			stats.setText("Not Connected");
			}
		
	}
	
	public void RegUser(ActionEvent event) throws SQLException{
		String name1 = name.getText();
		String surname1 = surname.getText();
		String username1 = username.getText();
		String pass1 = pass.getText();
		String pass2 = pass_confirm.getText();	
		int depo = Integer.parseInt(deposit.getText());		
		int depo2 = depo;
		String account = acc.getText();
		
		try{
			if(name1.equals("") || surname1.equals("")|| username1.equals("")|| pass1.equals("") || pass2.equals("") || depo2 == 0 || account.equals("")){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("All fields are mandatory");
				alert.showAndWait();
			}
			else if(!pass1.equals(pass2)){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Password mismatch");
				alert.showAndWait();
			}
			else if(depo2<200){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Minimum deposit is 200 lei");
				alert.showAndWait();
			}
			else{
			regmodel.RegisterUser(name1, surname1, username1, pass1, depo2, account);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Succes");
			alert.setHeaderText(null);
			alert.setContentText("New record added succesfully");
			alert.showAndWait();
			((Node)event.getSource()).getScene().getWindow().hide();
			}
		}
		catch(SQLException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("The same username already exists");
			alert.showAndWait();
			
		}
		
		
		
		
	
	}

}
