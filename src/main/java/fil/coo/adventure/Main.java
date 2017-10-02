package fil.coo.adventure;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;
import fil.coo.adventure.util.langages.Langages;
import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.actions.util.*;

public class Main {

	public static void main(String[] args) {
		Player thePlayer = new Player(1000,100);
		thePlayer.addCapability(new AttackAction());
		thePlayer.addCapability(new LookAction());
		thePlayer.addCapability(new MoveAction());
		thePlayer.addCapability(new UseAction());
		thePlayer.addCapability(new LootAction());
		thePlayer.addCapability(new SuicideAction());
		Langages lang = ListChoser.chose("Choose your Langage", Langages.allLangages(), true);
		AdventureGame.translator = new Translator(lang);
		AdventureGame aG = new AdventureGame(Room.generateMap(), thePlayer);
		aG.play();
	}

}
