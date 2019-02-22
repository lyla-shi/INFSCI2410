package Indexing;

import Indexing.PreProcessedCorpusReader;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import Classes.Path;

public class MyIndexWriter {
	// I suggest you to write very efficient code here, otherwise, your memory cannot hold our corpus...
	private FileWriter outdic = null;
	private FileWriter outpost = null;
	//posting store structure: Map<term, linkedlist>, each linkedlist node-> docno: term frequency in each document
	private Map<String,LinkedList<String>> posting = new HashMap<>();  
	//term dictionary store structure: Map<term, collection frequency, line(pointer)>
	private Map<String, int[]> dictionary=new HashMap<>();
	private FileWriter docid = null;
	private int id = 1;
	
	
	public MyIndexWriter(String type) throws IOException {
		// This constructor should initiate the FileWriter to output your index files
		// remember to close files if you finish writing the index
		//this.datatype = type;
		if (type == "trectext") {
			outdic = new FileWriter(Path.IndexTextDir + "dicTermIndex.txt");
			outpost = new FileWriter(Path.IndexTextDir + "postingIndex.txt");
			docid = new FileWriter(Path.IndexTextDir + "docid.txt");
		}
		if (type == "trecweb") {
			outdic = new FileWriter(Path.IndexWebDir + "dicTermIndex.txt");
			outpost = new FileWriter(Path.IndexWebDir + "postingIndex.txt");
			docid = new FileWriter(Path.IndexWebDir + "docid.txt");
		}
		 
	}
	
	public void IndexADocument(String docno, String content) throws IOException {
		// you are strongly suggested to build the index by installments
		// you need to assign the new non-negative integer docId to each document, which will be used in MyIndexReader
		//String list = null;
		LinkedList<String> list = null;
		String[] words = null;
		
		//create document to store string docno and int docid
		docid.append(docno + " " + id + "\n");
		id ++;

		words = content.split(" ");
		for (String string : words) {
			//if the term is not in the dictionary, create new entry both in dicterm and posting
            if (!dictionary.containsKey(string)) {  
            	
                list = new LinkedList<String>();
                list.add(docno + ":1");
                posting.put(string, list); 
                
                int[] dic = new int[2];
                dic[0] = 1;
                dic[1] = 0;
                dictionary.put(string, dic);
                //line++;
                
            }else {
            	//if term is in the dictionary, increase collection frequency
            	int[] cf = dictionary.get(string);
            	cf[0] = cf[0] + 1;
            	dictionary.put(string, cf);
                list = posting.get(string);
                
                //if document not in posting
                if (!list.getFirst().startsWith(docno)) {
                	list.addFirst(docno + ":1");
                	posting.put(string, list);
                }
                
                //if document in posting
                else {
                	
                	String df = list.getFirst();
                	String[] s = df.split(":");
                	int newdf = Integer.parseInt(s[1]) + 1;
                	list.set(0, docno + ":" + newdf) ;
                	posting.put(string, list);
                } 
            }
        } 
		
		  
		
			
	}
	
	public void Close() throws IOException {
		docid.close();
		//if (datatype == "trecweb") {
		//write the dicterm and posting in the file
			int line = 1; 
			for (Map.Entry<String, int[]> entry : dictionary.entrySet()) {
			int[] val = entry.getValue();
			
			
			outdic.append(entry.getKey() + " " + val[0] + " " + line + "\n");
			
			LinkedList<String> post = posting.get(entry.getKey());
			
			for (Iterator<String> iterator = post.iterator(); iterator.hasNext();) {
				outpost.append(iterator.next()+" ");
			}
			outpost.append("\n");
			line++;
			}
	        outdic.close();
	        outpost.close();
	        
	        System.out.println("successful");
		//}
		
	}
	
	
	//main method for debug
	public static void main(String[] args) throws IOException {
		int count = 0;
		MyIndexWriter output=new MyIndexWriter("trecweb");
		PreProcessedCorpusReader pr = new PreProcessedCorpusReader("trecweb");
		Map<String, String> doc = null;
		while ((doc = pr.NextDocument()) != null) {
		String docno = doc.get("DOCNO"); 
		String content = doc.get("CONTENT");		
		output.IndexADocument(docno, content);
		count++;
		if(count%30000==0)
		System.out.println("finish "+count+" docs");}
		
		output.Close();
	}
	
}
