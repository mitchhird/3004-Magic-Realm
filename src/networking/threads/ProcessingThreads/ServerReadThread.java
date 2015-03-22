package networking.threads.ProcessingThreads;

import java.net.Socket;

import javax.print.attribute.standard.Severity;

import networking.sendables.MessageType;
import networking.sendables.UpdateDataObject;
import networking.threads.BaseThreads.TransmissionThreadBase;
import sun.awt.windows.ThemeReader;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.otherEntities.CombatDataContainer;

/**
 * Client Thread That Will Communicate With The Server And Give The Server Updates
 * 	 --- Client Will Send A Message To The Server And It Will Broadcast To All Other Clients
 * @author Mitchell
 */
public class ServerReadThread extends TransmissionThreadBase {

	private String readingIp;
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
		readingIp = newSocket.getInetAddress().getHostAddress();
		setName("Server Read Thread (" + readingIp +")");
	}

	// Tell The Server To Send The Object To The Other Clients For Processing
	public void boardcastToOthers (Object objectToSend) {
		parentThread.broadcastToOthers(objectToSend, this);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Object incoming = inStream.readUnshared();
				System.out.println("Recieved From Client: " + incoming);
				
				parentThread.setProcessing(true);
				
				// Call The Corresponding Function To The Data Type
				if (incoming instanceof PlayerBase) {
					PlayerBase incomingPlayer = (PlayerBase) incoming;
					parentThread.handleIncomingPlayer(incomingPlayer, this);
				} else if (incoming instanceof MessageType) {
					MessageType incomingMessage = (MessageType) incoming;
					parentThread.handleMessage(incomingMessage);
				} else if (incoming instanceof Clearing) {
					Clearing incomingClearing = (Clearing) incoming;
					parentThread.handleUpdate(incomingClearing);
				} else if (incoming instanceof UpdateDataObject) {
					UpdateDataObject incomingContainer = (UpdateDataObject) incoming;
					parentThread.handleContainer(incomingContainer);
				} else if (incoming instanceof CombatDataContainer) {
					CombatDataContainer incomingContainer = (CombatDataContainer) incoming;
					parentThread.handleCombatDataContainer(incomingContainer);
				}
				
				// Broadcast The Message To The Others
				boardcastToOthers(incoming);
				
				parentThread.setProcessing(false);
			} catch (Exception e) {
				e.printStackTrace();
				closeConnection();
				break;
			}
		};
	}

	/************************** Getters And Setters ****************************/
	public String getReadingIp() {
		return readingIp;
	}

	public void setReadingIp(String readingIp) {
		this.readingIp = readingIp;
	}
}
