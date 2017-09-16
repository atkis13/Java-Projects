package application;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//The Main controller class


public class MainController implements Initializable {
	//Instansieating MainModell Class
	public  MainModel mainModel = new MainModel();
	//Declaring the form fields
	@FXML private Label lbl;
	@FXML private  TextField f_name;
	@FXML private  TextField f_sum;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Calling the getSum method from the MainModel class, a method that acceses the database and sums the amounts
		int sum3 = mainModel.getSum();		
		lbl.setText(String.valueOf(sum3));
	}
	
	public void AddSum(ActionEvent event){
		
		String name = f_name.getText();	//get name from label	
		int sum = Integer.parseInt(f_sum.getText());// ge the sum from label
		
		try{
			mainModel.insertSum(name, sum); //use the insertsum method with name and sum parameters 
			}
		
		catch (Exception e){
			
		}
		//reset the fields
		f_name.setText("");
		f_sum.setText("");
		//add the amount to the totals sum and display on the lable 
		int sum1 = mainModel.getSum();		
		lbl.setText(String.valueOf(sum1));
	
	}
}

