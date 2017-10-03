package fil.coo.adventure.entities.actions.util;

import static org.junit.Assert.*;

import javax.swing.ActionMap;

import org.junit.Test;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.actions.ActionTest;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class AttackActionTest extends ActionTest {

	protected Room createInvalidRoom() {
		Room r = new Room();
		r.discovered();
		return r;
	}

	protected Action createAction() {
		return new AttackAction();
	}

	protected Room createValidRoom() {
		Room r = new Room();
		r.addCharacter(new Goblin(15,5));
		return r;
	}
	
}
