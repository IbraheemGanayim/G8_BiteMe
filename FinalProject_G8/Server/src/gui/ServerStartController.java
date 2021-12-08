package gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import MySQLconnection.SQLconnection;
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
import server.ServerUI;

public class ServerStartController implements Initializable {
	SQLconnection c = new SQLconnection();
	public static boolean flag;
	@FXML
	private Button btnconnect;

	@FXML
	private TextField txtdb;

	@FXML
	private TextField txtpassword;

	@FXML
	private TextField txtuser;
	
	@FXML
	private TextField txtport;

	public static Label labelErr;

	@FXML
	private Label labelError;

	@FXML
	void ConnectServer(ActionEvent event) throws Exception {
		String port, dblocation,dbuser, password;
		port = txtport.getText();
		dblocation = txtdb.getText();
		password = txtpassword.getText();
		dbuser=txtuser.getText();
		if (port.isEmpty() || dblocation.isEmpty() || password.isEmpty()||dbuser.isEmpty())
			labelErr.setText("You have to fill all fields!!");
		else {
			flag=true;
			ServerUI.runServer(port);
			c.connectToDB(dblocation, password,dbuser);
			if (flag==true)
			{
			FXMLLoader loader = new FXMLLoader();
			((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
			Stage primaryStage = new Stage();
			Pane root = loader.load(getClass().getResource("/gui/ServerPort.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setTitle("SERVER");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
			else labelErr.setText("Something Wrong occurred");
			}
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/ServerStart.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("SERVER START");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtport.setText("5555");
		txtdb.setText("jdbc:mysql://localhost/G8_DB?serverTimezone=IST");
		txtuser.setText("root");
		labelErr = labelError;
        txtpassword.setText("salman123amer");
	}

}
