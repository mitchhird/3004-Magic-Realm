package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClearingTests {

	private Clearing clearingUnderTest;
	
	@Before
	public void setUp() throws Exception {
		clearingUnderTest = new Clearing("test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayerMovedToThis() {
		PlayerBase testPlayer = new PlayerBase("Bob", CharacterClass.BLACKNIGHT);
		clearingUnderTest.playerMovedToThis(testPlayer);
		
		// Player Should Be In The Clearing Now
		assertEquals(clearingUnderTest, testPlayer.getCurrentClearing());
		assertTrue (clearingUnderTest.getPlayersInClearing().contains(testPlayer));
	}

	@Test
	public void testPlayerMovedOffOf() {
		PlayerBase testPlayer = new PlayerBase("Bob", CharacterClass.BLACKNIGHT);
		clearingUnderTest.playerMovedToThis(testPlayer);
		
		// Player Should Be In The Clearing Now
		assertEquals(clearingUnderTest, testPlayer.getCurrentClearing());
		assertTrue (clearingUnderTest.getPlayersInClearing().contains(testPlayer));
		
		// Now Move The Player Off Of This
		clearingUnderTest.playerMovedOffOf(testPlayer);
		assertFalse (clearingUnderTest.getPlayersInClearing().contains(testPlayer));
		assertEquals (0, clearingUnderTest.getImageEnitiesOnThis().size());
	}

	@Test
	public void testIsVaildMove() {
		PlayerBase tempDude = new PlayerBase("bob", CharacterClass.AMAZON);
		Clearing connectedClearing = new Clearing ("test2");
		Clearing unconnectedClearing = new Clearing ("test3");
		
		// Connect To The Test Clearing, While Leaving The Other 
		clearingUnderTest.addConnectedClearing(connectedClearing);
		
		// Should Only Be Able To Move To Connected Clearings
		assertTrue(clearingUnderTest.isVaildMove(connectedClearing,tempDude));
		assertFalse(clearingUnderTest.isVaildMove(unconnectedClearing,tempDude));
	}

	@Test
	public void testAddToConnectedClearings() {
		Clearing connectedClearing = new Clearing ("test2");
		Clearing unconnectedClearing = new Clearing ("test3");
		
		// Connect To The Test Clearing, While Leaving The Other 
		clearingUnderTest.addConnectedClearing(connectedClearing);
		
		assertEquals (1, clearingUnderTest.getConnectedClearings().size());
		assertEquals (1, connectedClearing.getConnectedClearings().size());
		assertEquals (0, unconnectedClearing.getConnectedClearings().size());
	}

	@Test
	public void testGetClearingName() {
		String testVal = "testing";
		clearingUnderTest.setClearingName(testVal);
		assertEquals(testVal, clearingUnderTest.getClearingName());
	}

	@Test
	public void testGetImageEnitiesOnThis() {
		int testPlayerAmount = 10;
		ArrayList<PlayerBase> testPlayers = new ArrayList<PlayerBase>();
		
		for (int i =0; i < testPlayerAmount; i++) {
			PlayerBase newPlayer = new PlayerBase("testing" + i, CharacterClass.DWARF);
			testPlayers.add(newPlayer);
			clearingUnderTest.playerMovedToThis(newPlayer);
			assertEquals(clearingUnderTest, newPlayer.getCurrentClearing());
		}
		
		// Should Have 10 Images On This Clearing
		assertEquals(10, clearingUnderTest.getImageEnitiesOnThis().size());
	}

	@Test
	public void testGetPlayersInClearing() {
		int testPlayerAmount = 10;
		ArrayList<PlayerBase> testPlayers = new ArrayList<PlayerBase>();
		
		for (int i =0; i < testPlayerAmount; i++) {
			PlayerBase newPlayer = new PlayerBase("testing" + i, CharacterClass.DWARF);
			testPlayers.add(newPlayer);
			clearingUnderTest.playerMovedToThis(newPlayer);
			assertEquals(clearingUnderTest, newPlayer.getCurrentClearing());
		}
		
		ArrayList<PlayerBase> playersInClearing = clearingUnderTest.getPlayersInClearing();
		
		// Verify All Players Are In the Clearing
		for (PlayerBase p: testPlayers) {
			assertTrue (playersInClearing.contains(p));
		}
	}

}
