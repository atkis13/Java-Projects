package application;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class WithdrawController {
	UserModel umm = new UserModel();
	@FXML
	private TextField sum_txt;
	@FXML
	private TextField user_txt;

	
	
	
	
	
	public void witsum(ActionEvent event) {
		int asum = Integer.parseInt(sum_txt.getText());
		String aname = user_txt.getText();
		int total = 0;
		try {
			int bsum = umm.getDepo(aname);
			total = bsum-asum;
			if(total >0) {
				umm.updateDepo(aname, total);
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Not enough money");
				alert.showAndWait();
			}
			((Node)event.getSource()).getScene().getWindow().hide();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

