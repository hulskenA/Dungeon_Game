package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.*;
import fil.coo.adventure.entities.monsters.util.*;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.util.Lookable;

public class Room implements Lookable {
	private static ArrayList<String> descriptions = new ArrayList<String>(); {{
		descriptions.add(new String("This is a normal room"));
		descriptions.add(new String("Vous entrée dans une salle à manger, il y a un de ces festins sur la table mais attention ce doit être un piège"));
		descriptions.add(new String("Oh il y a une fenêtre ici, je ne me souvenais plus à quoi ressemblait le solei... Ah non, il fait nuit --'"));
		descriptions.add(new String("Encore une chambre !!!! Mais on ne trouve que ça ici ou quoi?"));
		descriptions.add(new String("Et oui je me suis amusé à décrire plein de pièces, mais pas celle-ci Mouahah... *un rire diabolique*"));
		descriptions.add(new String("Tiens pourquoi tant de sang ici?"));
		descriptions.add(new String("Allez ooouuuuuuuuiiiiiiiii une salle de jeu... Ah non c'est une salle de torture, bon ba c'est presque pareille de toute façon"));
		descriptions.add(new String("C'est sale, qui fait le ménage ici que j'aille me plaindre"));
		descriptions.add(new String("UNE SALLE DE COURS !!! NOOOOOOOOOOOON PAS CA..."));
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
		return "You are in a normal dungeon room, it is dark...";
	}

	public String description() {
		return descriptions.get(this.isDiscovered);
	}
	
	public GameCharacters alea() {
		Random r = new Random();
		return this.getCharacters().get(r.nextInt(this.getCharacters().size()));
	}
}
