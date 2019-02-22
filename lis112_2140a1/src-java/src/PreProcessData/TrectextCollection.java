package PreProcessData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Classes.Path;

/**
 * This is for INFSCI 2140 in 2019
 *
 */
public class TrectextCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	
	private BufferedReader buff = null;
	private String line = null;
	private String textID = null;
	private String textContent = null;
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrectextCollection() throws IOException {
		// 1. Open the file in Path.DataTextDir.
		// 2. Make preparation for function nextDocument().
		// NT: you cannot load the whole corpus into memory!!
		File filename = new File(Path.DataTextDir);
		this.buff = new BufferedReader(new FileReader(filename));
		
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
		// 1. When called, this API processes one document from corpus, and returns its doc number and content.
		// 2. When no document left, return null, and close the file.
		Map<String, Object> trectext = new HashMap<String, Object>();
		textContent = null;
		line = buff.readLine();
		if ( line!= null) {
			 while(line.compareTo("<DOC>")!=0) {
				 line = buff.readLine();
			 }
			 
			 if (line.compareTo("<DOC>")==0) {
				 
				 //store the document ID
				 while(line.startsWith("<DOCNO>")==false) {
					line = buff.readLine(); 
				 }

				 textID = line.substring(8, line.length()-9);

				 //store document content
				 while(line.compareTo("<TEXT>") != 0) {
						line = buff.readLine(); 
				 }
				 
				 line = buff.readLine();
				 //System.out.println(line);
				 while(line.compareTo("</TEXT>") != 0) {
					 if (textContent == null) {
						 textContent = line;
					 }
					 else {
						 textContent = textContent + line;
					 }
					 
					 line = buff.readLine();
				 }
				 
				 while(line.compareTo("</DOC>") != 0) {
					 line = buff.readLine();
				 }
				 
				 //if content is null, put default content in the entry
				 //if content is not null, put the content in the entry
				 if(textContent!=null) {
				 //System.out.println(line);
				 char[] textContent1 = textContent.toCharArray();
				 Object content = textContent1;
				 trectext.put(textID, content);
				 }
				 
				 else {
					 char[] defult = {'0'};
					 Object defultContent = defult;
					 trectext.put(textID, defultContent);
					 }
				 				 
			 }
			 
			 return trectext;			 

		}
		
		//if there is no document then close the file and return null
		else {
			buff.close();
			return null;
		}
		
	}
	

}
