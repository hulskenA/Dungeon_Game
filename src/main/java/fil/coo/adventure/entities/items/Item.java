package fil.coo.adventure.entities.items;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;

public abstract class Item {
	protected Room currentRoom;
	
	public abstract void isUsedBy(Player player);
	
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	public void setRoom(Room r) {
		this.currentRoom = r;
	}
}
