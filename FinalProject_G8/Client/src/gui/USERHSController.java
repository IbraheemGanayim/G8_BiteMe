package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Request;
import logic.User;

public class USERHSController extends Application{
	static User user;

	@FXML
	    private Button NewOrder;

	    @FXML
	    private Button Orders;

	    @FXML
	    private Button Logout;

	    @FXML
	    void LogOut(ActionEvent event) throws Exception {
	    	 ConnectFormController.chat.accept(new Request("Log out",user));
	    	    ((Node) event.getSource()).getScene().getWindow().hide();
	    	    LoginScreenController login=new LoginScreenController();
	    	    Stage primaryStage=new Stage();
	    	    login.start(primaryStage);

	    }

	    @FXML
	    void StartOrder(ActionEvent event) {

	    }

	    @FXML
	    void ViewOrdersList(ActionEvent event) {

	    }
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/gui/USERHS.fxml"));
			Scene scene = new Scene(root);			
			primaryStage.setTitle("User");
			primaryStage.setScene(scene);		
			primaryStage.show();				 	   
		}
}
