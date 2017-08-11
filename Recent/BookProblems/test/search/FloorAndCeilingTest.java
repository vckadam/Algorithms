package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FloorAndCeilingTest {

	private FloorAndCeiling floorAndCeiling;
	@Before
	public void setUp() throws Exception {
		this.floorAndCeiling = new FloorAndCeiling();
	}

	@After
	public void tearDown() throws Exception {
		this.floorAndCeiling = null;
	}

	@Test
	public void testGetFloor_BasicScenario() {
		int[] array = {1, 3};
		assertEquals(1, this.floorAndCeiling.getFloor(array, 2));
	}
	
	@Test
	public void testGetFloor_NumPresent() {
		int[] array = {1, 3};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 3));
	}
	
	@Test
	public void testGetFloor_NumPresentFirstPos() {
		int[] array = {1, 3};
		assertEquals(1, this.floorAndCeiling.getFloor(array, 1));
	}
	
	@Test
	public void testGetFloor_NumLessThanAll() {
		int[] array = {1, 3};
		assertEquals(-1, this.floorAndCeiling.getFloor(array, 0));
	}
	
	@Test
	public void testGetFloor_NumGreaterThanAll() {
		int[] array = {1, 3};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 5));
	}
	
	@Test(timeout = 100)
	public void testGetFloor_OddLengthNumberNotPresent() {
		int[] array = {1, 3, 5};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 4));
	}
	
	@Test
	public void testGetFloor_OddLengthNumberPresent() {
		int[] array = {1, 3, 5};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 3));
	}
	
	@Test(timeout = 100)
	public void testGetFloor_Duplicate() {
		int[] array = {1, 1, 3, 3, 5, 5};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 4));
	}
	
	@Test(timeout = 100)
	public void testGetFloor_NegativeEle() {
		int[] array = {-2, 0, 1, 1, 3, 3, 5, 5};
		assertEquals(-2, this.floorAndCeiling.getFloor(array, -1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetFloor_NullInput() {
		int[] array = null;
		assertEquals(3, this.floorAndCeiling.getFloor(array, 4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetFloor_EmptyArray() {
		int[] array = {};
		assertEquals(3, this.floorAndCeiling.getFloor(array, 4));
	}
	
	@Test
	public void testGetFloor_SingleElementArray() {
		int[] array = {2};
		assertEquals(2, this.floorAndCeiling.getFloor(array, 4));
	}
	
	@Test(timeout = 100)
	public void testGetFloor_SmallestInteger() {
		int[] array = {-2147483648, 1, 1, 3, 3, 5, 5, 2147483647};
		assertEquals(-2147483648, this.floorAndCeiling.getFloor(array, -2147483648));
	}
	
	@Test(timeout = 100)
	public void testGetFloor_LargestInteger() {
		int[] array = {-2147483648, 1, 1, 3, 3, 5, 5, 2147483647};
		assertEquals(2147483647, this.floorAndCeiling.getFloor(array, 2147483647));
	}
	
	@Test
	public void testGetCeiling_BasicScenario() {
		int[] array = {1, 3};
		assertEquals(3, this.floorAndCeiling.getCeiling(array, 2));
	}
	
	@Test
	public void testGetCeiling_NumPresent() {
		int[] array = {1, 3};
		assertEquals(3, this.floorAndCeiling.getCeiling(array, 3));
	}
	
	@Test
	public void testGetCeiling_NumPresentFirstPos() {
		int[] array = {1, 3};
		assertEquals(1, this.floorAndCeiling.getCeiling(array, 0));
	}
	
	@Test
	public void testGetCeiling_NumGreaterThanAll() {
		int[] array = {1, 3};
		assertEquals(-1, this.floorAndCeiling.getCeiling(array, 4));
	}
	
	@Test
	public void testGetCeiling_NumLessThanAll() {
		int[] array = {1, 3};
		assertEquals(1, this.floorAndCeiling.getCeiling(array, 0));
	}
	
	@Test(timeout = 100)
	public void testGetCeiling_OddLengthNumberNotPresent() {
		int[] array = {1, 3, 5};
		assertEquals(5, this.floorAndCeiling.getCeiling(array, 4));
	}
	
	@Test
	public void testGetCeiling_OddLengthNumberPresent() {
		int[] array = {1, 3, 5};
		assertEquals(3, this.floorAndCeiling.getCeiling(array, 2));
	}
	
	@Test(timeout = 100)
	public void testGetCeiling_Duplicate() {
		int[] array = {1, 1, 3, 3, 5, 5};
		assertEquals(5, this.floorAndCeiling.getCeiling(array, 4));
	}
	
	@Test(timeout = 100)
	public void testGetCeiling_NegativeEle() {
		int[] array = {-2, 0, 1, 1, 3, 3, 5, 5};
		assertEquals(0, this.floorAndCeiling.getCeiling(array, -1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCeiling_NullInput() {
		int[] array = null;
		assertEquals(3, this.floorAndCeiling.getCeiling(array, 4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCeiling_EmptyArray() {
		int[] array = {};
		assertEquals(3, this.floorAndCeiling.getCeiling(array, 4));
	}
	
	@Test
	public void testGetCeiling_SingleElementArray() {
		int[] array = {2};
		assertEquals(2, this.floorAndCeiling.getCeiling(array, 1));
	}
	
	@Test(timeout = 100)
	public void testGetCeiling_SmallestInteger() {
		int[] array = {-2147483648, 1, 1, 3, 3, 5, 5, 2147483647};
		assertEquals(-2147483648, this.floorAndCeiling.getCeiling(array, -2147483648));
	}
	
	@Test(timeout = 100)
	public void testGetCeiling_LargestInteger() {
		int[] array = {-2147483648, 1, 1, 3, 3, 5, 5, 2147483647};
		assertEquals(2147483647, this.floorAndCeiling.getCeiling(array, 6));
	}
	

}
