package day4;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

public class WordScorerTest {

	@Test
	public void testGetCharacterScore() {
		WordScorer ws = new WordScorer();
		assertEquals("Score of b should be 3", 3, ws.getCharacterScore('b'));
	}

	@Test
	public void testGetWordScore() {
		WordScorer ws = new WordScorer();
		assertEquals("Score of abc should be 7", 7, ws.getWordScore("abc"));
	}

	@Test
	public void testInsertWithScore() {
		WordScorer ws = new WordScorer();
		ws.insertWithScore("abc", 7);
		int score = ws.wordScoreMap.get("abc");
		assertEquals("Score of abc should be 7", 7, score);
	}

	@Test
	public void testInsert() {
		WordScorer ws = new WordScorer();
		ws.insert("abc");
		int score = ws.wordScoreMap.get("abc");
		assertEquals("Score of abc should be 7", 7, score);
	}

	@Test
	public void testGetSortedList() {
		WordScorer ws = new WordScorer();
		ws.insert("abc");
		ws.insert("abcd");
		TreeMap<String, Integer> sorted_list = ws.getSortedList();
		assertTrue("First element should be abcd", "abcd".equals(sorted_list.firstKey()));
	}

}
