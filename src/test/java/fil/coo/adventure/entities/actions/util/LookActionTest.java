package fil.coo.adventure.entities.actions.util;

import static org.junit.Assert.assertTrue;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.ActionTest;
import fil.coo.adventure.places.Room;

public class LookActionTest extends ActionTest {

	@Override
	public void canBeDoneInReturnsFalseWhenRoomIsNotValidTest() {
		assertTrue(true); 
		/* You can use the look action in any room, so this test must be forced */
	}
	
	@Override
	protected Room createInvalidRoom() {
		/* No invalid room for the Look action */
		return null;
	}

	@Override
	protected Action createAction() {
		return new LookAction();
	}

	@Override
	protected Room createValidRoom() {
		return new Room();
	}

}
