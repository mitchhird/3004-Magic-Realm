package networking;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client Thread That Will Communicate With The Server And Give The Client Updates
 *    - Will Be Expanded Upon In The Future But For Now It's A Skeleton
 *    - Might Be Best If This An Observable,
 * @author Mitchell
 */
public class ClientThread extends TransmissionThreadBase {

	// Specific Server To Connect Top
	public ClientThread (String serverHost, int serverPort) {
		super(serverHost, serverPort);
		try {
			setName ("Client Thread " + InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Socket Constructor For The Thread
	public ClientThread(Socket newSocket) {
		super(newSocket);
	}

}
