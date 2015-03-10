package networking;

import java.net.Socket;

import javax.print.attribute.standard.Severity;

import models.characterModels.PlayerBase;

/**
 * Client Thread That Will Communicate With The Server And Give The Server Updates
 * 	 --- Client Will Send A Message To The Server And It Will Broadcast To All Other Clients
 * @author Mitchell
 */
public class ServerReadThread extends TransmissionThreadBase {

	private ServerMainThread parentThread;
	
	// Specific Server To Connect Top
	public ServerReadThread (String serverHost, int serverPort, ServerMainThread parent) {
		super(serverHost, serverPort);
		parentThread = parent;
	}
	
	// Socket Constructor For The Thread
	public ServerReadThread(Socket newSocket, ServerMainThread parent) {
		super(newSocket);
		parentThread = parent;
		setName("Server Read Thread (" + newSocket.getInetAddress().getHostAddress() +")");
	}

	// Tell The Server To Send The Object To The Other Clients For Processing
	public void boardcastToOthers (Object objectToSend) {
		parentThread.broadcastToOthers(objectToSend, this);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Object incoming = inStream.readObject();
				System.out.println("Recieved From Client: " + incoming);
				
				// Call The Corresponding Function To The Data Type
				if (incoming instanceof PlayerBase) {
					PlayerBase incomingPlayer = (PlayerBase) incoming;
					parentThread.handleIncomingPlayer(incomingPlayer, this);
				} else if (incoming instanceof String) {
					String incomingString = (String) incoming;
					boardcastToOthers(incomingString);
				}
				
				// Broadcast The Message To The Others
				boardcastToOthers(incoming);
			} catch (Exception e) {
				e.printStackTrace();
				closeConnection();
				break;
			}
		};
	}
	
}
