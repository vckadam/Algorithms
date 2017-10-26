package array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaxRotationSumWithIndexTest {

	private MaxRotationSumWithIndex maxRotationSumWithIndex;
	
	@Before
	public void setUp() {
		this.maxRotationSumWithIndex = new MaxRotationSumWithIndex();
	}
	
	@After 
	public void tearDown() {
		this.maxRotationSumWithIndex = null;
	}
	
	@Test
	public void testGetMaxSum() {
		int[] array = {1,2,3,4};
		assertEquals(20, this.maxRotationSumWithIndex.getMaxSum(array));
	}
	
	@Test
	public void testGetMaxSum_GFG() {
		int[] array = {8,3,1,2};
		assertEquals(29, this.maxRotationSumWithIndex.getMaxSum(array));
	}

}
