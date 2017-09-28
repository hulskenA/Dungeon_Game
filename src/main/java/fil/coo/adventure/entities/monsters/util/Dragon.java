package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Dragon extends Monster {
	public Dragon() {
		super(100, 25);
	}
	
	public String name() {
		return "Dragon";
	}	
	
	@Override
	public String description() {
		return this.name()+"\n\t[regardez dans le ciel !!!! (et oui il y a même un ciel dans ce foutu donjon...) c'est un oiseau? c'est un avion? non c'est un DRAGOOON !]";
	}
}
