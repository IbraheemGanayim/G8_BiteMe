// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import ocsf.server.ConnectionToClient;
import client.*;
import common.ChatIF;
import gui.ConnectFormController;
import gui.LoginScreenController;
import logic.Order;
import logic.Request;
import logic.User;

import java.io.*;
import java.util.ArrayList;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;
	// public static Student s1 = new Student(null,null,null,new
	// Faculty(null,null));
	public static boolean awaitResponse = false;
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI) throws IOException {

		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		// openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		awaitResponse = false;
		String type = ((Request) msg).getRequest();
		switch (type) {
		case "Role":

			try {
				LoginScreenController.role = (String) ((Request) msg).getObj();
				System.out.print("Logged in");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Logged out": {
			System.out.print("Logged out");
		}
			break;
		case "connected": {
			System.out.print(type);
		}
			break;
		case "disconnected": {
			System.out.print(type);
		}
			break;
		default:
			System.out.println("Illegal Command " + type);
			System.exit(0);
			break;
		}

		// System.out.println(((ArrayList<Order>)msg).get(0).toString());// to check if
		// list arrived from sever

		System.out.println("--> handleMessageFromServer");
		// clientUI.display(msg);
	}
	// }

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI.
	 */

	public void handleMessageFromClientUI(Object message) {
		try {

			openConnection();// in order to send more than one message
			awaitResponse = true;
			sendToServer(message);

			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
					System.out.print("stuck");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			clientUI.display("Could not send message to server: Terminating client." + e);
			quit();
		}
	}

	public void clientConnected(ConnectionToClient client) throws Exception {
		System.out.println(">Client Connected");
		try {
			String str = client.getInetAddress().getLocalHost().toString() + "//"
					+ client.getInetAddress().getLocalHost().getHostName().toString() + "//Connected";
			sendToServer(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clientDisConnected(ConnectionToClient client) throws Exception {
		System.out.println(">Client DisConnected");
		try {
			String str = client.getInetAddress().getLocalHost().toString() + "//"
					+ client.getInetAddress().getLocalHost().getHostName().toString() + "//DisConnected";
			sendToServer(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
