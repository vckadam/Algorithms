package AtMost2DistinctCharacter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtMost2DistinctCharacterTest {
	
	AtMost2DistinctCharacter obj;
	
	@Before
	public void beforeMethod() {
		obj = new AtMost2DistinctCharacter();
	}
	
	@After
	public void afterMethod() {
		obj = null;
	}
	
	/** multiple longest Strings with 2 unique character exist.*/
	@Test
	public void getLongestSubStringTest1() {
		int actual = obj.getLongestSubString("abcababab");
		assertEquals(6, actual);
	}
	
	/** entire string is made of 2 character. */
	@Test
	public void getLongestSubStringTest2() {
		int actual = obj.getLongestSubString("abababaaaabbbababa");
		assertEquals(18, actual);
	}
	
	/** entire string is made of 1 character. */
	@Test
	public void getLongestSubStringTest3() {
		int actual = obj.getLongestSubString("aaaaaaaa");
		assertEquals(8, actual);
	}
	
	/** Only one character in the string.*/
	@Test
	public void getLongestSubStringTest4() {
		int actual = obj.getLongestSubString("a");
		assertEquals(1, actual);
	}
	
	/** Empty string string.*/
	@Test
	public void getLongestSubStringTest5() {
		int actual = obj.getLongestSubString("");
		assertEquals(0, actual);
	}
	
	/** Two character in the string.*/
	@Test
	public void getLongestSubStringTest6() {
		int actual = obj.getLongestSubString("ab");
		assertEquals(2, actual);
	}
	
	/** String with all unique character. */
	@Test
	public void getLongestSubStringTest7() {
		int actual = obj.getLongestSubString("abcdefghijklmnopqrstuvwxyz");
		assertEquals(2, actual);
	}
	
	/** String contains same length substring with 2 distinct characters. */
	@Test
	public void getLongestSubStringTest8() {
		int actual = obj.getLongestSubString("ababababcdededede");
		assertEquals(8, actual);
	}
	
	/** String contains same length substring with 2 distinct characters. 
	 * with same character together. 
	 * */
	@Test
	public void getLongestSubStringTest9() {
		int actual = obj.getLongestSubString("aaaabbbbcdeeeeffff");
		assertEquals(8, actual);
	}
	
	/** String with lower and upper case characters. 
	 * */
	@Test
	public void getLongestSubStringTest10() {
		int actual = obj.getLongestSubString("aaAabBBbbcdeeEEFfff");
		assertEquals(5, actual);
	}
}
