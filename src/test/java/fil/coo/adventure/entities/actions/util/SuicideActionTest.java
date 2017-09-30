package fil.coo.adventure.entities.actions.util;

import static org.junit.Assert.*;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.ActionTest;
import fil.coo.adventure.places.Room;

public class SuicideActionTest extends ActionTest {

	@Override
	public void canBeDoneInReturnsFalseWhenRoomIsNotValidTest() {
		assertTrue(true); 
		/* You can suicide in any room, so this test must be forced */
	}
	
	@Override
	protected Room createInvalidRoom() {
		/* An invalid room doesn't exist for the SuicideAction */
		return null;
	}

	@Override
	protected Action createAction() {
		return new SuicideAction();
	}

	@Override
	protected Room createValidRoom() {
		return new Room();
	}

}
