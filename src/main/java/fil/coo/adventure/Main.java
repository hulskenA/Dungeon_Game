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
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.GoldPouch;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.items.util.OneArmedBandit;
import fil.coo.adventure.entities.items.util.SleepedBadChest;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.util.Balrog;
import fil.coo.adventure.entities.monsters.util.Dragon;
import fil.coo.adventure.entities.monsters.util.KingGoblin;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.entities.monsters.util.Looter;
import fil.coo.adventure.entities.monsters.util.Orc;
import fil.coo.adventure.entities.monsters.util.Slime;
import fil.coo.adventure.entities.monsters.util.ZombiesHord;

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
		exit.addCharacter(new Dragon(100,25));
		Direction dN = Direction.N;

		room.addNeighbour(Direction.W, exit);
		for (int i = 0; i < 3; i++)
			room.addCharacter(new Slime(5,0));
		room.addItem(new GoldChest());
		room.addItem(new GoldPouch());
		room.addNeighbour(dN, tmp1);
		
		tmp1.addNeighbour(dN.opposite(), room);
		tmp1.addCharacter(new ZombiesHord(40,5));
		tmp1.addItem(new LifePotion());
		tmp1.addNeighbour(dN, tmp2);
		
		tmp2.addNeighbour(dN.opposite(), tmp1);
		tmp2.addItem(new GoldChest());
		tmp2.addItem(new SleepedBadChest());
		tmp2.addItem(new LifePotion());
		tmp2.addCharacter(new ZombiesHord(40,5));
		tmp1 = new Room();
		tmp2.addNeighbour(dN, tmp1);
		
		tmp1.addNeighbour(dN.opposite(), tmp2);
		tmp1.addItem(new StrengthPotion());
		tmp1.addItem(new OneArmedBandit());
		tmp1.addCharacter(new Looter(20,20));
		tmp2 = new Room();
		tmp1.addNeighbour(dN, tmp2);
		
		tmp2.addNeighbour(dN.opposite(), tmp1);
		for (int i = 0; i<2; i++)
			tmp2.addItem(new LifePotion());
		tmp1.addCharacter(new KingGoblin(30,5));
		tmp2 = new Room();
		tmp1.addNeighbour(dN, tmp2);
		
		tmp2.addNeighbour(dN.opposite(), tmp1);
		for (int i = 0; i<4; i++)
			tmp2.addItem(new StrengthPotion());
		for (int i = 0; i<2; i++)
			tmp2.addItem(new LifePotion());
		tmp2.addCharacter(new Kraken(60,15));
		tmp2.addCharacter(new Dragon(100,25));
		tmp2.addCharacter(new Balrog(60,25));
		tmp2.addCharacter(new Orc(40,10));
		tmp2.addDead(new Orc(40,10));
		
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