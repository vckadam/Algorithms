package test.array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import array.ConsecutiveArrayElements;

public class ConsecutiveArrayElementsTest {

	ConsecutiveArrayElements consecutiveArrayElements;
	@Before
	public void setUp() throws Exception {
		this.consecutiveArrayElements = new ConsecutiveArrayElements();
	}

	@After
	public void tearDown() throws Exception {
		this.consecutiveArrayElements = null;
	}

	/** Tests an array with consecutive values.*/
	@Test
	public void test1IsConsecutive() {
		Integer[] array = {1,2,3,4,5,6,7};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with non-consecutive values.*/
	@Test
	public void test2IsConsecutive() {
		Integer[] array = {11,22,33,44,55,66,77};
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with consecutive values containing positive as well as negative.*/
	@Test
	public void test3IsConsecutive() {
		Integer[] array = {-1,-2,-3,0,1,2,3};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with all consecutive negative values.*/
	@Test
	public void test4IsConsecutive() {
		Integer[] array = {-1,-2,-3,-4,-5,-6,-7};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with consecutive large values.*/
	@Test
	public void test5IsConsecutive() {
		Integer[] array = {2147483643,2147483644,2147483645,2147483646,2147483647};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with consecutive negative large values.*/
	@Test
	public void test6IsConsecutive() {
		Integer[] array = {-2147483643,-2147483644,-2147483645,-2147483646,-2147483647,-2147483648};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests null array.*/
	@Test
	public void test7IsConsecutive() {
		Integer[] array = null;
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array which contains some null value.*/
	@Test
	public void test8IsConsecutive() {
		Integer[] array = {1,2,null,3,4,5,6,7,null};
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an empty array.*/
	@Test
	public void test9IsConsecutive() {
		Integer[] array = {};
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with single element.*/
	@Test
	public void test10IsConsecutive() {
		Integer[] array = {1};
		assertEquals(true, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with duplicate values.*/
	@Test
	public void test11IsConsecutive() {
		Integer[] array = {1,2,3,4,4,7,7};
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}
	
	/** Tests an array with values.*/
	@Test
	public void test12IsConsecutive() {
		Integer[] array = {1,9};
		assertEquals(false, this.consecutiveArrayElements.isConsecutive(array));
	}

}
