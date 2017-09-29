package fil.coo.adventure.util.langages;

import java.util.ArrayList;
import java.util.List;


public enum Langages {
	Fr("french"),
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
