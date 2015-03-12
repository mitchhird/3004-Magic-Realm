package networking.threads;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import networking.sendables.MessageType;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import utils.Pair;
import views.GameView;

/**
 * Thread That Contains The Actual Server, This Way Clients Can Host There Own Game
 *    --- Will Hold The Main Game Model That Clients Will Interact With
 *    --- Also Holds All Of The Clients That Are Connected So We Can 
 *    --- Might Want This To Be An Observable So It 
 * @author Mitchell
 */
public class ServerMainThread extends Thread {
	
	private int serverPort;
	private boolean processing = false;
	private String serverThreadName = "Server Main ";
	private ArrayList <Pair<ServerReadThread, ServerWriteThread>> connectedClients;
	
	private GameView theGame;
	
	// Constructor For The Thread
	public ServerMainThread(int port, GameView theGame) {
		serverPort = port;
		connectedClients = new ArrayList<>();
		this.theGame = theGame;
		
		// Now Is A Networked Game, So Let The Game Know
		this.theGame.setServerThread(this);
	}
	
	// Sends An Object To All Other Threads Then The One That Called
	public synchronized void broadcastToOthers (Object objectToSend, ServerReadThread caller) {
		processing = false;
		for (Pair<ServerReadThread, ServerWriteThread> s: connectedClients) {
			if (s.getFirst() != caller) {
				s.getSecond().writeMsg(objectToSend);
			}
		}
	}
	
	// Sends An Object To All The Connected Clients
	public synchronized void boardcastToAll (Object objectToSend) {
		for (Pair<ServerReadThread, ServerWriteThread> s: connectedClients) {
			s.getSecond().writeMsg(objectToSend);
		}
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
				String clientIp = newSocket.getInetAddress().getHostAddress();
				System.out.println("New Client Connected: " + clientIp);
				
				// Now Connect The Clients That Are Connected To The Server
				ServerReadThread newClient = new ServerReadThread(newSocket, this);
				ServerWriteThread clientWriter = new ServerWriteThread(newClient.getOutStream(), theGame, clientIp);
				
				// Start The Reader And Writers
				newClient.start();
				clientWriter.start();
				
				connectedClients.add(new Pair<ServerReadThread, ServerWriteThread>(newClient, clientWriter));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*************************** Handle The Incoming Messages ************************/
	public void handleIncomingPlayer (PlayerBase incoming, ServerReadThread caller) {
	   System.out.println("Handling New Player Addition");
	   incoming.initializePlayer();
	   incoming.setPlayerIP(caller.getReadingIp());
	   theGame.addPlayer(incoming);
	}
	
	public void handleUpdate (Clearing incoming, ServerReadThread caller) {
		System.out.println("Handling Player Update");
		Clearing moveTo = theGame.getClearingByName(incoming.getClearingName());
		theGame.getCurrentPlayer().moveToClearing(moveTo);
	}
	
	public void handleMessage (MessageType incoming, ServerReadThread caller) {
		if (incoming.equals(MessageType.START_GAME)){
			theGame.handleStartGame();
		}
	}

	public boolean isProcessing() {
		return processing;
	}

	public void setProcessing(boolean processing) {
		this.processing = processing;
	}
}
