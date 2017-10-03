package fil.coo.adventure.entities;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class defines the player that will be roaming the dungeon room in goal
 * to find an exit. The player holds a list of Actions (List<Action>) that define
 * what Actions he can perform, meaning that in the main class, the player's
 * capabilities need to be specified to the player using the addCapability method.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Player extends GameCharacter {

	private List<Action> playerCapabilities;

	public Player(int lp, int sp) {
		super(lp,sp);
		this.playerCapabilities = new ArrayList<Action>();
	}

	/**
	 * Setter function, that allows the user to allow the player to perform a new Action.
	 * @param a The Action that will be added to the player's capabilites
	 */
	public void addCapability (Action a) {
		this.playerCapabilities.add(a);
	}

	/**
	 * Gives the list of Actions that the player can do.
	 * @return The list of Actions that the player can do.
	 */
	public List<Action> canDo() {
		return this.playerCapabilities;
	}

	@Override
	/**
	 * Defines what happens when the player dies. If this method is called on a live player, it will kill him.
	 * This also prints a message, that tells the player that he is now dead.
	 */
	public void die() {
		this.loseLife(this.getLifePoints());
		System.out.println("\t> "+Translator.translate("PlayerDie"));
	}
	
	/**
	 * Prints a message describing what happened when this object hits another
	 * In this case (Player), this prints a message detailing how much life points the character, that the 
	 * player hit, lost.
	 */
	protected void hit() {
		System.out.println("\t> "+Translator.translate("ItLost")+" "+this.getStrength()+" "+Translator.translate("LifePoints"));
	}
	
	/**
	 * Prints a message describing what happened when this object gets hit by another
	 * In this case (Player), this doesn't print a message, instead it tells the character
	 * that the player hit, to hit the player back.
	 * @param attacker The character that the player just hit.
	 */
	protected void gotHitBy(GameCharacter attacker) {
		attacker.attack(this);
	}

	/**
	 * Gives the <em>score</em> of the player, this score is calculated based on
	 * his gold, his Life points and his strength points.
	 * @return The integer representing his score.
	 */
	public int getscore() {
		return this.gold*(this.LifePoints+this.strength);
	}
	
	@Override
	/**
	 * Gives the name of this player
	 * @return His name
	 */
	public String name() {
		return Translator.translate("name");
	}
	
	@Override
	/**
	 * Check Lookable Interface Doc.
	 */
	public String description() {
		return "\n"+Translator.translate("CharacterDescription")+" :\n\t"+Translator.translate("LifePoints")+" : "+this.getLifePoints()+"\n\t"+Translator.translate("StrengthPoints")+" : "+this.getStrength()+"\n\t"+Translator.translate("GoldCoins")+" : "+this.getGold();
	}
}
