package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
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

public class ConnectFormController implements Initializable {
	public static ClientController chat; //only one instance

	
    
	@FXML
    private Button ExitBtn;
	@FXML
    private Label errorlabel;
    @FXML
    private Button conBtn;

    @FXML
    private TextField txtIP;
    @FXML
    private TextField porttxt;
    public String getIP() {
    	return txtIP.getText();
    }
    @FXML
    void ConnectBtn(ActionEvent event) throws Exception {
    	int port=5555;
    	String ip=txtIP.getText();
    	String portstr=porttxt.getText();
    	try {
    	 port=Integer.parseInt(portstr);
    	}catch(Exception e) {errorlabel.setText("Port must be numbers");}
    	chat= new ClientController(ip,port);
    	chat.accept(new Request("connect",null));
    	FXMLLoader loader = new FXMLLoader();
    	((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/gui/LoginScreen.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Log-in");
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void ExitBtn(ActionEvent event)throws Exception {
    	System.out.println("exit Tool");
		System.exit(0);
    }
    public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/gui/ConnectForm.fxml"));
				
		Scene scene = new Scene(root);
		primaryStage.setTitle("Connect Managment Tool");
		primaryStage.setScene(scene);
		
		primaryStage.show();	 	   
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtIP.setText("localhost");
		porttxt.setText("5555");
		
	}

}