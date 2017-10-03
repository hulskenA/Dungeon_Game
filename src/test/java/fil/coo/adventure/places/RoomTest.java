package fil.coo.adventure.places;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.util.LookAction;
import fil.coo.adventure.entities.items.Item;

public class RoomTest {
	
	@Test
	public void addCharacterAddsCharacterToRoomTest() {
		Room r = this.createRoom();
		GameCharacter c = new MockGameCharacter(10,10);
		assertFalse(r.getCharacters().contains(c));
		r.addCharacter(c);
		assertTrue(r.getCharacters().contains(c));
	}
	
	@Test
	public void removeCharacterRemovesCharacterTest() {
		Room r = this.createRoom();
		GameCharacter c = new MockGameCharacter(10,10);
		assertFalse(r.getCharacters().contains(c));
		r.addCharacter(c);
		assertTrue(r.getCharacters().contains(c));
		r.removeCharacter(c);
		assertFalse(r.getCharacters().contains(c));
	}
	
	@Test
	public void getCharactersGivesTheCharactersTest() {
		Room r = this.createRoom();
		GameCharacter c1 = new MockGameCharacter(10,10);
		GameCharacter c2 = new MockGameCharacter(10,10);
		GameCharacter c3 = new MockGameCharacter(10,10);
		assertTrue(r.getCharacters().isEmpty());
		r.addCharacter(c1);
		r.addCharacter(c2);
		r.addCharacter(c3);
		GameCharacter[] myChars = new GameCharacter[3];
		myChars[0] = c1;
		myChars[1] = c2;
		myChars[2] = c3;
		int i = 0;
		for(GameCharacter c: r.getCharacters()) {
			assertEquals(myChars[i],c);
			i++;
		}
	}
	
	@Test
	public void addDeadAddsToDeadTest() {
		Room r = this.createRoom();
		GameCharacter c = new MockGameCharacter(10,10);
		assertFalse(r.getDeads().contains(c));
		r.addDead(c);
		assertTrue(r.getDeads().contains(c));
	}
	
	@Test
	public void removeDeadremovesDeadTest() {
		Room r = this.createRoom();
		GameCharacter c = new MockGameCharacter(10,10);
		assertFalse(r.getDeads().contains(c));
		r.addDead(c);
		assertTrue(r.getDeads().contains(c));
		r.removeDead(c);
		assertFalse(r.getDeads().contains(c));
	}
	
	@Test
	public void getDeadsGivesTheDeadCharactersOfTheRoomTest() {
		Room r = this.createRoom();
		GameCharacter c1 = new MockGameCharacter(10,10);
		GameCharacter c2 = new MockGameCharacter(10,10);
		GameCharacter c3 = new MockGameCharacter(10,10);
		assertTrue(r.getDeads().isEmpty());
		r.addDead(c1);
		r.addDead(c2);
		r.addDead(c3);
		GameCharacter[] myChars = new GameCharacter[3];
		myChars[0] = c1;
		myChars[1] = c2;
		myChars[2] = c3;
		int i = 0;
		for(GameCharacter c: r.getDeads()) {
			assertEquals(myChars[i],c);
			i++;
		}
	}
	
	@Test
	public void addItemAddsItemTest() {
		Room r = this.createRoom();
		Item i = new MockItem();
		assertFalse(r.getItems().contains(i));
		r.addItem(i);
		assertTrue(r.getItems().contains(i));
	}
	
	public void removeItemRemovesItemTest() {
		Room r = this.createRoom();
		Item i = new MockItem();
		assertFalse(r.getItems().contains(i));
		r.addItem(i);
		assertTrue(r.getItems().contains(i));
		r.removeItem(i);
		assertFalse(r.getItems().contains(i));
	}
	
	public void getItemsGetsTheItemsOfTheRoomTest() {
		Room r = this.createRoom();
		Item i1 = new MockItem();
		Item i2 = new MockItem();
		Item i3 = new MockItem();
		assertTrue(r.getItems().isEmpty());
		r.addItem(i1);
		r.addItem(i2);
		r.addItem(i3);
		Item[] myItems = new Item[3];
		myItems[0] = i1;
		myItems[1] = i2;
		myItems[2] = i3;
		int i = 0;
		for(Item c: r.getItems()) {
			assertEquals(myItems[i],c);
			i++;
		}
	}
	
	@Test
	public void isExitTellsIfActualExit() {
		Room r = new Room();
		assertFalse(r.isExit());
	}
	
	@Test
	public void isDiscoveredTest() {
		Room r = this.createRoom();
		assertFalse(r.isDiscoverd());
		Player p = new Player(50,50);
		p.moveTo(r);
		r.addCharacter(p);
		Action a = new LookAction();
		a.doneBy(p);
		assertTrue(r.isDiscoverd());
	}
	
	@Test
	public void discoveredDiscoveresTheRoomTest() {
		Room r = this.createRoom();
		assertFalse(r.isDiscoverd());
		r.discovered();
		assertTrue(r.isDiscoverd());
	}
	
	@Test
	public void addNeighbourAddsNeighbourTest() {
		Room r = this.createRoom();
		assertTrue(r.getPossibleDirections().isEmpty());
		r.addNeighbour(Direction.E, new Room());
		assertTrue(r.getPossibleDirections().contains(Direction.E));
	}
	
	@Test
	public void getNeightbourReturnsCorrectNeightbor() {
		Room r = this.createRoom();
		assertTrue(r.getPossibleDirections().isEmpty());
		r.addNeighbour(Direction.E, this.createRoom());
		r.addNeighbour(Direction.N, this.createRoom());
		assertTrue(r.getNeighbour(Direction.S)==null);
		assertTrue(r.getNeighbour(Direction.W)==null);
		assertTrue(r.getNeighbour(Direction.E)!=null);
		assertTrue(r.getNeighbour(Direction.N)!=null);
	}
	
	@Test
	public void getPossibleDirectionsGivesAllPossibleDirectionsTest() {
		Room r = this.createRoom();
		assertTrue(r.getPossibleDirections().isEmpty());
		r.addNeighbour(Direction.E, this.createRoom());
		r.addNeighbour(Direction.N, this.createRoom());
		assertTrue(r.getPossibleDirections().size()==2);
		assertTrue(r.getPossibleDirections().contains(Direction.E));
		assertTrue(r.getPossibleDirections().contains(Direction.N));
		assertFalse(r.getPossibleDirections().contains(Direction.S));
		assertFalse(r.getPossibleDirections().contains(Direction.W));
	}
	
	@Test
	public void addDescriptionAddsTheDescriptionAndDescriptionGivesItTest() {
		Room r = this.createRoom();
		String desc = "This room has blue walls, how strange...";
		assertTrue(r.description()=="");
		r.addDescription(desc);
		assertTrue(r.description()==desc);
	}
	
	protected Room createRoom() {
		return new Room();
	}

	private class MockGameCharacter extends GameCharacter {
		public MockGameCharacter(int i, int j) {
			super(i,j);
		}
		@Override
		protected void hit() {
			return;
		}
		@Override
		protected void gotHitBy(GameCharacter attacker) {
			return;
		}
		@Override
		public void die() {
			return;
		}
		@Override
		public String description() {
			return "Mock character";
		}
		@Override
		public String name() {
			return "Bob";
		}
	}
	
	private class MockItem implements Item {

		public void isUsedBy(Player player) {
			player.addGold(9999999);
		}

		public String description() {
			return "Mock item";
		}
		
	}
}
