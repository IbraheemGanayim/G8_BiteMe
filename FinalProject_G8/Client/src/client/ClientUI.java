package client;

import javafx.application.Application;

import javafx.stage.Stage;
import gui.ConnectFormController;
import gui.LoginScreenController;

public class ClientUI extends Application {
	public static ClientController chat; // only one instance

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		ConnectFormController aFrame = new ConnectFormController(); // create StudentFrame
		aFrame.start(primaryStage);

	}

}
