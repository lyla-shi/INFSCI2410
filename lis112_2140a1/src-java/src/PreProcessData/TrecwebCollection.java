package PreProcessData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Classes.Path;

/**
 * This is for INFSCI 2140 in 2018
 *
 */
public class TrecwebCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	
	private BufferedReader buff = null;
	private String line = null;
	private String webID = null;
	private String webContent = null;
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrecwebCollection() throws IOException {
		// 1. Open the file in Path.DataWebDir.
		// 2. Make preparation for function nextDocument().
		// NT: you cannot load the whole corpus into memory!!
		File filename = new File(Path.DataWebDir);
		this.buff = new BufferedReader(new FileReader(filename));
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
		// 1. When called, this API processes one document from corpus, and returns its doc number and content.
		// 2. When no document left, return null, and close the file.
		// 3. the HTML tags should be removed in document content.
		Map<String, Object> trecweb = new HashMap<String, Object>();
		webContent = null;
		line = buff.readLine();
		if (line!=null) {
			while(line.compareTo("<DOC>")!=0) {
				line = buff.readLine();
			}
			
			//store web document ID 
			if (line.compareTo("<DOC>") == 0) {
				while (line.startsWith("<DOCNO>")==false) {
					line = buff.readLine();
				}

				webID = line.substring(7, line.length()-8);
				
				while(line.compareTo("</DOCHDR>")!=0) {
					line = buff.readLine();
				}
				
				
				//get web document content
				line = buff.readLine();
				while(line.compareTo("</DOC>")!=0) {
					if(webContent == null) {
						webContent = line;
					}
					else {
						webContent = webContent + line ;						
					}
					line = buff.readLine();
				}
				
				String htmlStr = webContent.toString();
;				
				//remove HTML tags
				String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //<script> tags
		        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //<style> tags
		        String regEx_html="<[^>]+>"; //<html> tags
		         
		        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
		        Matcher m_script=p_script.matcher(htmlStr); 
		        htmlStr=m_script.replaceAll(""); //delete all <script> tags 
		         
		        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
		        Matcher m_style=p_style.matcher(htmlStr); 
		        htmlStr=m_style.replaceAll(""); //delete all <style> tags 
		         
		        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
		        Matcher m_html=p_html.matcher(htmlStr); 
		        htmlStr=m_html.replaceAll(""); //delete all <html> tags  
	 
		        webContent = htmlStr.trim(); //return pure text 
				char[] webContent1 = webContent.toCharArray();
				Object content = webContent1;
				trecweb.put(webID, content);
			}
			
			return trecweb;
		}
		
		else {
			//if there is no document then close the file and return null
			buff.close();
			return null;
		}
	}	
	
}
