package array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RearrangeNegPosTest {

	private RearrangeNegPos rearrangeNegPos;
	
	@Before
	public void setUp() {
		this.rearrangeNegPos = new RearrangeNegPos();
	}
	
	@After
	public void tearDown() {
		this.rearrangeNegPos = null;
	}
	
	@Test
	public void testRearrange_BasicScenario() {
		int[] array = {1, 3,-3,-5,4,-4};
		this.rearrangeNegPos.rearrange(array);
		int[] expected = {-3,-5,-4,3,4,1};
		assertArrayEquals(expected, array);
	}

}
