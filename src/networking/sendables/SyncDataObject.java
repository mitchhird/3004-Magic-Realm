package networking.sendables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import models.BoardModels.Clearing;
import models.BoardModels.Dwelling;
import models.characterModels.PlayerBase;
import models.otherEntities.monsterModels.Ghost;

/**
 * Data Container For Synching The Client With The Server
 * 		--- Contains All Of The Board Information This Needed
 * @author Mitchell
 */
public class SyncDataObject implements Serializable {
	private ArrayList <Dwelling> dwellings;
	private ArrayList <Clearing> clearings;
	private HashMap <String, String> players;
	private static final long serialVersionUID = -3211078016039324328L;
	
	public SyncDataObject (ArrayList<Dwelling> dwellings, ArrayList<PlayerBase> players, ArrayList<Clearing> clearings) {
		this.dwellings = dwellings;
		this.players = new HashMap<>();
		this.clearings = clearings;
		
		// Only Add The Local Players
		for (PlayerBase p: players) {
			if (!p.isNetworkedPlayer()) {
				this.players.put(p.getName(), p.getCurrentClearing().getClearingName());
			}
		}
	}

	public ArrayList<Dwelling> getDwellings() {
		return dwellings;
	}

	public void setDwellings(ArrayList<Dwelling> dwellings) {
		this.dwellings = dwellings;
	}

	public HashMap<String, String> getPlayers() {
		return players;
	}

	public ArrayList<Clearing> getClearings() {
		return clearings;
	}
	
	
}
