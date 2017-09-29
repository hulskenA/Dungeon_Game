package fil.coo.adventure;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.*;
import fil.coo.adventure.util.ListChoser;
import fil.coo.adventure.util.langages.Translator;

public class AdventureGame {
	public static final Translator TRANSLATOR = new Translator();

	private Player player;

	public AdventureGame(Room startingRoom,Player player) {
		this.player = player;
		this.player.moveTo(startingRoom);
	}

	public Player getPlayer() {
		return this.player;
	}

	public void play() {
		System.out.println(AdventureGame.TRANSLATOR.translate("Welcome"));

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
			Action a = ListChoser.chose(AdventureGame.TRANSLATOR.translate("AdventureGameAsk"),possibleActions);
			if (a==null)
				System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("AdventureGameAborded"));
			else {
				/* We perform the action */
				a.doneByIn(this.getPlayer(), this.player.currentRoom());
			}
		}

		TRANSLATOR.close();
	}

	private boolean isFinished() {
		return (!this.getPlayer().isAlive()) || (this.player.currentRoom().isExit());
	}

	// A finished game function that handles the end.
}
