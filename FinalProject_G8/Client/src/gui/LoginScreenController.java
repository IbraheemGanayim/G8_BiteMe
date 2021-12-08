package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Request;
import logic.User;

public class LoginScreenController extends Application {
	public static String role;
	@FXML
	private TextField Usertxt;

	@FXML
	private TextField Passtxt;

	@FXML
	private Button Loginbtn;

	@FXML
	private Button exitbtn;

	@FXML
	private Label Forgotbtn;

	@FXML
	private Label errlabel;

	@FXML
	void Forgetpass(MouseEvent event) {

	}

	@FXML
	void ReqLogin(ActionEvent event) throws Exception {
		boolean flag=true;
		if (Usertxt.getText().isEmpty() || Passtxt.getText().isEmpty()) {
			errlabel.setText("You must fill all fields");
		}
		else {
		User user = new User(Usertxt.getText(), Passtxt.getText());
		ConnectFormController.chat.accept(new Request("Login", user));
         Stage primaryStage=new Stage();
		if ("CEO".equals(role)) {
			
			CEOScreenController ceo = new CEOScreenController();
			ceo.user=user;
			ceo.start(primaryStage);
		} else if ("HR".equals(role)) {

			HRMScreenController hrm = new HRMScreenController();
			hrm.user=user;
			hrm.start(primaryStage);
		} else if ("BM manager".equals(role)) {

			BMScreenController bm = new BMScreenController();
			bm.user=user;
			bm.start(primaryStage);
		} else if ("Costumer".equals(role)) {

			USERHSController cos = new USERHSController();
            cos.user=user;
			cos.start(primaryStage);
		} else if ("Supplier".equals(role)) {

			USERHSController sup = new USERHSController();
			sup.user=user;
			sup.start(primaryStage);
		} else {
			errlabel.setText(role);flag=false;
		}
		if(flag) {
			((Node) event.getSource()).getScene().getWindow().hide();
		}
		}
	}
	@FXML
	void Exit(ActionEvent event) throws Exception {
		ConnectFormController.chat.accept(new Request("disconnect", null));
	System.out.print(true);
	System.exit(0);
	
	}
	
	
	
	
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	//((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		//Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/gui/LoginScreen.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Log-in");
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
	
}
