package array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindIndTo0Max1SeqTest {

	private FindIndTo0Max1Seq findIndTo0Max1Seq;
	@Before
	public void setUp() throws Exception {
		this.findIndTo0Max1Seq = new FindIndTo0Max1Seq();
	}

	@After
	public void tearDown() throws Exception {
		this.findIndTo0Max1Seq = null;
	}

	@Test
	public void testGetIndex_BasicScenario() {
		int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		assertEquals(9, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_AllOne() {
		int[] array = {1, 1, 1, 1, 1};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_AllZero() {
		int[] array = {0, 0, 0, 0, 0};
		assertEquals(0, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_EntireArraySol() {
		int[] array = {1, 1, 0, 1, 1};
		assertEquals(2, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_MultiplePossSols() {
		int[] array = {1, 1, 0, 1, 1,0,1,1};
		assertEquals(2, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_OptimulAmoungsTwo() {
		int[] array = {1, 1, 0, 1, 1,0,1,1,1,1};
		assertEquals(5, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_ZerosFollowedByOnes() {
		int[] array = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		assertEquals(4, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_OnesFollowedByZeros() {
		int[] array = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
		assertEquals(5, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_OnesZeroElement() {
		int[] array = {0};
		assertEquals(0, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_EmptyArray() {
		int[] array = {};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex_OneOneElement() {
		int[] array = {1};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test(expected=Exception.class)
	public void testGetIndex_NullInput() {
		int[] array = null;
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_BasicScenario() {
		int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		assertEquals(9, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_AllOne() {
		int[] array = {1, 1, 1, 1, 1};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_AllZero() {
		int[] array = {0, 0, 0, 0, 0};
		assertEquals(0, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_EntireArraySol() {
		int[] array = {1, 1, 0, 1, 1};
		assertEquals(2, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_MultiplePossSols() {
		int[] array = {1, 1, 0, 1, 1,0,1,1};
		assertEquals(2, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_OptimulAmoungsTwo() {
		int[] array = {1, 1, 0, 1, 1,0,1,1,1,1};
		assertEquals(5, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_ZerosFollowedByOnes() {
		int[] array = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		assertEquals(4, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_OnesFollowedByZeros() {
		int[] array = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
		assertEquals(5, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_OnesZeroElement() {
		int[] array = {0};
		assertEquals(0, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_EmptyArray() {
		int[] array = {};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test
	public void testGetIndex2_OneOneElement() {
		int[] array = {1};
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}
	
	@Test(expected=Exception.class)
	public void testGetIndex2_NullInput() {
		int[] array = null;
		assertEquals(-1, this.findIndTo0Max1Seq.getIndex(array));
	}

}
