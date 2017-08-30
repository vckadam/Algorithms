package array;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargestSubArrayConsequtiveTest {

	private LargestSubArrayConsequtive largestSubArrayConsequtive;
	@Before
	public void setUp() throws Exception {
		this.largestSubArrayConsequtive = new LargestSubArrayConsequtive();
	}

	@Test
	public void testGetSubArray_BasicScenario() {
		int[] array = {2,0,2,1,4,3,1,0};
		int[] actual = this.largestSubArrayConsequtive.getSubArray(array);
		int[] expected = new int[]{1,5};
		assertArrayEquals(expected,actual);
	}
	
	@Test
	public void testGetSubArray_Overlapping() {
		int[] array = {2,0,2,1,4,3,1,2,6,5};
		int[] actual = this.largestSubArrayConsequtive.getSubArray(array);
		int[] expected = new int[]{4,9};
		assertArrayEquals(expected,actual);
	}
	
	@Test
	public void testGetSubArray_CoverEntireArray() {
		int[] array = {0,1,2,3,4,5};
		int[] actual = this.largestSubArrayConsequtive.getSubArray(array);
		int[] expected = new int[]{0,5};
		assertArrayEquals(expected,actual);
	}
	
	
	@Test
	public void testGetSubArray_OnlyOneElement() {
		int[] array = {0,2,4,6,9};
		int[] actual = this.largestSubArrayConsequtive.getSubArray(array);
		int[] expected = new int[]{0,0};
		assertArrayEquals(expected,actual);
	}
	
	@Test
	public void testGetSubArray_SingleElementArray() {
		int[] array = {0};
		int[] actual = this.largestSubArrayConsequtive.getSubArray(array);
		int[] expected = new int[]{0,0};
		assertArrayEquals(expected,actual);
	}
	
	@Test(expected=Exception.class)
	public void testGetSubArray_NullArray() {
		int[] array = null;
		this.largestSubArrayConsequtive.getSubArray(array);
	}

}
