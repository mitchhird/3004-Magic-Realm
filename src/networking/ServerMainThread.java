package networking;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Thread That Contains The Actual Server, This Way Clients Can Host There Own Game
 *    --- Will Hold The Main Game Model That Clients Will Interact With
 *    --- Also Holds All Of The Clients That Are Connected So We Can 
 *    --- Might Want This To Be An Observable So It 
 * @author Mitchell
 */
public class ServerMainThread extends Thread {
	
	private int serverPort;
	private String serverThreadName = "Server Main ";
	private ArrayList <ServerThread> connectedClients;
	
	// Constructor For The Thread
	public ServerMainThread(int port) {
		serverPort = port;
		connectedClients = new ArrayList<>();
	}
	
	@Override
	// Main Method That Will Start Up The Server And Handle Everything
	public void run () {
		System.out.println("Starting Server On Port " + serverPort);
		try (ServerSocket serverSocket = new ServerSocket(serverPort);) {
			setName(serverThreadName + InetAddress.getLocalHost().getHostAddress());
			
			// Run Indefinitely Waiting For Incoming Connection
			while (true) {
				Socket newSocket = serverSocket.accept();
				System.out.println("New Client Connected: " + newSocket.getInetAddress().getHostAddress());
				
				// Now Connect The Clients That Are Connected To The Server
				ServerThread newClient = new ServerThread(newSocket);
				connectedClients.add(newClient);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
