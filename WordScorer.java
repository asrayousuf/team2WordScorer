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
	
}
