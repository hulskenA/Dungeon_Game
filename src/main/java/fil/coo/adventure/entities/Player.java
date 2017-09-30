package fil.coo.adventure.entities;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.AdventureGame;
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
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("PlayerDie"));
	}

	@Override
	public String description() {
		return "\n"+AdventureGame.TRANSLATOR.translate("CharacterDescription")+" :\n\t"+AdventureGame.TRANSLATOR.translate("LifePoints")+" : "+this.getLifePoints()+"\n\t"+AdventureGame.TRANSLATOR.translate("StrengthPoints")+" : "+this.getStrength()+"\n\t"+AdventureGame.TRANSLATOR.translate("GoldCoins")+" : "+this.getGold();
	}

	@Override
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("ItLost")+" "+this.getStrength()+" "+AdventureGame.TRANSLATOR.translate("LifePoints"));
		if (theOtherCharacterToAttack.isAlive()) {
			theOtherCharacterToAttack.attack(this);
		} else {
			theOtherCharacterToAttack.die();
		}
	}

	@Override
	public String name() {
		return AdventureGame.TRANSLATOR.translate("name");
	}
}
