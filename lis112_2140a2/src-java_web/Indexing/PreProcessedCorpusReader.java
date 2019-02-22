package Indexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Classes.Path;

public class PreProcessedCorpusReader {
	private BufferedReader buff = null;
	//private int i = 1;
	
	
	public PreProcessedCorpusReader(String type) throws IOException {
		// This constructor opens the pre-processed corpus file, Path.ResultHM1 + type
		// You can use your own version, or download from http://crystal.exp.sis.pitt.edu:8080/iris/resource.jsp
		// Close the file when you do not use it any more
		FileReader fr = new FileReader(Path.ResultHM1 + type);
		this.buff = new BufferedReader(fr);
	}
	

	public Map<String, String> NextDocument() throws IOException {
		// read a line for docNo, put into the map with <"DOCNO", docNo>
		// read another line for the content , put into the map with <"CONTENT", content>
		Map<String,String> map = new HashMap<String,String>();
		String s = buff.readLine();
		if (s==null) {
			buff.close();
			return null;
		}
		else {
			map.put("DOCNO", s);
			String s2 = buff.readLine();
			map.put("CONTENT", s2);
			return map;
		}
	}
	
	//main method used for debug
	public static void main (String[] args) throws IOException {
		PreProcessedCorpusReader pr = new PreProcessedCorpusReader("trecweb");
		System.out.println(pr.NextDocument());
		System.out.println(pr.NextDocument());
		System.out.println(pr.NextDocument());
	}

}
