package fil.coo.adventure.util;

import java.util.List;

public class PrintLookable {
	public static void printList(String type, List<? extends Lookable> items) {
		System.out.println("-------------------------\n"+type+"\n-------------------------");
		for (Lookable item : items)
			System.out.println("> "+item.description());
	}
}
