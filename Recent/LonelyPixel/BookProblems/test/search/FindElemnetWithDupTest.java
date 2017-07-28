package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindElemnetWithDupTest {
 
	private FindElemnetWithDup findElemnetWithDup;
	@Before
	public void setUp() throws Exception {
		this.findElemnetWithDup = new FindElemnetWithDup();
	}

	@After
	public void tearDown() throws Exception {
		this.findElemnetWithDup = null;
	}

	@Test
	public void testGetFirstIndex_PositiveScenario() {
		int[] array = {1,2,3,3,3,3,3,4,4,4,5,5,5,5,5};
		assertEquals(2, this.findElemnetWithDup.getFirstIndex(array, 3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetFirstIndex_NegativeScenario_NoElement() {
		int[] array = {1,2,3,3,3,3,3,4,4,4,5,5,5,5,5};
		assertEquals(2, this.findElemnetWithDup.getFirstIndex(array, 30));
	}

}
