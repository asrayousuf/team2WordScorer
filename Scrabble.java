package day4;

import java.io.IOException;
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
		
		String rack= getTiles();
		System.out.println("Rack: "+rack);
		anagramsFinal af = new anagramsFinal();
		HashMap<String, String> anagrams = af.getAnagramList();
		WordScorer ws = new WordScorer();
		Combinations c = new Combinations(rack);
		
		for (String combination : c.combinations) {
			if(anagrams.containsKey(af.sortWord(combination))) {
				String[] result = anagrams.get(af.sortWord(combination)).split(" ");
				for(String str: result) {
					ws.insert(str);
				}
			}
		}		
		TreeMap<String,Integer> sorted_map = ws.getSortedList();
		java.util.Iterator<Entry<String, Integer>> it = sorted_map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(String.valueOf(pair.getKey() + " " +pair.getValue()));
			
	    }	
	}

}
