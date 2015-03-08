package networking;

import java.net.Socket;

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
	public ServerReadThread(Socket newSocket) {
		super(newSocket);
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
				
				// Broadcast The Message To The Others
				boardcastToOthers(incoming);
			} catch (Exception e) {
				closeConnection();
				break;
			}
		};
	}
}
