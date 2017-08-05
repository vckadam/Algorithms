package tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountSmallerOnRightTest {

	private CountSmallerOnRight countSmallerOnRight;
	@Before
	public void setUp() throws Exception {
		this.countSmallerOnRight = new CountSmallerOnRight();
	}

	@After
	public void tearDown() throws Exception {
		this.countSmallerOnRight = null;
	}

	@Test
	public void testGetSmallEleOnRight_BasicScenario() {
		int[] input = {12, 1, 2, 3, 0, 11, 4};
		int[] expected = {6, 1, 1, 1, 0, 1, 0};
		assertArrayEquals(expected, this.countSmallerOnRight.getSmallEleOnRight(input));
	}
	
	@Test
	public void testGetSmallEleOnRight_SortedAscending() {
		int[] input = {5, 4, 3, 2, 1};
		int[] expected = {4, 3, 2, 1, 0};
		assertArrayEquals(expected, this.countSmallerOnRight.getSmallEleOnRight(input));
	}
	
	@Test
	public void testGetSmallEleOnRight_DuplicateEle() {
		int[] input = {5, 4, 3, 3, 2, 2, 1};
		int[] expected = {6, 5, 3, 3, 1, 1, 0};
		assertArrayEquals(expected, this.countSmallerOnRight.getSmallEleOnRight(input));
	}
	
	@Test
	public void testGetSmallEleOnRight_SortedDescending() {
		int[] input = {1, 2, 3, 4, 5};
		int[] expected = {0, 0, 0, 0, 0};
		assertArrayEquals(expected, this.countSmallerOnRight.getSmallEleOnRight(input));
	}

}
