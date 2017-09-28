package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.*;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.*;
import fil.coo.adventure.places.Direction;

public class Room {
	protected List<GameCharacters> characters;
	protected List<GameCharacters> deadCharacters;
	protected List<Item> items;
	protected Map<Direction, Room> neighbour;
	
	public Room() {
		this.characters = new ArrayList<GameCharacters>();
		this.items = new ArrayList<Item>();
		this.deadCharacters = new ArrayList<GameCharacters>();
		this.neighbour = new HashMap<Direction, Room>();
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
	
	private void addNeighbour(Direction d, Room r) {
		this.neighbour.put(d, r);
	}
	
	public static Room generateMap() {
		Room room = new Room();
		Room tmp = new Room();
		room.addCharacter(new Slime());
		room.addNeighbour(Direction.W, tmp);
		tmp.addNeighbour(Direction.E, room);
		tmp = new Room();
		room.addNeighbour(Direction.E, tmp);
		tmp.addNeighbour(Direction.W, room);
		tmp.addItem(new OneArmedBandit());
		tmp.addCharacter(new Balrog());
		tmp = new Exit();
		tmp.addNeighbour(Direction.S, room);
		room.addNeighbour(Direction.N, tmp);
		return room;
	}
	
	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}
	
	public Room getNeighbour(Direction d) {
		return this.neighbour.get(d);
	}
	
	public String toString() {
		return "You are in a normal dungeon room, it is dark...";
	}
}
