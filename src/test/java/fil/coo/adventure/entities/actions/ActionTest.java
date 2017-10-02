package fil.coo.adventure.entities.actions;

import static org.junit.Assert.*;
import org.junit.Test;

import fil.coo.adventure.places.Room;

public abstract class ActionTest {
	@Test
	public void canBeDoneInReturnsTrueWhenRoomIsValidTest() {
		Action a = this.createAction();
		Room validRoom = this.createValidRoom();
		assertTrue(a.canBeDoneIn(validRoom));
	}
	
	@Test
	public void canBeDoneInReturnsFalseWhenRoomIsNotValidTest() {
		Action a = this.createAction();
		Room invalidRoom = this.createInvalidRoom();
		assertFalse(a.canBeDoneIn(invalidRoom));
	}

	protected abstract Room createInvalidRoom();

	protected abstract Action createAction();

	protected abstract Room createValidRoom();
}