package fil.coo.adventure;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.places.Exit;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;
import fil.coo.adventure.util.langages.Langages;
import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.actions.util.*;
import fil.coo.adventure.entities.items.util.*;
import fil.coo.adventure.entities.monsters.util.*;

/**
 * The main class of our game, the map for the game is created here.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Main {

	/**
	 * The creation of the dungeon map.
	 * @return the room in which the player should start
	 */
	private static Room generateMap() {
		Room room = new Room();
		room.addDescription(Translator.translate("RoomDescription1"));
		Room tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription2"));
		Room tmp2 = new Room();
		tmp2.addDescription(Translator.translate("RoomDescription3"));
		Exit exit = new Exit();
		exit.addDescription(Translator.translate("ExitToString"));
		exit.addCharacter(new Dragon(100, 25));

		room.addNeighbour(Direction.W, tmp1);
		tmp1.addCharacter(new Slime(5, 0));

		tmp1.addNeighbour(Direction.S, tmp2);
		tmp2.addCharacter(new Slime(5, 0));
		tmp2.addCharacter(new Goblin(15, 5));

		Room tmp3 = new Room();
		tmp3.addDescription(Translator.translate("RoomDescription4"));
		tmp2.addNeighbour(Direction.W, tmp3);
		for (int i = 0; i<3; i++)
			tmp3.addCharacter(new Slime(5, 0));

		tmp2 = new Room();
		tmp2.addDescription(Translator.translate("RoomDescription5"));
		tmp3.addNeighbour(Direction.W, tmp2);
		tmp2.addItem(new LifePotion());
		tmp2.addCharacter(new Goblin(15, 5));
		tmp2.addCharacter(new Goblin(15, 5));

		tmp3 = new Room();
		tmp3.addDescription(Translator.translate("RoomDescription6"));
		tmp2.addNeighbour(Direction.N, tmp3);
		tmp3.addItem(new OneArmedBandit());
		tmp3.addCharacter(new KingGoblin(30, 5));

		tmp2 = new Room();
		tmp2.addDescription(Translator.translate("RoomDescription7"));
		tmp1.addNeighbour(Direction.N, tmp2);
		tmp2.addItem(new GoldPouch());

		tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription8"));
		tmp2.addNeighbour(Direction.N, tmp1);
		tmp1.addCharacter(new Looter(20, 20));
		tmp1.addItem(new OneArmedBandit());

		tmp2 = new Room();
		tmp2.addDescription(Translator.translate("RoomDescription9"));
		tmp1.addNeighbour(Direction.W, tmp2);
		tmp2.addCharacter(new ZombiesHord(35, 5));

		tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription1"));
		tmp2.addNeighbour(Direction.W, tmp1);
		tmp1.addItem(new StrengthPotion());
		tmp1.addCharacter(new Balrog(80, 25));

		tmp1.addNeighbour(Direction.N, exit);

		Room tmp4 = new Room();
		tmp4.addDescription(Translator.translate("RoomDescription2"));
		tmp2.addNeighbour(Direction.S, tmp4);
		tmp4.addCharacter(new Looter(20, 20));
		tmp4.addItem(new LifePotion());

		tmp2 = new Room();
		tmp2.addDescription(Translator.translate("RoomDescription3"));
		tmp4.addNeighbour(Direction.W, tmp2);
		tmp1. addNeighbour(Direction.S, tmp2);
		tmp2.addCharacter(new Orc(40, 10));
		tmp2.addCharacter(new Looter(20, 20));
		tmp2.addDead(new Orc(0, 10));

		tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription4"));
		tmp2.addNeighbour(Direction.W, tmp1);
		tmp1.addItem(new GoldChest());
		tmp1.addItem(new GoldChest());
		tmp1.addItem(new SleepedBadChest());
		tmp1.addCharacter(new KingGoblin(30, 5));

		tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription5"));
		tmp1.addItem(new StrengthPotion());
		tmp1.addItem(new LifePotion());
		tmp2.addNeighbour(Direction.S, tmp1);
		tmp3.addNeighbour(Direction.W, tmp1);

		tmp1 = new Room();
		tmp1.addDescription(Translator.translate("RoomDescription6"));
		tmp1.addItem(new StrengthPotion());
		tmp1.addCharacter(new Orc(40, 10));
		tmp4.addNeighbour(Direction.E, tmp1);
		tmp3.addNeighbour(Direction.E, tmp1);

		return room;
	}

	public static void main(String[] args) {
		Translator.open(ListChoser.chose("Language:",Langages.allLangages(),true));

		Player thePlayer = new Player(100,10);
		thePlayer.addCapability(new AttackAction());
		thePlayer.addCapability(new LookAction());
		thePlayer.addCapability(new MoveAction());
		thePlayer.addCapability(new UseAction());
		thePlayer.addCapability(new LootAction());
		thePlayer.addCapability(new SuicideAction());
		AdventureGame aG = new AdventureGame(Main.generateMap(),thePlayer);
		aG.play();

		Translator.close();
	}

}
