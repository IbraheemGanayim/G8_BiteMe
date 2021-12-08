package gui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import client.ClientController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Request;
import logic.User;

public class HRMScreenController extends Application{
	static User user;
  
	@FXML
	    private Button NewOrder;

	    @FXML
	    private Button UserApprove;

	    @FXML
	    private Button logout;

	    @FXML
	    void LogOut(ActionEvent event) throws Exception {
	    	 ConnectFormController.chat.accept(new Request("Log out",user));
	    	    ((Node) event.getSource()).getScene().getWindow().hide();
	    	    Stage primaryStage=new Stage();
	    	    LoginScreenController login=new LoginScreenController();
	    	    login.start(primaryStage);
              
	    }

	    @FXML
	    void OpenUsersList(ActionEvent event) {

	    }

	    @FXML
	    void StartOrder(ActionEvent event) {

	    }
	    public void start(Stage primaryStage) throws Exception {	
	       	FXMLLoader loader = new FXMLLoader();
	    
			Pane root = loader.load(getClass().getResource("/gui/HRMScreen.fxml"));
			Scene scene = new Scene(root);			
			primaryStage.setTitle("Log-in");
			primaryStage.setScene(scene);		
			primaryStage.show();	 	   
		}
}
