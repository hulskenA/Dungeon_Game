package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.ActionTest;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class LootActionTest extends ActionTest {

	@Override
	protected Room createInvalidRoom() {
		return new Room();
	}

	@Override
	protected Action createAction() {
		return new LootAction();
	}

	@Override
	protected Room createValidRoom() {
		Room r = new Room();
		r.addDead(new Goblin());
		r.discovered();
		return r;
	}

}
