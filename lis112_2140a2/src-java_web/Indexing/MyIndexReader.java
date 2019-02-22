package Indexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Classes.Path;


public class MyIndexReader {
	//you are suggested to write very efficient code here, otherwise, your memory cannot hold our corpus...
	private BufferedReader readdic = null;
	private BufferedReader readid = null;
	private FileReader fr1 = null;
	private Map<String,Integer> getid = new HashMap<String,Integer>();
	private Map<String,int[]> getdic = new HashMap<String,int[]>();
	private String[] postdoc = null;
	
	
	public MyIndexReader( String type ) throws IOException {
		//read the index files you generated in task 1
		//remember to close them when you finish using them
		//use appropriate structure to store your index
		//this.datatype = type;
		if (type == "trectext") {
			FileReader fr = new FileReader(Path.IndexTextDir + "dicTermIndex.txt");
			readdic = new BufferedReader(fr);
			fr1 = new FileReader(Path.IndexTextDir + "postingIndex.txt");
			FileReader fr3 = new FileReader(Path.IndexTextDir + "dicid.txt");
			readid = new BufferedReader(fr3);
			
		}
		if (type == "trecweb") {
			FileReader fr = new FileReader(Path.IndexWebDir + "dicTermIndex.txt");
			readdic = new BufferedReader(fr);

			FileReader fr3 = new FileReader(Path.IndexWebDir + "docid.txt");
			readid = new BufferedReader(fr3);
		}
		
		//get docid file and store it in a map
		String line = readid.readLine();
		while (line != null) {
			String[] noid = line.split(" ");
			getid.put(noid[0], Integer.parseInt(noid[1]));
			line = readid.readLine();
		}
		readid.close();
		
		
		//get term dictionary and store it in a map
		String dic = readdic.readLine();
		while (dic != null) {
			String[] nocf = dic.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic.put(nocf[0], cfli);
			dic= readdic.readLine();
		}
	
	}
	
	//get the non-negative integer dociId for the requested docNo
	//If the requested docno does not exist in the index, return -1
	public int GetDocid( String docno ) throws IOException {
		return getid.get(docno);
	}

	// Retrieve the docno for the integer docid
	public String GetDocno( int docid ) {
		String no = null;
		for (Map.Entry<String, Integer> entry : getid.entrySet()) {
			if(entry.getValue().equals(docid)) {
				no =  entry.getKey();
				break;
			}
		}
		return no;
		
	}
	
	/**
	 * Get the posting list for the requested token.
	 * 
	 * The posting list records the documents' docids the token appears and corresponding frequencies of the term, such as:
	 *  
	 *  [docid]		[freq]
	 *  1			3
	 *  5			7
	 *  9			1
	 *  13			9
	 * 
	 * ...
	 * 
	 * In the returned 2-dimension array, the first dimension is for each document, and the second dimension records the docid and frequency.
	 * 
	 * For example:
	 * array[0][0] records the docid of the first document the token appears.
	 * array[0][1] records the frequency of the token in the documents with docid = array[0][0]
	 * ...
	 * 
	 * NOTE that the returned posting list array should be ranked by docid from the smallest to the largest. 
	 * 
	 * @param token
	 * @return
	 */
	public int[][] GetPostingList( String token ) throws IOException {
		int[][] getpost = new int[postdoc.length][2];
		for(int i=0; i<postdoc.length; i++) {
			String[] notf = postdoc[i].split(":");
			int id = GetDocid(notf[0]);
			getpost[i][0] = id;
			getpost[i][1] = Integer.parseInt(notf[1]);
		}
		return getpost;
	}

	// Return the number of documents that contains the token.
	public int GetDocFreq( String token ) throws IOException {
		BufferedReader readpost = new BufferedReader(fr1);
		int[] tokendf = getdic.get(token);
		int pointer = tokendf[1];
		for (int i = 1; i <pointer ; i++) {readpost.readLine();}
		String posting = readpost.readLine();
		//posting = posting.substring(1,posting.length()-1);
		postdoc = posting.split(" ");
		readpost.close();
		return postdoc.length;
		
	}
	
	// Return the total number of times the token appears in the collection.
	public long GetCollectionFreq( String token ) throws IOException {
		int[] tokencf = getdic.get(token);
		return tokencf[0];
	}
	
	public void Close() throws IOException {
		readid.close();
		readdic.close();
	}
	
}