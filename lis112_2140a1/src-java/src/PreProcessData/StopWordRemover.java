package PreProcessData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import Classes.*;

public class StopWordRemover {
	// Essential private methods or variables can be added.
	private BufferedReader buff = null;
	private HashSet<String> stopList = new HashSet<String>();
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public StopWordRemover( ) throws IOException {
		// Load and store the stop words from the fileinputstream with appropriate data structure.
		// NT: address of stopword.txt is Path.StopwordDir
		String str="0";
		File filename = new File(Path.StopwordDir);
		this.buff = new BufferedReader(new FileReader(filename));
		while (str != null) {
			str = buff.readLine();
			if (str == null) {break;}
			else {this.stopList.add(str);}
		}
		
		this.buff.close();		
	}

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public boolean isStopword( char[] word ) {
		// Return true if the input word is a stopword, or false if not.
		String singleWord = String.valueOf(word);
		return (stopList.contains(singleWord));
	}
}
