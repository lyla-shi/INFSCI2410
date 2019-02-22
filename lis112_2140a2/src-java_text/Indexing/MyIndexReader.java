package Indexing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Classes.Path;


public class MyIndexReader {
	//you are suggested to write very efficient code here, otherwise, your memory cannot hold our corpus...
	private BufferedReader readdic1 = null;
	private BufferedReader readdic2 = null;
	private BufferedReader readdic3 = null;
	private BufferedReader readdic4 = null;
	private BufferedReader readdic5 = null;
	private BufferedReader readdic6 = null;
	private BufferedReader readdic7 = null;
	private BufferedReader readdic8 = null;
	private BufferedReader readdic9 = null;
	private BufferedReader readdic10 = null;
	private BufferedReader readdic11 = null;
	private BufferedReader readid = null;
	private FileReader fr1 = null;
	private FileReader fr2 = null;
	private FileReader fr3 = null;
	private FileReader fr4 = null;
	private FileReader fr5 = null;
	private FileReader fr6 = null;
	private FileReader fr7 = null;
	private FileReader fr8 = null;
	private FileReader fr9 = null;
	private FileReader fr10 = null;
	private FileReader fr11 = null;
	private Map<String,Integer> getid = new HashMap<String,Integer>();
	private Map<String,int[]> getdic1 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic2 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic3 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic4 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic5 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic6 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic7 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic8 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic9 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic10 = new HashMap<String,int[]>();
	private Map<String,int[]> getdic11 = new HashMap<String,int[]>();
	private String[] postdoc = null;
	
	
	public MyIndexReader( String type ) throws IOException {
		//read the index files you generated in task 1
		//remember to close them when you finish using them
		//use appropriate structure to store your index
		//read the index seperately
		if (type == "trectext") {
			FileReader frr1 = new FileReader(Path.IndexTextDir + "dic1.txt");
			FileReader frr2 = new FileReader(Path.IndexTextDir + "dic2.txt");
			FileReader frr3 = new FileReader(Path.IndexTextDir + "dic3.txt");
			FileReader frr4 = new FileReader(Path.IndexTextDir + "dic4.txt");
			FileReader frr5 = new FileReader(Path.IndexTextDir + "dic5.txt");
			FileReader frr6 = new FileReader(Path.IndexTextDir + "dic6.txt");
			FileReader frr7 = new FileReader(Path.IndexTextDir + "dic7.txt");
			FileReader frr8 = new FileReader(Path.IndexTextDir + "dic8.txt");
			FileReader frr9 = new FileReader(Path.IndexTextDir + "dic9.txt");
			FileReader frr10 = new FileReader(Path.IndexTextDir + "dic10.txt");
			FileReader frr11 = new FileReader(Path.IndexTextDir + "dicTermIndex.txt");
			readdic1 = new BufferedReader(frr1);
			readdic2 = new BufferedReader(frr2);
			readdic3 = new BufferedReader(frr3);
			readdic4 = new BufferedReader(frr4);
			readdic5 = new BufferedReader(frr5);
			readdic6 = new BufferedReader(frr6);
			readdic7 = new BufferedReader(frr7);
			readdic8 = new BufferedReader(frr8);
			readdic9 = new BufferedReader(frr9);
			readdic10 = new BufferedReader(frr10);
			readdic11 = new BufferedReader(frr11);
			
			fr1 = new FileReader(Path.IndexTextDir + "post1.txt");
			fr2 = new FileReader(Path.IndexTextDir + "post2.txt");
			fr3 = new FileReader(Path.IndexTextDir + "post3.txt");
			fr4 = new FileReader(Path.IndexTextDir + "post4.txt");
			fr5 = new FileReader(Path.IndexTextDir + "post5.txt");
			fr6 = new FileReader(Path.IndexTextDir + "post6.txt");
			fr7 = new FileReader(Path.IndexTextDir + "post7.txt");
			fr8 = new FileReader(Path.IndexTextDir + "post8.txt");
			fr9 = new FileReader(Path.IndexTextDir + "post9.txt");
			fr10 = new FileReader(Path.IndexTextDir + "post10.txt");
			fr11 = new FileReader(Path.IndexTextDir + "postingIndex.txt");
			
			//readpost = new BufferedReader(fr1);
			FileReader frid = new FileReader(Path.IndexTextDir + "docid.txt");
			readid = new BufferedReader(frid);
			
		}
		
		//put docno-docid in the map
		String line = readid.readLine();
		while (line != null) {
			String[] noid = line.split(" ");
			getid.put(noid[0], Integer.parseInt(noid[1]));
			line = readid.readLine();
		}
		readid.close();
		
		//put dictionary in the map
		String dic = readdic1.readLine();
		while (dic != null) {
			String[] nocf = dic.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic1.put(nocf[0], cfli);
			dic= readdic1.readLine();
		}
		String dic2 = readdic2.readLine();
		while (dic2 != null) {
			String[] nocf = dic2.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic2.put(nocf[0], cfli);
			dic2= readdic2.readLine();
		}
		String dic3 = readdic3.readLine();
		while (dic3 != null) {
			String[] nocf = dic3.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic3.put(nocf[0], cfli);
			dic3 = readdic3.readLine();
		}
		String dic4 = readdic4.readLine();
		while (dic4 != null) {
			String[] nocf = dic4.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic4.put(nocf[0], cfli);
			dic4 = readdic4.readLine();
		}
		String dic5 = readdic5.readLine();
		while (dic5 != null) {
			String[] nocf = dic5.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic5.put(nocf[0], cfli);
			dic5 = readdic5.readLine();
		}
		String dic6 = readdic6.readLine();
		while (dic6 != null) {
			String[] nocf = dic6.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic6.put(nocf[0], cfli);
			dic6 = readdic6.readLine();
		}
		String dic7 = readdic7.readLine();
		while (dic7 != null) {
			String[] nocf = dic7.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic7.put(nocf[0], cfli);
			dic7 = readdic7.readLine();
		}
		String dic8 = readdic8.readLine();
		while (dic8 != null) {
			String[] nocf = dic8.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic8.put(nocf[0], cfli);
			dic8= readdic8.readLine();
		}
		String dic9 = readdic9.readLine();
		while (dic9 != null) {
			String[] nocf = dic9.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic9.put(nocf[0], cfli);
			dic9= readdic9.readLine();
		}
		String dic10 = readdic10.readLine();
		while (dic10 != null) {
			String[] nocf = dic10.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic10.put(nocf[0], cfli);
			dic10= readdic10.readLine();
		}
		String dic11 = readdic11.readLine();
		while (dic11 != null) {
			String[] nocf = dic11.split(" ");
			int[] cfli = {Integer.parseInt(nocf[1]),Integer.parseInt(nocf[2])};
			getdic11.put(nocf[0], cfli);
			dic11 = readdic11.readLine();
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
		String poststr = null;
		if (getdic1.containsKey(token)) {
			BufferedReader readpost1 = new BufferedReader(fr1);
			int[] tokendf1 = getdic1.get(token);
			int pointer1 = tokendf1[1];
			for (int i = 1; i <pointer1 ; i++) {readpost1.readLine();}
			String posting1 = readpost1.readLine();
			if (poststr == null) {poststr = posting1;}
			else {poststr = poststr + " " + posting1;}
			readpost1.close();
		};
		if (getdic2.containsKey(token)) {
			BufferedReader readpost2 = new BufferedReader(fr2);
			int[] tokendf2 = getdic2.get(token);
			int pointer2 = tokendf2[1];
			for (int i = 1; i <pointer2 ; i++) {readpost2.readLine();}
			String posting2 = readpost2.readLine();
			if (poststr == null) {poststr = posting2;}
			else {poststr = poststr + " " + posting2;}
			readpost2.close();
		};
		if (getdic3.containsKey(token)) {
			BufferedReader readpost3 = new BufferedReader(fr3);
			int[] tokendf3 = getdic3.get(token);
			int pointer3 = tokendf3[1];
			for (int i = 1; i <pointer3 ; i++) {readpost3.readLine();}
			String posting3 = readpost3.readLine();
			if (poststr == null) {poststr = posting3;}
			else {poststr = poststr + " " + posting3;}
			readpost3.close();
		};
		if (getdic4.containsKey(token)) {
			BufferedReader readpost4 = new BufferedReader(fr4);
			int[] tokendf4 = getdic4.get(token);
			int pointer4 = tokendf4[1];
			for (int i = 1; i <pointer4 ; i++) {readpost4.readLine();}
			String posting4 = readpost4.readLine();
			if (poststr == null) {poststr = posting4;}
			else {poststr = poststr + " " + posting4;}
			readpost4.close();
		};
		if (getdic5.containsKey(token)) {
			BufferedReader readpost5 = new BufferedReader(fr5);
			int[] tokendf5 = getdic5.get(token);
			int pointer5 = tokendf5[1];
			for (int i = 1; i <pointer5 ; i++) {readpost5.readLine();}
			String posting5 = readpost5.readLine();
			if (poststr == null) {poststr = posting5;}
			else {poststr = poststr + " " + posting5;}
			readpost5.close();
		};
		if (getdic6.containsKey(token)) {
			BufferedReader readpost6 = new BufferedReader(fr6);
			int[] tokendf6 = getdic6.get(token);
			int pointer6 = tokendf6[1];
			for (int i = 1; i <pointer6 ; i++) {readpost6.readLine();}
			String posting6 = readpost6.readLine();
			if (poststr == null) {poststr = posting6;}
			else {poststr = poststr + " " + posting6;}
			readpost6.close();
		};
		if (getdic7.containsKey(token)) {
			BufferedReader readpost7 = new BufferedReader(fr7);
			int[] tokendf7 = getdic7.get(token);
			int pointer7 = tokendf7[1];
			for (int i = 1; i <pointer7 ; i++) {readpost7.readLine();}
			String posting7 = readpost7.readLine();
			if (poststr == null) {poststr = posting7;}
			else {poststr = poststr + " " + posting7;}
			readpost7.close();
		};
		if (getdic8.containsKey(token)) {
			BufferedReader readpost8 = new BufferedReader(fr8);
			int[] tokendf8 = getdic8.get(token);
			int pointer8 = tokendf8[1];
			for (int i = 1; i <pointer8 ; i++) {readpost8.readLine();}
			String posting8 = readpost8.readLine();
			if (poststr == null) {poststr = posting8;}
			else {poststr = poststr + " " + posting8;}
			readpost8.close();
		};
		if (getdic9.containsKey(token)) {
			BufferedReader readpost9 = new BufferedReader(fr9);
			int[] tokendf9 = getdic9.get(token);
			int pointer9 = tokendf9[1];
			for (int i = 1; i <pointer9 ; i++) {readpost9.readLine();}
			String posting9 = readpost9.readLine();
			if (poststr == null) {poststr = posting9;}
			else {poststr = poststr + " " + posting9;}
			readpost9.close();
		};
		if (getdic10.containsKey(token)) {
			BufferedReader readpost10 = new BufferedReader(fr10);
			int[] tokendf10 = getdic10.get(token);
			int pointer10 = tokendf10[1];
			for (int i = 1; i <pointer10 ; i++) {readpost10.readLine();}
			String posting10 = readpost10.readLine();
			if (poststr == null) {poststr = posting10;}
			else {poststr = poststr + " " + posting10;}
			readpost10.close();
		};
		if (getdic11.containsKey(token)) {
			BufferedReader readpost11 = new BufferedReader(fr11);
			int[] tokendf11 = getdic11.get(token);
			int pointer11 = tokendf11[1];
			for (int i = 1; i <pointer11 ; i++) {readpost11.readLine();}
			String posting11 = readpost11.readLine();
			if (poststr == null) {poststr = posting11;}
			else {poststr = poststr + " " + posting11;}
			readpost11.close();
		};
		
		postdoc = poststr.split(" ");
		
		return postdoc.length;
		
	}
	
	// Return the total number of times the token appears in the collection.
	public long GetCollectionFreq( String token ) throws IOException {
		int cf = 0;
		if (getdic1.containsKey(token)) {
			int[] tokencf1 = getdic1.get(token);
			cf = cf + tokencf1[0];
			};
		if (getdic2.containsKey(token)) {
			int[] tokencf2 = getdic2.get(token);
			cf = cf + tokencf2[0];
			};
		if (getdic3.containsKey(token)) {
			int[] tokencf3 = getdic3.get(token);
			cf = cf + tokencf3[0];
			};
		if (getdic4.containsKey(token)) {
			int[] tokencf4 = getdic4.get(token);
			cf = cf + tokencf4[0];
			};
		if (getdic5.containsKey(token)) {
			int[] tokencf5 = getdic5.get(token);
			cf = cf + tokencf5[0];
			};		
		if (getdic6.containsKey(token)) {
			int[] tokencf6 = getdic6.get(token);
			cf = cf + tokencf6[0];
			};
		if (getdic7.containsKey(token)) {
			int[] tokencf7 = getdic7.get(token);
			cf = cf + tokencf7[0];
			System.out.println(cf);
			};
		if (getdic8.containsKey(token)) {
			int[] tokencf8 = getdic8.get(token);
			cf = cf + tokencf8[0];
			};
		if (getdic9.containsKey(token)) {
			int[] tokencf9 = getdic9.get(token);
			cf = cf + tokencf9[0];
			System.out.println(cf);
			};
			System.out.println(cf);
		if (getdic10.containsKey(token)) {
			int[] tokencf10 = getdic10.get(token);
			cf = cf + tokencf10[0];
			};
		if (getdic11.containsKey(token)) {
			int[] tokencf11 = getdic11.get(token);
			cf = cf + tokencf11[0];
			};
		return cf;
	}
	
	public void Close() throws IOException {
		readid.close();
		readdic1.close();
		readdic2.close();
		readdic3.close();
		readdic4.close();
		readdic5.close();
		readdic6.close();
		readdic7.close();
		readdic8.close();
		readdic9.close();
		readdic10.close();
		readdic11.close();
	}
	
	public static void main(String[] args) throws Exception {
		//HW2Main hm2 = new HW2Main();

		
		long startTime=System.currentTimeMillis();				
		MyIndexReader ixreader=new MyIndexReader("trectext");
		
		// conduct retrieval
		int df = ixreader.GetDocFreq("yhoo");
		long ctf = ixreader.GetCollectionFreq("yhoo");
		System.out.println(" >> the token \""+"yhoo"+"\" appeared in "+df+" documents and "+ctf+" times in total");
		if(df>0){
			int[][] posting = ixreader.GetPostingList("yhoo");
			for(int ix=0;ix<posting.length;ix++){
				int docid = posting[ix][0];
				int freq = posting[ix][1];
				String docno = ixreader.GetDocno(docid);
				System.out.printf("    %20s    %6d    %6d\n", docno, docid, freq);
			}
		}
		ixreader.Close();
		long endTime=System.currentTimeMillis();
		System.out.println("load index & retrieve running time: "+(endTime-startTime)/60000.0+" min");
	}
	
	
}