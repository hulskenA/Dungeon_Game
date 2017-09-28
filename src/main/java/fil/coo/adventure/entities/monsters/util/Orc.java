package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Orc extends Monster {
	public Orc() {
		super(40, 10);
	}
	
	public String name() {
		return "Orc";
	}

	@Override
	public String description() {
		return this.name()+"\n\t[Un orc quoi tu sais bien ce que c'est, je vais pas être obligé de te décrire absolument tout ce qui se trouve devant toi, je ne suis pas ton larbin rêve pas trop mon gros...]";
	}
}
