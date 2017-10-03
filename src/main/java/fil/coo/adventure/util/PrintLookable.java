package fil.coo.adventure.util;

import java.util.List;

/**
 * Used to print a list of Lookable objects. This class exists because
 * the DRY principle wouldn't be respected in the code of Look Action if
 * it didn't.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class PrintLookable {
	/**
	 * Prints a list of lookable objects to the screen. Objects will be printed
	 * using the lookable interface description method!
	 * @param type A string describing the types of objects that we're printing (ex: "Monsters");
	 * @param items The list of objects that we will be actually printing.
	 */
	public static void printList(String type, List<? extends Lookable> items) {
		if (!items.isEmpty()) {
			System.out.println("\n-------------------------\n"+type+"\n-------------------------");
			for (Lookable item : items)
				System.out.println("> "+item.description());
		}
	}
}
