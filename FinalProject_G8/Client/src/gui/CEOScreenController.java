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

public class CEOScreenController extends Application{
	static User user;

	    @FXML
	    private Button ViewReport;

	    @FXML
	    private Button ViewPR;

	    @FXML
	    private Button AskForReports;

	    @FXML
	    private Button RegEmployer;

	    @FXML
	    private Button RegisterSupplier;

	    @FXML
	    private Button ViewUsers;

	    @FXML
	    private Button ApproveAcc;

	    @FXML
	    private Button ViewMenu;

	    @FXML
	    void OpenAccountsList(ActionEvent event) {

	    }

	    @FXML
	    void OpenMenu(ActionEvent event) {

	    }

	    @FXML
	    void OpenPR(ActionEvent event) {

	    }

	    @FXML
	    void OpenRegisterEPage(ActionEvent event) {

	    }

	    @FXML
	    void OpenRegisterSPage(ActionEvent event) {

	    }

	    @FXML
	    void ReportPage(ActionEvent event) {

	    }

	    @FXML
	    void ReqReport(ActionEvent event) {

	    }

	    @FXML
	    void UsersList(ActionEvent event) {

	    }
	    @FXML
	    void LogOut(ActionEvent event) throws Exception {
	    	 ConnectFormController.chat.accept(new Request("Log out",user));
	    	    ((Node) event.getSource()).getScene().getWindow().hide();
	    	    Stage primaryStage=new Stage();
	    	    LoginScreenController login=new LoginScreenController();
	    	    login.start(primaryStage);

	    }
	    public void start(Stage primaryStage) throws Exception {	
	    	FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/gui/CEOScreen.fxml"));
			Scene scene = new Scene(root);			
			primaryStage.setTitle("CEO");
			primaryStage.setScene(scene);		
			primaryStage.show();		 	   
		}

}
