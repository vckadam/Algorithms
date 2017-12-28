package string;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KthCharSubStringOccTest {
	
	private KthCharSubStringOcc kthCharSubStringOcc;
	
	@Before
	public void setUp() {
		this.kthCharSubStringOcc = new KthCharSubStringOcc();
	}

	@Test
	public void testGetkthCharacter_firstSubstring() {
		assertEquals('b', this.kthCharSubStringOcc.getkthCharacter("ab2cd2", 4));
	}
	
	@Test
	public void testGetkthCharacter_secondSubstring() {
		assertEquals('c', this.kthCharSubStringOcc.getkthCharacter("ab2cd2", 5));
	}
	
	@Test
	public void testGetkthCharacter_secondSubstring_lastChar() {
		assertEquals('d', this.kthCharSubStringOcc.getkthCharacter("ab2cd2", 8));
	}
	
	@Test
	public void testGetkthCharacter_withOutLastOccr() {
		assertEquals('d', this.kthCharSubStringOcc.getkthCharacter("ab2cd", 6));
	}

}
