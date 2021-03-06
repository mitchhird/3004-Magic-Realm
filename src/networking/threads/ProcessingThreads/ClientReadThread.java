package networking.threads.ProcessingThreads;

import java.io.ObjectInputStream;

import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.otherEntities.CombatDataContainer;
import networking.sendables.MessageType;
import networking.sendables.PlayerListUpdate;
import networking.sendables.SyncDataObject;
import networking.sendables.TreasureUpdateModel;
import networking.sendables.UpdateDataObject;
import networking.threads.BaseThreads.ReaderThreadBase;
import views.MainViews.GameView;

/**
 * Client Reading Thread That Will Simply Read Messages From The Server And Process The Data
 *    --- Basically Acts A Little Mini Server, But It Board Casts 0 Messages
 * @author Mitchell
 */
public class ClientReadThread extends ReaderThreadBase {

	private String connectedTo;
	private ObjectInputStream readStream;
	
	// Specific Server To Connect Top
	public ClientReadThread (ObjectInputStream inStream, String serverIP, GameView parent) {
		processing = false;
		this.mainGame = parent;
		readStream = inStream;
		connectedTo = serverIP;
		
		// Set The Thread Name So We Can See It
		setName("Client Read Thead (" + connectedTo + ")");
		parent.setClientReaderThread(this);
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
				
				// We Have Read Something, Set Processing To True
				processing = true;
				
				if (incoming instanceof PlayerBase) {
					PlayerBase incomingPlayer = (PlayerBase) incoming;
					handleIncomingPlayer(incomingPlayer);
				} else if (incoming instanceof MessageType) {
					MessageType incomingString = (MessageType) incoming;
					handleMessage(incomingString);
				} else if (incoming instanceof Clearing) {
					Clearing incomingClearing = (Clearing) incoming;
					handleUpdate(incomingClearing);
				} else if (incoming instanceof UpdateDataObject) {
					UpdateDataObject incomingContainer = (UpdateDataObject) incoming;
					handleContainer(incomingContainer);
				} else if (incoming instanceof CombatDataContainer) {
					CombatDataContainer incomingContainer = (CombatDataContainer) incoming;
					handleCombatDataContainer(incomingContainer);
				} else if (incoming instanceof SyncDataObject) {
					SyncDataObject incomingContainer = (SyncDataObject) incoming;
					handleSyncContainer(incomingContainer);
				} else if (incoming instanceof PlayerListUpdate) {
					setProcessing(false);
					PlayerListUpdate incomingContainer = (PlayerListUpdate) incoming;
					handlePlayerListUpdate(incomingContainer);
				} else if (incoming instanceof TreasureUpdateModel) {
					TreasureUpdateModel incomingContainer = (TreasureUpdateModel) incoming;
					handleTreasureUpdate(incomingContainer);
				}
				
			   processing = false;
			} catch (Exception e) {
				e.printStackTrace();
				closeConnection();
				break;
			}
		}
	}
	
	/*************************** Handle The Incoming Messages ************************/
	public void handleIncomingPlayer (PlayerBase incoming) {
	   System.out.println("Handling New Player Addition");
	   incoming.initPlayerStats();
	   incoming.setClass(incoming.getPlayerClass());
	   incoming.initializePlayerImage();
	   incoming.setPlayerIP(connectedTo);
	   mainGame.addPlayer(incoming);
	}
	
	/************************** Getters And Setters *********************************/
	public boolean isProcessing() {
		return processing;
	}

	public void setProcessing(boolean processing) {
		this.processing = processing;
	}	
}
