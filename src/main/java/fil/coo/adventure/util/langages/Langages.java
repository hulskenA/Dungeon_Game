package fil.coo.adventure.util.langages;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines available languages for the player to chose from.
 * In this case, the player can play in french or english
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public enum Langages {
	Fr("français"),
	En("english");

	private String name;

	private Langages(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public static List<Langages> allLangages() {
		List<Langages> res = new ArrayList<Langages>();
		for (Langages l : Langages.values())
			res.add(l);
		return res;
	}
}
