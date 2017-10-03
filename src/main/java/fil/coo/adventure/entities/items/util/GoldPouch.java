package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the gold pouch item, which is essentially
 * a small GoldChest, containing only 20 gold.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class GoldPouch extends GoldChest {
	
	public GoldPouch() {
		this.gold = 20;
	}
	
	public String name() {
		return Translator.translate("GoldStockExchange");
	}

	@Override
	public String description() {
		return Translator.translate("GoldStockExchange")+"\n\t["+Translator.translate("GoldStockExchangeDescription")+"]";
	}

}
