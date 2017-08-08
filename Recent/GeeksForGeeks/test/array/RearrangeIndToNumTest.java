package array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RearrangeIndToNumTest {
	
	private RearrangeIndToNum rearrangeIndToNum;
	@Before
	public void setUp() throws Exception {
		this.rearrangeIndToNum = new RearrangeIndToNum();
	}

	@After
	public void tearDown() throws Exception {
		this.rearrangeIndToNum = null;
	}

	@Test
	public void testReArrange_BasicScenario() {
		int[] array = {1, 3, 0, 2};
		int[] expected = {2, 0, 3, 1};
		this.rearrangeIndToNum.reArrange(array);
		assertArrayEquals(expected,array);
	}
	
	@Test
	public void testReArrange_BasicBiggerSize() {
		int[] array = {2, 0, 1, 4, 5, 3};
		int[] expected = {1, 2, 0, 5, 3, 4};
		this.rearrangeIndToNum.reArrange(array);
		assertArrayEquals(expected,array);
	}
	
	@Test
	public void testReArrange_SortedAsced() {
		int[] array = {0, 1, 2, 3};
		int[] expected = {0, 1, 2, 3};
		this.rearrangeIndToNum.reArrange(array);
		assertArrayEquals(expected,array);
	}
	
	@Test
	public void testReArrange_SortedDesced() {
		int[] array = {3, 2, 1, 0};
		int[] expected = {3, 2, 1, 0};
		this.rearrangeIndToNum.reArrange(array);
		assertArrayEquals(expected,array);
	}

}
