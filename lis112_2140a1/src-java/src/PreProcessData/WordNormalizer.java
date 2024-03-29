package PreProcessData;

import Classes.*;

/**
 * This is for INFSCI 2140 in 2018
 * 
 */
public class WordNormalizer {
	// Essential private methods or variables can be added.

	// YOU MUST IMPLEMENT THIS METHOD.
	public char[] lowercase(char[] chars) {
		// Transform the word uppercase characters into lowercase.
		String str = String.valueOf(chars);
		str = str.toLowerCase();
		chars = str.toCharArray();
		return chars;
	}

	// YOU MUST IMPLEMENT THIS METHOD.
	public String stem(char[] chars) {
		// Return the stemmed word with Stemmer in Classes package.
		Stemmer s = new Stemmer();
		s.add(chars,chars.length);
		s.stem();
		String str = String.valueOf(s);
		return str;
	}

}
