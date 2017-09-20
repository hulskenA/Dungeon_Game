package adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import adventure.entities.GameCharacters;
import adventure.entities.Monster;
import adventure.entities.items.Item;
import adventure.places.directions.Direction;

public class Room {
	protected List<Monster> monsters;
	protected List<GameCharacters> deads;
	protected List<Item> items;
	protected Map<Direction, Room> neighbour;
	
	public Room() {
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.deads = new ArrayList<GameCharacters>();
		this.neighbour = new HashMap<Direction, Room>();
	}

	public void addMonster(Monster monster) {
		this.monsters.add(monster);
	}
	
	public void removeMonster(Monster monster) {
		this.monsters.remove(monster);
	}
	
	public List<Monster> getMonsters() {
		return this.monsters;
	}
	
	public void addDead(GameCharacters dead) {
		this.deads.add(dead);
	}
	
	public void removeDead(GameCharacters dead) {
		this.deads.remove(dead);
	}
	
	public List<GameCharacters> getDeads() {
		return this.deads;
	}

	public void addItem(Item item) {
		this.items.add(item);
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
		room.addNeighbour(adventure.places.directions.Direction.W, tmp);
		tmp.addNeighbour(adventure.places.directions.Direction.E, room);
		tmp = new Exit();
		tmp.addNeighbour(adventure.places.directions.Direction.S, room);
		room.addNeighbour(adventure.places.directions.Direction.N, tmp);
		return room;
		/*creer algo generation aleatoire de map*/
	}
	
	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}
	
	public Room getNeighbour(Direction d) {
		return this.neighbour.get(d);
	}
	
	public String toString() {
		return new String();
	}
}
