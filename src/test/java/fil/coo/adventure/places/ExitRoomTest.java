package fil.coo.adventure.places;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitRoomTest extends RoomTest {
	
	@Override
	protected Room createRoom() {
		return new Exit();
	}
	
	@Test
	@Override
	public void isExitTellsIfActualExit() {
		Room r = new Exit();
		assertTrue(r.isExit());
	}
}