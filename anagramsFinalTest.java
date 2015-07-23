package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class anagramsFinalTest {

	@Test
	public void testSortWord() {
		anagramsFinal af = new anagramsFinal();
		assertTrue("Sorting adcb should give abcd", "abcd".equals(af.sortWord("acdb")));
	}
}
