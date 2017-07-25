package array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AllElementsInRangeTest {

	private AllElementsInRange allElementsInRange;
	@Before
	public void setUp() throws Exception {
		this.allElementsInRange = new AllElementsInRange();
	}

	@After
	public void tearDown() throws Exception {
		this.allElementsInRange = null;
	}

	@Test
	public void testAreInRangePositive_AllInRange() {
		Integer[] array = {1,2,3,4,5};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_NotAllInRange() {
		Integer[] array = {1,2,3,4,5};
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, 1, 10));
	}
	
	@Test
	public void testAreInRangePositive_AllInRangeWithDuplicate() {
		Integer[] array = {1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,5};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_AllInRangeWithExtra() {
		Integer[] array = {1,2,3,4,5,7,8,9,10,11,12,13,14};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_NullArray() {
		Integer[] array = null;
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}

	@Test
	public void testAreInRangePositive_NullValOfA() {
		Integer[] array = {1,2,3,4,5};
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, null, 5));
	}
	
	@Test
	public void testAreInRangePositive_NullValOfB() {
		Integer[] array = {1,2,3,4,5};
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, 1, null));
	}
	
	@Test
	public void testAreInRangePositive_NullValOfA_B() {
		Integer[] array = {1,2,3,4,5};
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, null, null));
	}
	
	@Test
	public void testAreInRangePositive_NullValOfA_B_Array() {
		Integer[] array = null;
		assertEquals(false, this.allElementsInRange.areInRangePositive(array, null, null));
	}
	
	@Test
	public void testAreInRangePositive_NullArrayElements() {
		Integer[] array = {null,1,2,3,null,null,4,5,null,null};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_NegativeArrayElements() {
		Integer[] array = {null,1,2,3,null,null,4,5,null,null,-1,-2,-3};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_LargeArrayElements() {
		Integer[] array = {null,1,2,3,null,null,4,5,null,null,2147483647,-2147483648,2147483647};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 1, 5));
	}
	
	@Test
	public void testAreInRangePositive_AGraterThanB() {
		Integer[] array = {null,1,2,3,null,null,4,5,null,null,2147483647,-2147483648,2147483647};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 5, 1));
	}
	
	@Test
	public void testAreInRangePositive_AEqualToB() {
		Integer[] array = {null,1,2,3,3,null,null,4,5,null,null,2147483647,-2147483648,2147483647};
		assertEquals(true, this.allElementsInRange.areInRangePositive(array, 5, 5));
	}
	
	@Test
	public void testAreInRangePosNeg_AllInRange() {
		Integer[] array = {1,2,0,-1,-2};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, -2, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_NotAllInRange() {
		Integer[] array = {1,2,0,-1,-2};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, 0, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_AllInRangeWithDuplicate() {
		Integer[] array = {1,2,0,-1,-2,-2,-2,-1,-1,0,1,2};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, -2, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_AllInRangeWithExtra() {
		Integer[] array = {1,2,0,-1,-2,-2,-2,-1,-1,0,1,2,3,4,5,6,7,8};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, -2, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_NullA() {
		Integer[] array = {1,2,0,-1,-2,-2,-2,-1,-1,0,1,2,3,4,5,6,7,8};
		assertEquals(false, this.allElementsInRange.areInRangePosNeg(array, null, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_NullB() {
		Integer[] array = {1,2,0,-1,-2,-2,-2,-1,-1,0,1,2,3,4,5,6,7,8};
		assertEquals(false, this.allElementsInRange.areInRangePosNeg(array, -2, null));
	}
	
	@Test
	public void testAreInRangePosNeg_NullA_B() {
		Integer[] array = {1,2,0,-1,-2,-2,-2,-1,-1,0,1,2,3,4,5,6,7,8};
		assertEquals(false, this.allElementsInRange.areInRangePosNeg(array, null, null));
	}
	
	@Test
	public void testAreInRangePosNeg_NullArray() {
		Integer[] array = null;
		assertEquals(false, this.allElementsInRange.areInRangePosNeg(array, null, null));
	}
	
	@Test
	public void testAreInRangePosNeg_NullArrayElement() {
		Integer[] array = {null,1,2,0,-1,-2,null,null,-2,-2,null,-1,-1,0,1,2,3,4,5,6,7,8};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, -2, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_LargeArrayElement() {
		Integer[] array = {null,1,2,0,-1,-2,null,null,-2,-2,null,-1,-1,0,1,2,3,4,5,6,7,8,2147483647, 2147483647, -2147483648};
		assertEquals(true, this.allElementsInRange.areInRangePosNeg(array, -2, 2));
	}
	
	@Test
	public void testAreInRangePosNeg_LargeA_B() {
		Integer[] array = {null,1,2,0,-1,-2,null,null,-2,-2,null,-1,-1,0,1,2,3,4,5,6,7,8,2147483647, 2147483647, -2147483648};
		assertEquals(false, this.allElementsInRange.areInRangePosNeg(array, -2147483648, 2147483647));
	}
	

}
