package PreProcessData;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is for INFSCI 2140 in 2019
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	// Essential private methods or variables can be added.
	private ArrayList<String> words = new ArrayList<String>();
	private int indexWord = 0;
	//private char[] singleWord;
	
	// YOU MUST IMPLEMENT THIS METHOD.
	public WordTokenizer( char[] texts ) {
		// Tokenize the input texts.
		int index = 0;
		int size = texts.length;

		String singleWord;

		while(index<size) {
			singleWord = null;
		
			while (texts[index] != ' ') {
				//delete all the punctuation
		        Pattern patPunc = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~£¡@#£¤¡­¡­&*£¨£©¡ª¡ª|{}¡¾¡¿¡®£»£º¡±¡°'¡££¬¡¢£¿]$");
		        String s = String.valueOf(texts[index]);
		        Matcher matcher = patPunc.matcher(s);
		        if(matcher.find()==true) {
		        	//System.out.println(index);
		        	index++;
		        	break;
		        }
		        
		        //tokenize the word
		        else {
		        	if (singleWord == null) {
						singleWord = Character.toString(texts[index]);
						index ++;
					}
					else {
						singleWord = singleWord + Character.toString(texts[index]);
						index ++;
					}
		        }
				
				if (index>=size) {break;}
			}

			if(singleWord != null) {
				words.add(singleWord);
			}

			if (index>=size) {break;}
			else {
				while (texts[index] == ' ') {
					index++;
					if(index>=size) {break;}
				}
			}
			
		}
	}
	
	// YOU MUST IMPLEMENT THIS METHOD.
	public char[] nextWord() {
		// Return the next word in the document.
		// Return null, if it is the end of the document.
		if(indexWord<words.size()) {
			char[] next = words.get(indexWord).toCharArray();
			indexWord ++;
			return next;
		}		
		else {return null;}
	} 
	
}
