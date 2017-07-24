package application;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class DepositController {
	
	UserModel umm = new UserModel();
	@FXML
	private TextField depo_sum;
	@FXML
	private TextField verif_txt;


public void deposum(ActionEvent event) {
	int asum = Integer.parseInt(depo_sum.getText());
	String aname = verif_txt.getText();
	int total = 0;
	try {
		int bsum = umm.getDepo(aname);
		total = asum+bsum;
		umm.updateDepo(aname, total);
		((Node)event.getSource()).getScene().getWindow().hide();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
