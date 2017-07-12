package AtMostKDistinctCharacter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtMostKDistinctCharacterTest {
   
	AtMostKDistinctCharacter obj;
    
	@Before
	public void beforeMethod() {
		this.obj = new AtMostKDistinctCharacter();
	}
	
	@After
	public void afterMethod() {
		this.obj = null;
	}
	
	/** Longest substring exist.*/
	@Test
	public void getLongestSubStringTest1() {
		int actual = this.obj.getLongestSubString("abcababab", 2);
		assertEquals(6, actual);
	}
	
	/** Entire string is made of 3 character and k = 3. */
	@Test
	public void getLongestSubStringTest2() {
		int actual = this.obj.getLongestSubString("abcababab", 3);
		assertEquals(9, actual);
	}
	
	/** Value of k is vary high. */
	@Test
	public void getLongestSubStringTest3() {
		int actual = this.obj.getLongestSubString("abcababab", 3000);
		assertEquals(9, actual);
	}
	
	/** Value of k is invalid.  */
	@Test
	public void getLongestSubStringTest4() {
		int actual = this.obj.getLongestSubString("abcababab", -3);
		assertEquals(0, actual);
	}
	
	/** Empty string. */
	@Test
	public void getLongestSubStringTest5() {
		int actual = this.obj.getLongestSubString("", 3);
		assertEquals(0, actual);
	}
	
	/**All unique characters in String. */
	@Test
	public void getLongestSubStringTest6() {
		int actual = this.obj.getLongestSubString("abcdefghijklmnopqrstuvwxyz", 5);
		assertEquals(5, actual);
	}
	
	/** String is made of one character. */
	@Test
	public void getLongestSubStringTest7() {
		int actual = this.obj.getLongestSubString("aaaaaaaa", 5);
		assertEquals(8, actual);
	}
	
	/** Two result string exist. */
	@Test
	public void getLongestSubStringTest8() {
		int actual = this.obj.getLongestSubString("aaaabbbb", 1);
		assertEquals(4, actual);
	}
	
	/** Overlapping two result strings. */
	@Test
	public void getLongestSubStringTest9() {
		int actual = this.obj.getLongestSubString("aaaabbbbdddd", 2);
		assertEquals(8, actual);
	}
	
	/** String with upper and lower case.*/
	@Test
	public void getLongestSubStringTest10() {
		int actual = this.obj.getLongestSubString("aaAAbbBBddDD", 2);
		assertEquals(4, actual);
	}
}
