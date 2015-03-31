package controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import networking.sendables.PlayerListUpdate;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import utils.GameUtils;
import views.MainViews.GameView;
import models.BoardModels.Clearing;
import models.characterModels.Amazon;
import models.characterModels.Elf;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

public class clientController {
	
	private GameView parent;
	private int currentPlayerIndex;
	private PlayerBase currentPlayer;
	private ArrayList<PlayerBase> thePlayers;
	
	private boolean gameStarted;

	public clientController(GameView theView){
		parent = theView;
		currentPlayerIndex = 0;
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	// Adds The Player to The Game
	public void addPlayer(CharacterClass playerClass, String playerName, ArrayList<Integer> points){
		addPlayer(playerClass, playerName, "localhost",points);
	}
	
	// Adds The Player To The Game 
	public void addPlayer (CharacterClass playerClass, String playerName, String ip,ArrayList<Integer> points){
		// Add The Player Into The List
		PlayerBase aPlayer;
		
		// Figure Out What Class To Make
		switch (playerClass) {
		case AMAZON:
			aPlayer = new Amazon(playerName, ip,points);
			break;
		case ELF:
			aPlayer = new Elf(playerName, ip,points);
			break;
		default:
			aPlayer = new PlayerBase(playerName, playerClass, ip,points);
			break;	
		}
		
		addPlayer(aPlayer);
		
		// Boardcast The Message Back Out
		if (parent.isNetworkedGame()) {
			parent.sendMessage(aPlayer);
		}
	}
	
	// Adds A Player That Is Already Known To The System
	public void addPlayer(PlayerBase aPlayer) {
		thePlayers.add(aPlayer);
		setCurrentPlayer(aPlayer);
		parent.getPlayerList().updateTable();
	}
	
	// Returns The player List From The Game
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}
	
	// Returns The Last Player
	public PlayerBase getLastPlayer () {
		return thePlayers.get(thePlayers.size() - 1);
	}
	
	// Moves To Next Player's Turn, Using Modulo Math
	public void moveToNextPlayer () {
		currentPlayerIndex++;
		boolean needToSort = false;
		
		// If We Are Completing A Cycle
		if(currentPlayerIndex % thePlayers.size() == 0){
			for(int i = 0; i < thePlayers.size(); i++){
				thePlayers.get(i).newDay();
				
				if (thePlayers.get(i).getPlayerClass() == CharacterClass.SWORDSMAN) {
					spawnSwordsmanSelectionDialog(thePlayers.get(i));
					needToSort = true;
				}
			}
		}

		if(currentPlayer.hasWon()){
			parent.displayWinner(currentPlayer.getName());
			parent.dispose();
		}
		
		if (needToSort) {
			setSwordsmenTurns(true);
		}
		
		currentPlayer = thePlayers.get(currentPlayerIndex % thePlayers.size());
		currentPlayer.startPlayerTurn();
		
		// TODO: Add The Proper Object For Board Interaction
		parent.sendMessage("Switching To Next Player");
	}
	
	// Spawns The Swordsman Selection
	private void spawnSwordsmanSelectionDialog (PlayerBase thePlayer) {
		if (!thePlayer.isNetworkedPlayer()) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Please Select When You Would Like Your Turn:");
			SpinnerNumberModel playerTurnTicker = new SpinnerNumberModel(1, 1, thePlayers.size(), 1);
			JSpinner spinnerDisplay = new JSpinner(playerTurnTicker);
		
			panel.add(label);
			panel.add(spinnerDisplay);
		
			String[] options = new String[]{"OK", "Cancel"};
			JOptionPane.showOptionDialog(null, panel, "Swordsmen Turn Selection (" + thePlayer.getName() + ")", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			thePlayer.setPlayerPriority(((int) spinnerDisplay.getValue()) - 1);
		}
	}
	
	private String getWinner() {		
		int maxGold = -1;
		String winner = "";
		for (int i = 0; i<thePlayers.size();i++) {
		   if (thePlayers.get(i).getGold() > maxGold) {
		      maxGold  =thePlayers.get(i).getGold();
		      winner = thePlayers.get(i).getName();
		   }
		}
		
		return winner;
	}

	// Starts The Game When Called
	public void startGame () {
		gameStarted = true;
		for (PlayerBase p: thePlayers) {
			if(p.getPlayerClass()!=CharacterClass.CAPTAIN && p.getPlayerClass()!=CharacterClass.DWARF){
				Clearing playerStart = parent.getBoardView().getDefaultClearingForClass(p.getPlayerClass());
				p.setCurrentClearing(playerStart);
				p.setHomeClearing(playerStart);
				playerStart.playerMovedToThis(p);
			}
		}
	}

	// Remove The Player From The List
	public void removePlayer(String playerToRemoveName) {
		for(int i = 0; i < thePlayers.size(); i++){
			if(thePlayers.get(i).getName() == playerToRemoveName){
				thePlayers.remove(i);
				return;
			}
		}
	}
	
	// Get Player By Name 
	public PlayerBase getPlayer (String name, CharacterClass charClass) {
		for (PlayerBase p: thePlayers) {
			if (p.getName().equals(name) && p.getPlayerClass() == charClass) {
				return p;
			}
		}
		return null;
	}
	
	// Gather All Of The Unhidden Players
	public ArrayList<PlayerBase> getUnhiddenPlayers () {
		ArrayList<PlayerBase> returnVal = new ArrayList<>();
		for (PlayerBase p: thePlayers) {
			if (!p.isHidden()) {
				returnVal.add(p);
			}
		}
		return returnVal;
	}
	
	/*-----------------  Getters And Setters -------------------------*/
	public PlayerBase getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
	
	private void setCurrentPlayer(PlayerBase aPlayer) {
		// If That Is The First Player, Set The Current Player To That
		if (thePlayers.size() == 1) {
			currentPlayer = aPlayer;
		}
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
	
	public void setSwordsmenTurns(boolean sendMessage) {
		ArrayList<PlayerBase> swordsmens = new ArrayList<PlayerBase>();
		
		// Collect All The Swordsmen
		for (PlayerBase p: thePlayers) {
			if (p.getPlayerClass() == CharacterClass.SWORDSMAN) {
				swordsmens.add(p);
			}
		}
		
		// Now For All The Swordsmen Remove Them And Put Them In Their Proper Locations
		for (PlayerBase p: swordsmens) {
			thePlayers.remove(p);
			
			try {
				thePlayers.add(p.getPlayerPriority(), p);
			} catch (Exception e) {
				thePlayers.add(0, p);
			}
			
			if (sendMessage)
				parent.sendMessage(new PlayerListUpdate(p));
		}
	} 
	
}
