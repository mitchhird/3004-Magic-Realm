package networking;

import java.net.Socket;

/**
 * Client Thread That Will Communicate With The Server And Give The Client Updates
 *    - Will Be Expanded Upon In The Future But For Now It's A Skeleton
 * @author Mitchell
 */
public class ClientThread extends TransmissionThreadBase {

	// Specific Server To Connect Top
	public ClientThread (String serverHost, int serverPort) {
		super(serverHost, serverPort);
	}
	
	// Socket Constructor For The Thread
	public ClientThread(Socket newSocket) {
		super(newSocket);
	}

}
