package fil.coo.adventure.util;

import java.util.*;

import fil.coo.adventure.AdventureGame;

public class ScannerInt {
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * read an integer from 0 (included) to n (excluded) from standard input
	 * input is repeated as long as it is not correct
	 * 
	 * @param n the upper (excluded) bound for input
	 * @return the valid read input 
	 */
	public static int readInt(int n) {
		return readInt(n, false);
	}
	
	public static int readInt(int n, boolean isForLangages) {
		int input = -1;
		while (input < 0 || input >= n) {
			String yourChoice;
			if (isForLangages)
				yourChoice=new String();
			else
				yourChoice=AdventureGame.TRANSLATOR.translate("YourChoice");
			System.out.print("\n"+yourChoice+" (0-" + (n - 1) + ") ? ");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		} 
		return input;
	}

}