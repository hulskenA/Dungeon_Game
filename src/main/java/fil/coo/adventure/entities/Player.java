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

	@Override
	public void die() {
		this.loseLife(this.getLifePoints());
		System.out.println("\t> "+AdventureGame.translator.translate("PlayerDie"));
	}

	@Override
	public String description() {
		return "\n"+AdventureGame.translator.translate("CharacterDescription")+" :\n\t"+AdventureGame.translator.translate("LifePoints")+" : "+this.getLifePoints()+"\n\t"+AdventureGame.translator.translate("StrengthPoints")+" : "+this.getStrength()+"\n\t"+AdventureGame.translator.translate("GoldCoins")+" : "+this.getGold();
	}

	@Override
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		System.out.println("\t> "+AdventureGame.translator.translate("ItLost")+" "+this.getStrength()+" "+AdventureGame.translator.translate("LifePoints"));
		if (theOtherCharacterToAttack.isAlive()) {
			theOtherCharacterToAttack.attack(this);
		} else {
			theOtherCharacterToAttack.die();
		}
	}

	@Override
	public String name() {
		return AdventureGame.translator.translate("name");
	}

	public int getscore() {
		return this.gold*(this.LifePoints+this.strength);
	}
}
