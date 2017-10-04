package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.util.Lookable;
import fil.coo.adventure.util.langages.Translator;

/**
 * Room class, representing the rooms in our dungeon game.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Room implements Lookable {

	protected List<GameCharacter> characters;
	protected List<GameCharacter> deadCharacters;
	protected List<Item> items;
	protected Map<Direction, Room> neighbour;
	protected boolean isDiscovered;
	protected String description;

	public Room() {
		this.characters = new ArrayList<GameCharacter>();
		this.items = new ArrayList<Item>();
		this.deadCharacters = new ArrayList<GameCharacter>();
		this.neighbour = new HashMap<Direction, Room>();
		this.isDiscovered = false;
		this.description = "";
	}

	/**
	 * Add a character to the Room.
	 * @param c The Character that will be added
	 */
	public void addCharacter(GameCharacter c) {
		this.characters.add(c);
		c.moveTo(this);
	}

	/**
	 * Removes a GameCharacter from the Room.
	 * @param c The Character that will be removed from the Room.
	 */
	public void removeCharacter(GameCharacter c) {
		this.characters.remove(c);
	}

	/**
	 * Gives the list of Characters in the Room
	 * @return The list of GameCharacters in the room.
	 */
	public List<GameCharacter> getCharacters() {
		return this.characters;
	}

	/**
	 * Adds a GameCharacter to the list of dead characters in the room.
	 * @param dead The GameCharacter that will be added to the list of dead characters in the room.
	 */
	public void addDead(GameCharacter dead) {
		this.deadCharacters.add(dead);
	}

	/**
	 * Removes a GameCharacter from the list of dead characters of the room.
	 * @param dead The GameCharacter that will be remove from the list of dead characters of the room.
	 */
	public void removeDead(GameCharacter dead) {
		this.deadCharacters.remove(dead);
	}

	/**
	 * Gives the list of dead GameCharacters in the room.
	 * @return The list of dead characters of this room.
	 */
	public List<GameCharacter> getDeads() {
		return this.deadCharacters;
	}

	/**
	 * Adds an item to the Room.
	 * @param item The item that will be added to the Room.
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}

	/**
	 * Removes an item from the Room.
	 * @param item The item that will be remove from the Room.
	 */
	public void removeItem(Item item) {
		this.items.remove(item);
	}

	/**
	 * Gives the list of items in the room.
	 * @return The list of items in the room.
	 */
	public List<Item> getItems() {
		return this.items;
	}

	/**
	 * Tells whether this particular room is an exit
	 * @return true if the room is an exit, false otherwise
	 */
	public boolean isExit() {
		return false;
	}

	/**
	 * Tells whether the Player has discovered this room. (Has `looked` at it)
	 * @return true if the player has discovered it, false otherwise
	 */
	public boolean isDiscoverd() {
		return this.isDiscovered;
	}

	/**
	 * Predicate that discovers the room, i.e. sets the isDiscovered attribute to true
	 */
	public void discovered() {
		this.isDiscovered = true;
	}

	/**
	 * Adds a Room r in the given Direction d.
	 * @param d The direction in which the room should be put
	 * @param r The room that will be put in said direction d
	 */
	public void addNeighbour(Direction d, Room r) {
		this.neighbour.put(d, r);
		r.neighbour.put(d.opposite(), this);
	}

	/**
	 * Gives a set of direction in which the player can take, i.e.
	 * the direction at which there are rooms.
	 * @return A set containing the direction that the player can take
	 */
	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}

	/**
	 * Gives the neighbor room in a given direction d
	 * @param d the direction from which we want a room
	 * @return The room found
	 */
	public Room getNeighbour(Direction d) {
		return this.neighbour.get(d);
	}

	/**
	 * Adds a description to the room
	 * @param descString The string that will be attached as a description to the room.
	 */
	public void addDescription(String descString) {
		this.description = descString;
	}

	/**
	 * Gives the description of the room
	 * @return the String containing the description
	 */
	public String description() {
		return this.description;
	}

	/**
	 * Returns a random character from the list of characters in the room
	 * @return A game character selected at random
	 */
	public GameCharacter alea() {
		Random r = new Random();
		return this.getCharacters().get(r.nextInt(this.getCharacters().size()));
	}

	public String toString() {
		return Translator.translate("RoomToString");
	}
}
