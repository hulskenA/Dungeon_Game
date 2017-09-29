package fil.coo.adventure.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.util.ScannerInt;

import java.util.*;

public class ListChoser {

	/**
	 * Static generic method that lists a number of options from a list given in parameter
	 * that also display a message to the user at the end of the enumeration.
	 * @param msg The message that will be display after the enumeration
	 * @param items The items from which the user will have to chose
	 * @return The chosen option
	 */
	public static<T> T chose(String msg, List<T> items) {
		return chose(msg, items, false);
	}

	public static<T> T chose(String msg, List<T> items, boolean isForLangages) {
		System.out.println(msg);
		int cpt = 0;
		if (!isForLangages) {
			System.out.println("\t[0] "+AdventureGame.TRANSLATOR.translate("donothing"));
			cpt = 1;
		}
		for (T item : items) {
			System.out.println("\t["+cpt+"] "+item);
			cpt++;
		}
		int choice = isForLangages?ScannerInt.readInt(cpt, isForLangages)+1:ScannerInt.readInt(cpt, isForLangages);
		if (choice == 0 && !isForLangages)
			return null;
		else
			return items.get(choice-1);
	}
}
