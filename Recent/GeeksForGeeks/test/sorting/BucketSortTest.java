package sorting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BucketSortTest {

	private BucketSort bucketSort;
	
	@Before
	public void setUp() throws Exception {
		this.bucketSort = new BucketSort();
	}

	@Test
	public void testSortByWeight_BasicScenario() {
		int[] array = {2,3,1,5,4};
		int[] actual = this.bucketSort.sortByWeight(array, 3);
		int[] expected = {2,5,1,4,3};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSortByWeight_Duplicate() {
		int[] array = {2,3,2,3,4};
		int[] actual = this.bucketSort.sortByWeight(array, 3);
		int[] expected = {2,2,4,3,3};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSortByWeight_LargeValues() {
		int[] array = {2,3,2,3,4,2147483647};
		int[] actual = this.bucketSort.sortByWeight(array, 2);
		int[] expected = {3,3,2147483647,2,2,4};
		assertArrayEquals(expected, actual);
	}

}
