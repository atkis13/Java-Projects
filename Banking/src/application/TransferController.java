package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TransferController {
	
	UserModel use = new UserModel();
	UserController usc = new UserController();
	@FXML
	TextField trans_sum;
	@FXML
	TextField trans_acc;
	@FXML
	TextField my_acc;
	
	public void transferSum(ActionEvent event)throws IOException {
		String aname = my_acc.getText();
		int asum = Integer.parseInt(trans_sum.getText());
		String aacc = trans_acc.getText();
		int balance = 0;
		int balance2 = 0;
		try {
			int bsum = use.getDepoacc(aname);
			int accsum = use.getDepoacc(aacc);
			balance = bsum-asum;
			use.updateAccount(aname, balance);
			balance2 = accsum+asum;
			use.updateAccount(aacc, balance2);
			((Node)event.getSource()).getScene().getWindow().hide();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
