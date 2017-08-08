package string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringStartEndWith1Test {

	private StringStartEndWith1 stringStartEndWith1;
	@Before
	public void setUp() throws Exception {
		this.stringStartEndWith1 = new StringStartEndWith1();
	}

	@After
	public void tearDown() throws Exception {
		this.stringStartEndWith1 = null;
	}

	@Test
	public void testGetCountOfSubString_BasicScenario() {
		assertEquals(1, this.stringStartEndWith1.getCountOfSubString("101"));
	}
	
	@Test
	public void testGetCountOfSubString_OverlappingSubStrings() {
		assertEquals(3, this.stringStartEndWith1.getCountOfSubString("10101"));
	}
	
	@Test
	public void testGetCountOfSubString_NotPossible() {
		assertEquals(0, this.stringStartEndWith1.getCountOfSubString("100"));
	}
	
	@Test
	public void testGetCountOfSubString_InputContainsJustOne() {
		assertEquals(3, this.stringStartEndWith1.getCountOfSubString("111"));
	}
	
	@Test
	public void testGetCountOfSubString_InputContainsJustZero() {
		assertEquals(0, this.stringStartEndWith1.getCountOfSubString("000"));
	}
	
	@Test
	public void testGetCountOfSubString_LengthOne() {
		assertEquals(0, this.stringStartEndWith1.getCountOfSubString("0"));
	}
	
	@Test(expected = Exception.class)
	public void testGetCountOfSubString_NullString() {
		assertEquals(0, this.stringStartEndWith1.getCountOfSubString(null));
	}

}
