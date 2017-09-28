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
		this.loseLife(this.getLifePoints());
		System.out.println("\t> You are died\n\t> You have lose this game\n\t> You are a shit\n\t> Ahahahah !!!\n\t> You are dead....");
	}

	@Override
	public String description() {
		return "\nCharacter's description :\n\tLife points : "+this.getLifePoints()+"\n\tStrength points : "+this.getStrength()+"\n\tGolds : "+this.getGold();
	}

	@Override
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		System.out.println("\t> It lost "+this.getStrength()+" Life Points");
		if (theOtherCharacterToAttack.isAlive()) {
			theOtherCharacterToAttack.attack(this);
		} else {
			theOtherCharacterToAttack.die();
		}
	}

	@Override
	public String name() {
		return "You";
	}
}
