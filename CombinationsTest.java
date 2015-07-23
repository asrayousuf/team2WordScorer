package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationsTest {

	@Test
	public void test() {
		Combinations cmb= new Combinations("ab");
		assertEquals("Size must be 3", 3, cmb.combinations.size());
		assertTrue("Must contain ab", cmb.combinations.contains("ab"));
		cmb = new Combinations("a b");
		assertEquals("Size must be 4*27 - 1", 4*27 - 1, cmb.combinations.size());
		assertTrue("Must contain abZ", cmb.combinations.contains("aZb"));
	}

}
