package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.ActionTest;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class AttackActionTest extends ActionTest {

	@Override
	protected Room createInvalidRoom() {
		/* No monsters in the room */
		return new Room();
	}

	@Override
	protected Action createAction() {
		return new AttackAction();
	}

	@Override
	protected Room createValidRoom() {
		Room r = new Room();
		r.addCharacter(new Goblin());
		return r;
	}
	
}
