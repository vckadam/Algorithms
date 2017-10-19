package trie;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LexographicallyPrevAndNextTest {

	private LexographicallyPrevAndNext lexographicallyPrevAndNext;
	
	@Before
	public void setUp() {
		this.lexographicallyPrevAndNext = new LexographicallyPrevAndNext();
	}
	
	@After 
	public void tearUp() {
		this.lexographicallyPrevAndNext = null;
	}
	
	@Test
	public void testGetNext_BasicScenario() {
		String[] strs = {"ab", "abc", "abcd", "abcde"};
		assertEquals("abcd", this.lexographicallyPrevAndNext.getNext(strs, "abc"));
	}
	
	@Test
	public void testGetNext_LastLevelTwo() {
		String[] strs = {"ab", "abc", "abcd", "abca", "abcde"};
		assertEquals("abca", this.lexographicallyPrevAndNext.getNext(strs, "abc"));
	}
	
	@Test
	public void testGetNext_NoNext() {
		String[] strs = {"ab", "abc", "abcd", "abca", "abcde", "ae"};
		assertEquals(null, this.lexographicallyPrevAndNext.getNext(strs, "ae"));
	}
	
	@Test
	public void testGetNext_StringNotInArray() {
		String[] strs = {"ab", "abc", "abcd", "abca", "abcde", "ae"};
		assertEquals("ab", this.lexographicallyPrevAndNext.getNext(strs, "a"));
	}
	
	@Test
	public void testGetNext_StringNotInArrayInBettween() {
		String[] strs = {"ab", "abc", "abcd", "abca", "abcde", "ae"};
		assertEquals("ae", this.lexographicallyPrevAndNext.getNext(strs, "ad"));
	}
	
	@Test
	public void testGetNext_StringNotInArrayFromTop() {
		String[] strs = {"ab", "abc", "abcd", "abca", "abcde", "ae"};
		assertEquals(null, this.lexographicallyPrevAndNext.getNext(strs, "z"));
	}

}
