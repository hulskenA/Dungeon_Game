package fil.coo.adventure.util.langages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fil.coo.adventure.util.ListChoser;


public class Translator {
	private final Properties prop = new Properties();
	private final Langages LANG = ListChoser.chose("Choose your Langage", Langages.allLangages(), true);
	
	private InputStream input;
	
	public Translator() {
		InputStream input = null;

		try {

			input = new FileInputStream(LANG.toString()+".properties");

			// load a properties file
			prop.load(input);
			
			System.out.println(this.translate("YourLANGchoice"));

		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String translate(String str) {
		return prop.getProperty(str);
	}
	
	public void close() {
		if(this.input!=null){
			try {
				this.input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}