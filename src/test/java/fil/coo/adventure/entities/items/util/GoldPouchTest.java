package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;

public class GoldPouchTest extends GoldChestTest {
	
	@Override
	protected Item createGoldChest() {
		return new GoldPouch();
	}
	
	@Override
	protected int goldChestValue() {
		return 20;
	}
}
