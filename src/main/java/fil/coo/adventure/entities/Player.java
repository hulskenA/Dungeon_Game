package fil.coo.adventure.entities;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.actions.Action;

public class Player extends GameCharacters {
	
	private List<Action> playerCapabilities;

	public Player(int lp, int sp) {
		super(lp,sp);
		this.playerCapabilities = new ArrayList<Action>();
	}

	public void addCapability (Action a) {
		this.playerCapabilities.add(a);
	}
	
	public List<Action> canDo() {
		return this.playerCapabilities;
	}
	
	public void die() {
		System.out.println("\t> You are dead....");
	}
}
