package networking.threads.ProcessingThreads;

import java.io.IOException;
import java.io.ObjectOutputStream;

import views.MainViews.GameView;

public class ServerWriteThread extends Thread {
	private GameView parent;
	private ObjectOutputStream writeStream;
	
	// Specific Server To Connect Top
	public ServerWriteThread (ObjectOutputStream outStream, GameView parent, String ip) {
		writeStream = outStream;
		this.parent = parent;
		setName("Server Write Thread ( " + ip + ")");
	}
	
	// Send A Message To The Server If The Connection
	public boolean writeMsg(Object o) {
		
		// Send The Object Over To The Server
		try {
			writeStream.writeUnshared(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// Close The Connection Up
	public void closeConnection() {
		try {
			if (writeStream != null) {
				writeStream.close();
			}
		} catch (Exception e) {
		}
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
}
