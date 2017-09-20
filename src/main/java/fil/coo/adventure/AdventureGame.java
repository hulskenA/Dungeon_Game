package adventure;

import adventure.entities.*;
import adventure.entities.items.Item;
import adventure.places.Room;
import adventure.places.directions.Direction;

public class AdventureGame {
	private Room currentRoom;
	private Player player;
	
	public AdventureGame(Room startingRoom) {
		this.currentRoom = startingRoom;
	}
	
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void play(Player player) {
		while(!this.isFinished()) {
			
		}
	}
	
	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
	}
	
	public void addItem(Item item, Room room) {
		room.addItem(item);
	}
	
	public boolean isFinished() {
		return this.player.getLifePoints() > 0 && this.currentRoom.isExit() && this.currentRoom.getMonsters().isEmpty();
	}
	
	public void playerMoveTo(Direction direction) {
		this.currentRoom = this.currentRoom.getNeighbour(direction);
	}
}
