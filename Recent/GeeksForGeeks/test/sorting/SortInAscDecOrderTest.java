package sorting;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class SortInAscDecOrderTest {

	private SortInAscDecOrder sortInAscDecOrder;
	@Before
	public void setUp() throws Exception {
		this.sortInAscDecOrder = new SortInAscDecOrder();
	}
	@Test(timeout = 200)
	public void testSortArray_BasicScenario() {
		int[] array = {2,3,5,1,6,4};
		this.sortInAscDecOrder.sortArray(array);
		int[] expected = {1,6,2,5,3,4};
		assertArrayEquals(expected,array);
	}
	
	@Test(timeout = 200)
	public void testSortArray_OddLength() {
		int[] array = {2,3,5,1,6,4,7};
		this.sortInAscDecOrder.sortArray(array);
		int[] expected = {1,7,2,6,3,5,4};
		assertArrayEquals(expected,array);
	}
	
	@Test(timeout = 200)
	public void testSortArray_TwoElement() {
		int[] array = {2,1};
		this.sortInAscDecOrder.sortArray(array);
		int[] expected = {1,2};
		assertArrayEquals(expected,array);
	}

}
