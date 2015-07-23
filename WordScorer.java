package day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class WordScorer {
	 HashMap<Character, Integer> characterScoreMap = new HashMap<Character, Integer>();
	 HashMap<String, Integer> wordScoreMap = new HashMap<String, Integer>();
	 
	public WordScorer(){
		for (int i='a';i<='z';i++){
			characterScoreMap.put((char)i, i-'a'+1);
		}
	}
	public int getCharacterScore(char letter){
		return characterScoreMap.get(letter);
	}
	public int getWordScore(String word){
		   char[] chars = word.toCharArray();
		   int score=0;
		   for(int i=0; i<chars.length; i++){
			   score += getCharacterScore(chars[i]);
		   }
		   return score;
	}
	
	public void insert(String word) {
		wordScoreMap.put(word, getWordScore(word));
	}
	
	public TreeMap<String,Integer> getSortedList() {
	
		SortByValue sortObj= new SortByValue(wordScoreMap);
		TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(sortObj);
		sorted_map.putAll(wordScoreMap);
		return sorted_map;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		if (args.length < 1) {
			System.out.println("No file path entered");
			System.exit(0);
		}
		FileReader sowpods= new FileReader(args[0]);
		BufferedReader in=new BufferedReader(sowpods);
		
		File fout = new File(args[1]);
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		WordScorer ws = new WordScorer();
		String word=in.readLine();
		while (word!=null) {
			ws.insert(word);
			word=in.readLine();
		}
		in.close();
		
		TreeMap<String,Integer> sorted_map = ws.getSortedList();
		java.util.Iterator<Entry<String, Integer>> it = sorted_map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        bw.write(String.valueOf(pair.getKey() + " " +pair.getValue()));
			bw.newLine();
	    }
	    bw.close();		
	}
}
