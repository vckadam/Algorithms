package WindowAverage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WindowAverageTest {

	@SuppressWarnings("deprecation")
	@Test
	public void getWindowSumTest() {
		WindowAverage obj = new WindowAverage();
		Integer[] array1 = {1,2,3,4,5};
		Integer[] ret1 = {6,9,12};
		assertEquals(ret1[0].intValue(), obj.getWindowSum(array1, 3)[0].intValue());
		//assertTrue(ret1.equals(obj.getWindowSum(array1, 3)));
		assertEquals(ret1, obj.getWindowSum(array1, 3));
		Integer[] array2 = {null, 2, null, 4};
		Integer[] ret2 = {6};
		assertEquals(ret2, obj.getWindowSum(array2, 10));
		Integer[] array3 = new Integer[0];
		Integer[] ret3 = {};
		assertEquals(ret3, obj.getWindowSum(array3, 3));
		Integer[] array4 = {null, 2, null, 4};
		Integer[] ret4 = {2,6};
		assertEquals(ret4, obj.getWindowSum(array4, 3));
		Integer[] array5 = {null, 2, null, 4};
		Integer[] ret5 = {6};
		assertEquals(ret5, obj.getWindowSum(array5, 4));
		Integer[] array6 = {null, 2, null, Integer.MAX_VALUE};
		Integer[] ret6 = {2, Integer.MAX_VALUE};
		assertEquals(ret6, obj.getWindowSum(array6, 3));
		Integer[] array7 = {null, 2, null, Integer.MAX_VALUE};
		Integer[] ret7 = {Integer.MAX_VALUE};
		assertEquals(ret7, obj.getWindowSum(array7, 10));
		
		
	}
}
