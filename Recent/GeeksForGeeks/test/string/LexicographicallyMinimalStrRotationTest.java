package string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LexicographicallyMinimalStrRotationTest {

	LexicographicallyMinimalStrRotation lexicographicallyMinimalStrRotation;
	@Before
	public void setUp() throws Exception {
		this.lexicographicallyMinimalStrRotation = new LexicographicallyMinimalStrRotation();
	}

	@After
	public void tearDown() throws Exception {
		this.lexicographicallyMinimalStrRotation = null;
	}

	@Test
	public void testGetMinString_BasicPositiveScenario() {
		assertEquals("abcd", this.lexicographicallyMinimalStrRotation.getMinString("dabc"));
	}
	
	@Test
	public void testGetMinString_PositiveScenarioWithDuplicateChar() {
		assertEquals("aabbbcd", this.lexicographicallyMinimalStrRotation.getMinString("daabbbc"));
	}
	
	@Test
	public void testGetMinString_NullString() {
		assertEquals(null, this.lexicographicallyMinimalStrRotation.getMinString(null));
	}
	
	@Test
	public void testGetMinString_SingleLengString() {
		assertEquals("a", this.lexicographicallyMinimalStrRotation.getMinString("a"));
	}

	@Test
	public void testGetMinString_EmptyString() {
		assertEquals("", this.lexicographicallyMinimalStrRotation.getMinString(""));
	}
	
	@Test
	public void testGetMinString_PositiveScenarioAllSameChar() {
		assertEquals("aaaa", this.lexicographicallyMinimalStrRotation.getMinString("aaaa"));
	}
}
