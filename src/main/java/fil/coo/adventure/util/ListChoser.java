package fil.coo.adventure.util;

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
		int cpt = 1;
		System.out.println("Do nothing (0)");
		for (T item : items) { 	 
			System.out.println(item+" ("+cpt+")"); 	    cpt++; 	} 
		System.out.println(msg); 
		int choice = ScannerInt.readInt(cpt);    
		if (choice == 0) 	    
			return null; 	
		else 	 
			return items.get(choice-1);
	}
}
