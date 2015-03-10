package networking;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import models.characterModels.PlayerBase;
import views.GameView;

/**
 * Client Reading Thread That Will Simply Read Messages From The Server And Process The Data
 *    --- Basically Acts A Little Mini Server, But It Board Casts 0 Messages
 * @author Mitchell
 */
public class ClientReadThread extends Thread {

	private GameView parent;
	private ObjectInputStream readStream;
	
	// Specific Server To Connect Top
	public ClientReadThread (ObjectInputStream inStream, GameView parent) {
		readStream = inStream;
		this.parent = parent;
		
		// Set The Thread Name So We Can See It
		setName("Client Read Thead");
	}
	
	// Close The Connection Up
	public void closeConnection() {
		try {
			if (readStream != null) {
				readStream.close();
			}
		} catch (Exception e) {
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Object incoming = readStream.readObject();
				System.out.println("Recieved From Server: " + incoming);
				
				if (incoming instanceof PlayerBase) {
					PlayerBase incomingPlayer = (PlayerBase) incoming;
					handleIncomingPlayer(incomingPlayer);
				} else if (incoming instanceof String) {
					String incomingString = (String) incoming;
				}
				
			} catch (Exception e) {
				closeConnection();
				break;
			}
		}
	}
	
	/*************************** Handle The Incoming Messages ************************/
	public void handleIncomingPlayer (PlayerBase incoming) {
	   System.out.println("Handling New Player Addition");
	   parent.addPlayer(incoming);
	}
}
