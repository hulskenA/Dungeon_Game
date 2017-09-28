package fil.coo.adventure.entities.items.util;

public class GoldStockExchage extends GoldChest {
	protected int gold = 20;
	
	public String name() {
		return "GoldStockExchange";
	}

	@Override
	public String description() {
		return "Gold stock exchange\n\t[une petite bourse en cuire contenant des pièces d'or]";
	}

}
