package fil.coo.adventure.util.langages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Translator {
	private final Properties PROP = new Properties();
	private InputStream input;

	public Translator(Langages lang) {
		InputStream input = null;

		try {

			input = new FileInputStream(lang.toString()+".properties");

			// load a properties file
			PROP.load(input);

			System.out.println(this.translate("YourLANGchoice"));

		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

	public String translate(String str) {
		return PROP.getProperty(str);
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
