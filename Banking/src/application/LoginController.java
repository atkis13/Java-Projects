package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	LoginModel loginModel = new LoginModel();
	@FXML TextField user_txt;
	@FXML PasswordField pass_txt;
	@FXML Label status_txt;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModel.isDBConnected()){
			status_txt.setText("Connected");
		}
		else{
			status_txt.setText("Not Connected");
			}
			
	}
	public void Login (ActionEvent event) throws IOException {
		try {
			if (loginModel.isLogin(user_txt.getText(), pass_txt.getText())) {
				
				((Node)event.getSource()).getScene().getWindow().hide();
				
				Stage primaryStage = new Stage();
			 	FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(getClass().getResource("/application/User.fxml").openStream());
				UserController uc = (UserController)loader.getController();
				uc.GetUser(user_txt.getText());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else{
				status_txt.setText(" Username and password INCORRECT");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("User or password incorrect");
				alert.showAndWait();
				
			}
		}
		 catch (SQLException e) {
				
				
				e.printStackTrace();
			}

	}	
	
	public void Register(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
		 	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/application/Register.fxml").openStream());
			
			
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

