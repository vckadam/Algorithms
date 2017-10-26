package search;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KthElementInTwoSortedArrayTest {

	private KthElementInTwoSortedArray kthElementInTwoSortedArray;
	
	@Before
	public void setUp() {
		this.kthElementInTwoSortedArray = new KthElementInTwoSortedArray();
	}
	
	@After
	public void tearDown() {
		this.kthElementInTwoSortedArray = null;
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest() {
		int[] arr1 = {6,7,9};
		int[] arr2 = {1,4,8,10};
		assertEquals(8, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 5));
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest_LastElement() {
		int[] arr1 = {6,7,9};
		int[] arr2 = {1,4,8,10};
		assertEquals(10, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 7));
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest_firstElement() {
		int[] arr1 = {6,7,9};
		int[] arr2 = {1,4,8,10};
		assertEquals(1, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 1));
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest_RandomMiddleElement() {
		int[] arr1 = {6,7,9};
		int[] arr2 = {1,4,8,10};
		assertEquals(6, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 3));
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest_LastInFirstArray() {
		int[] arr1 = {6,7,9};
		int[] arr2 = {1,4,8,10};
		assertEquals(9, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 6));
	}
	
	@Test(timeout = 1000)
	public void testGetKthSmallest_NoIntersectionInArrays() {
		int[] arr1 = {60,70,90,100};
		int[] arr2 = {1,4,8,10};
		assertEquals(70, this.kthElementInTwoSortedArray.getKthSmallest(arr1, arr2, 6));
	}

}
