package fil.coo.adventure.entities.items;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.Lookable;

public abstract class Item implements Lookable {
	protected Room currentRoom;
	
	public abstract void isUsedBy(Player player);
	public abstract String description();
	
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	public void setRoom(Room r) {
		this.currentRoom = r;
	}
}
