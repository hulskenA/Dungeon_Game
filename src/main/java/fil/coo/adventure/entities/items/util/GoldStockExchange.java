package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.AdventureGame;

public class GoldStockExchange extends GoldChest {
	
	public GoldStockExchange() {
		this.gold = 20;
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("GoldStockExchange");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("GoldStockExchange")+"\n\t["+AdventureGame.TRANSLATOR.translate("GoldStockExchangeDescription")+"]";
	}

}
