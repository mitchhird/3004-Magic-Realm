package networking.threads.BaseThreads;

import views.MainViews.GameView;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import networking.sendables.MessageType;
import networking.sendables.UpdateDataObject;
import networking.threads.ProcessingThreads.ServerReadThread;

/**
 * Base Thread For Reading In Data From The Network. Any Changes Here Can Be Used Both On The Server End,
 * And The Client Read Thread. If A New Handler Function Is Added, Make Sure To Add It In The Proper Location
 * For Calling It
 * @author Mitchell
 */
public class ReaderThreadBase extends Thread {
	
	protected GameView mainGame;

	public void handleIncomingPlayer(PlayerBase incoming, ServerReadThread caller) {
		System.out.println("Handling New Player Addition");
		incoming.initPlayerStats();
		incoming.setClass(incoming.getPlayerClass());
		incoming.initializePlayerImage();
		incoming.setPlayerIP(caller.getReadingIp());
		mainGame.addPlayer(incoming);
	}

	public void handleUpdate(Clearing incoming) {
		System.out.println("Handling Player Update");
		Clearing moveTo = mainGame.getClearingByName(incoming.getClearingName());
		mainGame.getCurrentPlayer().moveToClearing(moveTo);
	}

	public void handleMessage(MessageType incoming) {
		if (incoming.equals(MessageType.START_GAME)) {
			mainGame.handleStartGame();
		} else if (incoming == MessageType.SEND_TURN) {
			mainGame.sendTurn();
		}
	}

	public void handleContainer(UpdateDataObject incoming) {
		if (incoming.getUpdateType() == MessageType.UPDATE_PLAYER_HIDE) {
			mainGame.getCurrentPlayer().setHidden(incoming.isHidden());
		}
	}
}
