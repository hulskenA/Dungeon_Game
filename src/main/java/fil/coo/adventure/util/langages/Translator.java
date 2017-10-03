package fil.coo.adventure.util.langages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class that reads a properties file and allows us to be able to
 * translate strings into different languages easily.
 * Usage:
 * First, call the open static method to open the correct properties file.
 * Then, call translate with the correct property name in parameter to get
 * your string in the correct language
 * Lastly, call close to close the property file.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Translator {
	private static final Properties PROP = new Properties();
	private static InputStream input;

	/**
	 * Opens the correct properties file, using the Lang parameter. This must be
	 * imperatively executed before any calls to translate!
	 * @param lang The chosen language from the game
	 */
	public static void open(Langages lang) {
		input = null;

		try {

			InputStream input = new FileInputStream(lang.toString()+".properties");

			// load a properties file
			PROP.load(input);

			System.out.println(translate("YourLANGchoice"));

		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Returns the string in the appropriate language defined during the call to 
	 * the open static method of Translator.
	 * @param str The property name that will be extracted from the properties file
	 * @return T the string corresponding to that property name
	 */
	public static String translate(String str) {
		return PROP.getProperty(str);
	}

	/**
	 * Closes the open properties text file.
	 */
	public static void close() {
		if(input!=null){
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
