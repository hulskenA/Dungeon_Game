package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.*;
import fil.coo.adventure.entities.monsters.util.*;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.util.Lookable;

public class Room implements Lookable {
	private static ArrayList<String> descriptions = new ArrayList<String>(); {{
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription1"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription2"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription3"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription4"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription5"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription6"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription7"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription8"));
		descriptions.add(AdventureGame.TRANSLATOR.translate("RoomDescription9"));
	}}

	protected List<GameCharacters> characters;
	protected List<GameCharacters> deadCharacters;
	protected List<Item> items;
	protected Map<Direction, Room> neighbour;
	protected int isDiscovered;
	
	public Room() {
		this.characters = new ArrayList<GameCharacters>();
		this.items = new ArrayList<Item>();
		this.deadCharacters = new ArrayList<GameCharacters>();
		this.neighbour = new HashMap<Direction, Room>();
		this.isDiscovered = 0;
	}

	public void addCharacter(GameCharacters c) {
		this.characters.add(c);
		c.moveTo(this);
	}
	
	public void removeCharacter(GameCharacters c) {
		this.characters.remove(c);
	}
	
	public List<GameCharacters> getCharacters() {
		return this.characters;
	}
	
	public void addDead(GameCharacters dead) {
		this.deadCharacters.add(dead);
	}
	
	public void removeDead(GameCharacters dead) {
		this.deadCharacters.remove(dead);
	}
	
	public List<GameCharacters> getDeads() {
		return this.deadCharacters;
	}

	public void addItem(Item item) {
		this.items.add(item);
		item.setRoom(this);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public boolean isExit() {
		return false;
	}
	
	public boolean isDiscoverd() {
		return this.isDiscovered != 0;
	}
	
	public void discovered() {
		if (!this.isDiscoverd()) {
			Random r = new Random();
			this.isDiscovered = r.nextInt(descriptions.size());
		}
	}
	
	private void addNeighbour(Direction d, Room r) {
		this.neighbour.put(d, r);
	}
	
	public static Room generateMap() {
		Room room = new Room();
		Room tmp = new Room();
		Direction d = Direction.W;
		room.addCharacter(new Slime());
		room.addCharacter(new Balrog());
		room.addCharacter(new Dragon());
		room.addCharacter(new Goblin());
		room.addCharacter(new KingGoblin());
		room.addCharacter(new Kraken());
		room.addCharacter(new Looter());
		room.addCharacter(new Orc());
		room.addCharacter(new ZombiesHord());
		room.addItem(new OneArmedBandit());
		room.addItem(new GoldChest());
		room.addItem(new SleepedBadChest());
		room.addItem(new LifePotion());
		room.addItem(new StrengthPotion());
		room.addNeighbour(d, tmp);
		tmp.addNeighbour(d.opposite(), room);
		tmp = new Room();
		d = Direction.E;
		room.addNeighbour(d, tmp);
		tmp.addNeighbour(d.opposite(), room);
		tmp = new Exit();
		d = Direction.S;
		tmp.addNeighbour(d, room);
		room.addNeighbour(d.opposite(), tmp);
		return room;
	}
	
	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}
	
	public Room getNeighbour(Direction d) {
		return this.neighbour.get(d);
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("RoomToString");
	}

	public String description() {
		return descriptions.get(this.isDiscovered);
	}
	
	public GameCharacters alea() {
		Random r = new Random();
		return this.getCharacters().get(r.nextInt(this.getCharacters().size()));
	}
}
