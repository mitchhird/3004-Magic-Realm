package networking.threads.ProcessingThreads;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import networking.threads.BaseThreads.TransmissionThreadBase;
import views.MainViews.GameView;

/**
 * Client Thread That Will Communicate With The Server And Give The Client Updates
 * 	  --- Here Is The Current Flow Process, Clients Sends Update To Server Thread
 *        Server Thread Creates Manipulates The Object Before Sending It To The Server
 *    
 *    --- All Other Clients Get Updated With The New Change 
 *    
 *    --- There Is A Big Issue That Needs To Be Addressed Here, We Need To Create A Seperate
 *        Thread For Sending And Reading Messages From The Server
 *        --- This Is Because We Want To Be Able To Both Send A Message And Read At The Same
 *            Time... Which Will Increase Complexity
 * @author Mitchell
 */
public class ClientWriterThread extends TransmissionThreadBase {

	private GameView parent;
	
	// Specific Server To Connect Top
	public ClientWriterThread (String serverHost, int serverPort, GameView parent) {
		super(serverHost, serverPort);
		
		try {
			this.parent = parent;
			setName ("Client Thread " + InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Socket Constructor For The Thread
	public ClientWriterThread(Socket newSocket) {
		super(newSocket);
	}
}
