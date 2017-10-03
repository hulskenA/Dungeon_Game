package fil.coo.adventure;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.*;
import fil.coo.adventure.util.ListChoser;
import fil.coo.adventure.util.langages.Langages;
import fil.coo.adventure.util.langages.Translator;

/**
 * The AdventureGame class, that defines the main loop for our dungeon game
 * , that is the play method.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class AdventureGame {
	private Player player;

	public AdventureGame(Room startingRoom, Player player) {
		this.player = player;
		this.player.moveTo(startingRoom);
	}

	/**
	 * Returns the player that is currently playing the adventure game.
	 * @return The player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * The stop condition for the main loop of the game.
	 * @return boolean saying whether the game is over or not.
	 */
	private boolean isFinished() {
		return (!this.getPlayer().isAlive()) || (this.player.currentRoom().isExit() && this.player.currentRoom().getCharacters().isEmpty());
	}
	
	/**
	 * Defines the main loop for the dungeon game.
	 */
	public void play() {
		
		System.out.println(Translator.translate("Welcome"));

		while(!this.isFinished()) {
			System.out.println("\n\n------------------------------------------------");
			/* Print the description of the room by overriding the toString method */
			if (this.player.currentRoom().isDiscoverd())
				System.out.println(this.player.currentRoom().description());
			else
				System.out.println(this.player.currentRoom().toString());

			/* Finding out which actions the player can execute in the current room */
			List<Action> possibleActions = new ArrayList<Action>();
			/* We check whether action is do-able in the current room */
			/* If it is we add it to the list of available actions */
			for (Action a: this.getPlayer().canDo())
				if (a.canBeDoneIn(this.player.currentRoom()))
					possibleActions.add(a);
			System.out.println("------------------------------------------------\n");
			/* We let the player select an action to perform */
			Action a = ListChoser.chose(Translator.translate("AdventureGameAsk"),possibleActions);
			if (a==null)
				System.out.println("\t> "+Translator.translate("AdventureGameAborded"));
			else {
				/* We perform the action */
				a.doneBy(this.getPlayer());
			}
		}

		if (this.player.isAlive())
			System.out.println(Translator.translate("FINISH")+" "+this.player.getscore()+"\n");
	}
}
