package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Scrabble {
	public static String getTiles()
	{
		int min='a';
		int max='z';
		String rack="";
		for(int i=0;i<7;i++)
		{
			rack+= (char)(min + (int)(Math.random() * ((max - min) + 1)));
		}
		return rack;	
	}
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.println("Enter String");
		String rack=in.readLine();
	
		System.out.println("Rack: " + rack);
		Anagrams af = new Anagrams();
		HashMap<String, String> anagrams = af.getAnagramList("C:/Users/test/Pictures/sowpods.txt");
		WordScorer ws = new WordScorer();
		Combinations c = new Combinations(rack);
		
		for (String combination : c.combinations) {
			if(anagrams.containsKey(af.sortWord(combination))) {
				String[] result = anagrams.get(af.sortWord(combination)).split(" ");
				for(String str: result) {
					ws.insertWithScore(str, ws.getWordScore(combination));
				}
			}
		}		
		TreeMap<String,Integer> sorted_map = ws.getSortedList();
		java.util.Iterator<Entry<String, Integer>> it = sorted_map.entrySet().iterator();
		if(sorted_map.isEmpty()){
			System.out.println("No words possible");
		}
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(String.valueOf(pair.getKey() + " " +pair.getValue()));
			
	    }	
	}

}
