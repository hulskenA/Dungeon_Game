package fil.coo.adventure.util;

import java.util.*;

import fil.coo.adventure.util.langages.Translator;

public class ScannerInt {
	private static final Scanner SCANNER = new Scanner(System.in);

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
				yourChoice=Translator.translate("YourChoice");
			System.out.print("\n"+yourChoice+" (0-" + (n - 1) + ") ? ");
			try {
				input = SCANNER.nextInt();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				SCANNER.skip(".*");
			}
		}
		return input;
	}

}
