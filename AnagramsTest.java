package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void testSortWord() {
		Anagrams af = new Anagrams();
		assertTrue("Sorting adcb should give abcd", "abcd".equals(af.sortWord("acdb")));
	}
}
