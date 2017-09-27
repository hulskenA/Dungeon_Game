package fil.coo.adventure.places;

public class Exit extends Room {
	public Exit() {
		super();
	}
	
	public boolean isExit() {
		return true;
	}
	
	public String toString() {
		return "You have reached the exit room!";
	}
}
