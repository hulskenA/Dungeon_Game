package fil.coo.adventure;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.*;
import fil.coo.adventure.util.ListChoser;

public class AdventureGame {
	private Player player;
	
	public AdventureGame(Room startingRoom,Player player) {
		this.player = player;
		this.player.moveTo(startingRoom);
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void play() {
		while(!this.isFinished()) {
			System.out.println("------------------------------");
			/* Print the description of the room by overriding the toString method */
			System.out.println(this.player.currentRoom());
			
			/* Finding out which actions the player can execute in the current room */
			List<Action> possibleActions = new ArrayList<Action>();
			/* We check whether action is do-able in the current room */
			/* If it is we add it to the list of available actions */
			for (Action a: this.getPlayer().canDo())
				if (a.canBeDoneIn(this.player.currentRoom()))
					possibleActions.add(a);
			/* We let the player select an action to perform */
			Action a = ListChoser.chose("What will you do?",possibleActions);
			/* We perform the action */
			a.doneByIn(this.getPlayer(), this.player.currentRoom());
		}
	}

	private boolean isFinished() {
		return (!this.getPlayer().isAlive()) || (this.player.currentRoom().isExit());
	}
	
	// A finished game function that handles the end.
}
