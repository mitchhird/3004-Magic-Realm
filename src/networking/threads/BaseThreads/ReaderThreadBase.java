package networking.threads.BaseThreads;

import java.util.ArrayList;

import views.MainViews.GameView;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.otherEntities.CombatDataContainer;
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
	
	public void handleCombatDataContainer (CombatDataContainer incoming) {
		// If The Game Is In Combat Then Handle The Incoming Data Container
		if (mainGame.getCurrentCombatWindow() != null) {
			System.out.println("Handling Combat Data Container");
			ArrayList <PlayerBase> combatPlayers= mainGame.getCurrentCombatWindow().getCombatingPlayers();
			
			// Find The Defending And Attacking Players
			PlayerBase defender = null;
			PlayerBase attacker = null;
			
			// Find The Defender
			for (PlayerBase p: combatPlayers) {
				if (p.getName().equals(incoming.getTheDefender().getName())) {
					defender = p;
					break;
				}
			}
			
			// If We Find A Player With This Name Then Set The Values
			for (PlayerBase p: combatPlayers) {
				// Set All The Data We Need
				if (p.getName().equals(incoming.getThePlayer().getName())) {
					p.getCombatData().setAttack(incoming.getAttack());
					p.getCombatData().setDefense(incoming.getDefense());
					attacker = p;
					break;
				}
			}
			
			// If Both Attacker And Defender Are Defined Then Add Them In
			if (attacker != null && defender != null) {
				mainGame.getCurrentCombatWindow().addReadyPlayerPair(attacker, defender);
			}
			
		} else {
			System.out.println("Not In Combat... Ignoring Container");
		}
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
		} else if (incoming == MessageType.START_COMBAT) {
			if (mainGame.getCurrentCombatWindow() != null) {
				mainGame.getCurrentCombatWindow().startCombat();
			}
		}
	}

	public void handleContainer(UpdateDataObject incoming) {
		if (incoming.getUpdateType() == MessageType.UPDATE_PLAYER_HIDE) {
			mainGame.getCurrentPlayer().setHidden(incoming.isHidden());
		}
	}
}
