package day4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		System.out.println("Test 1: Testing anagram class");
		Anagrams af = new Anagrams();
		HashMap<String, String> anagrams = af.getAnagramList("C:/Users/test/Pictures/sowpdList.txt");
		 Iterator<Entry<String, String>> itrtr1 = anagrams.entrySet().iterator();
		    while (itrtr1.hasNext()) {
		        Map.Entry pair = (Map.Entry)itrtr1.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		    }
		   
		    System.out.println("Test 2: Testing Word Scorer Class");
		    String sampleWords[]={"apple","bat","car","dog","elephant","fish","gun","house","ice","jug"};
		    WordScorer ws=new WordScorer();
		    for(String str: sampleWords) {
				ws.insert(str);
			}
		  TreeMap<String,Integer> sorted_map = ws.getSortedList();
			java.util.Iterator<Entry<String, Integer>> it = sorted_map.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(String.valueOf(pair.getKey() + " " +pair.getValue()));
		    }
		    
		    System.out.println("Test 3: Testing Combinations Class");
		    Combinations cmb= new Combinations("ab ");
		    System.out.println(cmb.combinations);
		    
		    System.out.println("Test 3: Testing anagram generation of all combinations");
		    for (String combination : cmb.combinations) {
				if(anagrams.containsKey(af.sortWord(combination))) {
					String[] result = anagrams.get(af.sortWord(combination)).split(" ");
					for(int i=0;i<result.length;i++)
					 System.out.println(result[i]);
				}
			}	
		    }
		    
	}

