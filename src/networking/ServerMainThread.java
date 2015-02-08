package networking;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Thread That Contains The Actual Server, This Way Clients Can Host There Own Game
 * @author Mitchell
 */
public class ServerMainThread extends Thread {
	
	int serverPort;

	// Constructor For The Thread
	public ServerMainThread(int port) {
		serverPort = port;
	}
	
	@Override
	// Main Method That Will Start Up The Server And Handle Everything
	public void run () {
		System.out.println("Starting Server On Port " + serverPort);
		try (ServerSocket serverSocket = new ServerSocket(serverPort);) {
			
			// Run Indefinitely Waiting For Incoming Connection
			while (true) {
				Socket newSocket = serverSocket.accept();
				System.out.println("New Client Connected: " + newSocket.getInetAddress().getHostAddress());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
