package helpers;

import java.util.Locale;

/**
 * This class contains hardcoded references to the available locales. This is something that a well
 * designed program should be able to detect based on the presence of language files or a master
 * file listing the languages, or from a database if one is available. And by all accounts this
 * should be a well designed program. This, however, has proven itself to be difficult, as the humble
 * programmer of this project was restricted to, of all things, Java, as the project's language.
 * The programmer in question has, over the years, worked with many a language and web framework,
 * and in every single one of them it has been trivial to detect the existence of a file within the
 * project directory. Every single one, that is, except Java.
 * 
 * The programmers who made Java's web framework seem to have decided to cripple it by taking away
 * direct access to files within the project. Direct, in this case, meaning absolutely any way to
 * access the files in any manner whatsoever. Not even the code in the project is available in file
 * form. This seems to extend as far as to actively protect the files from being read, no matter
 * what method - though the language does contain methods to find the path to where the classes and
 * other files are stored (which, incidentally, is not where they were actually put by the
 * programmer), attempting to read anything from this path has resulted in null pointer exceptions.
 * This project's programmer attempted to read the list of resource bundle files in the project in
 * an attempt to inject some semblance of dynamism, but was thwarted by said exceptions.
 * 
 * Getting a list of files in the project is trivial in literally every other serious framework and
 * language this programmer has touched. In Java, however, hours of research has not revealed any
 * way to do it. Again, this is a task that is absolutely trivial - and that word is not used
 * figuratively here - to accomplish in any sane system. Which, apparently, Java is not.
 * 
 * Seriously, Java?
 * 
 * @author Pål V. Gjerde
 *
 */
public class Locales {
	public static final Locale[] locales = {
		new Locale("en", "US"),
		new Locale("no", "NO"),
		new Locale("es", "ES")
	};
}
