package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IncreaseDecreaseTest {

	private IncreaseDecrease increaseDecrease;
	@Before
	public void setUp() throws Exception {
		this.increaseDecrease = new IncreaseDecrease();
	}

	@After
	public void tearDown() throws Exception {
		this.increaseDecrease = null;
	}

	@Test
	public void testGetIndexChangeOrder_PositiveScenario() {
		int[] array = {1,2,3,4,5,6,5,4,3,2,1,0,-1,-2};
		assertEquals(5, this.increaseDecrease.getIndexChangeOrder(array));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexChangeOrder_NegativeScenario_AllIncreasing() {
		int[] array = {1,2,3,4,5,6};
		assertEquals(-1, this.increaseDecrease.getIndexChangeOrder(array));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexChangeOrder_NegativeScenario_AllDecreasing() {
		int[] array = {6,5,4,3,2,1};
		assertEquals(-1, this.increaseDecrease.getIndexChangeOrder(array));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexChangeOrder_NegativeScenario_TwoElements() {
		int[] array = {1,2};
		assertEquals(-1, this.increaseDecrease.getIndexChangeOrder(array));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexChangeOrder_NegativeScenario_NullArray() {
		int[] array = null;
		assertEquals(-1, this.increaseDecrease.getIndexChangeOrder(array));
	}
	
	@Test
	public void testGetIndexChangeOrder_PositiveScenario_LargeInteger() {
		int[] array = {1,2,3,2147483645,2147483646,2147483647,5,4,3,2,1,0,-1,-2,-2147483648};
		assertEquals(5, this.increaseDecrease.getIndexChangeOrder(array));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexChangeOrder_NegativeScenario_ReverseOrder() {
		int[] array = {3,2,1,2,3,4,5,6};
		assertEquals(-1, this.increaseDecrease.getIndexChangeOrder(array));
	}

}
