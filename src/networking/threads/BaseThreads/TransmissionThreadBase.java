package networking.threads.BaseThreads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TransmissionThreadBase extends Thread {

	protected Socket transmissionSocket;
	protected ObjectInputStream inStream;
	protected ObjectOutputStream outStream;

	// IP And Port Constructor
	public TransmissionThreadBase (String host, int port) {
		try {
			transmissionSocket = new Socket (host, port);
			initStreams();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server Not Found");
		}
	}
	
	// Constructor For The Client Thread
	public TransmissionThreadBase(Socket newSocket) {
		transmissionSocket = newSocket;
		initStreams();
	}

	// Setup The Streams For The Connection
	private void initStreams() {
		try {
			// Setup The Streams
			outStream = new ObjectOutputStream(transmissionSocket.getOutputStream());
			inStream = new ObjectInputStream(transmissionSocket.getInputStream());

			// Display The Data Out From The Client
			String clientIP = transmissionSocket.getInetAddress().getHostAddress();
			System.out.println("Client Connected From: " + clientIP);
		} catch (IOException e) {
			System.out.println("An Error Occured With Client Connection...");
			e.printStackTrace();
		}
	}

	// Method Closes The Socket
	public void closeConnection() {
		// Close The Input Stream
		try {
			if (inStream != null) {
				inStream.close();
			}
		} catch (Exception e) {
		}

		// Close The Output Stream
		try {
			if (outStream != null) {
				outStream.close();
			}
		} catch (Exception e) {
		}

		// Close The Client Socket
		try {
			if (transmissionSocket != null) {
				transmissionSocket.close();
			}
		} catch (Exception e) {
		}
	}

	// Send A Message To The Server If The Connection
	public boolean writeMsg(Object o) {
		if (!transmissionSocket.isConnected()) {
			closeConnection();
			return false;
		}

		// Send The Object Over To The Server
		try {
			outStream.writeUnshared(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void run() {
		while (true) {
			try {
				
			} catch (Exception e) {
				closeConnection();
				break;
			}
		}
	}

	public ObjectInputStream getInStream() {
		return inStream;
	}

	public ObjectOutputStream getOutStream() {
		return outStream;
	}
	
	
}
