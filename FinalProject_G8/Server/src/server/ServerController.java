package server;

import java.net.UnknownHostException;
import java.util.ArrayList;

import gui.ServerPortFrameController;
import logic.clients;
import ocsf.server.ConnectionToClient;

public class ServerController {
	

	public static void ConnectClient(ConnectionToClient client) {
		clients c;
		try {
			c = new clients(client.getInetAddress().getLocalHost().getHostName(),
					client.getInetAddress().getLocalHost().getHostAddress(), "Connected");
			ServerPortFrameController.arr.add(c);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	public static void DisonnectClient(ConnectionToClient client) {
		try {

			for (int i=0;i<ServerPortFrameController.arr.size();i++)
			{
				if (ServerPortFrameController.arr.get(i).getName().equals(client.getInetAddress().getLocalHost().getHostName()))
						{
         // 				cl.setStatus("Disonnected");
					System.out.print(ServerPortFrameController.arr);
					ServerPortFrameController.arr.remove(ServerPortFrameController.arr.get(i));
					System.out.print(ServerPortFrameController.arr);
						}
				System.out.print("hi");

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
