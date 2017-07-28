package greedy;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import greedy.FileMerge;

public class FileMergeTest {
	
	private FileMerge fileMerge;
	
	@Before
	public void beforeMethod() {
		this.fileMerge = new FileMerge();
	}
	
	@After
	public void afterMethod() {
		this.fileMerge = null;
	}
	
	/** Minimum file merge cost exist.*/
	@Test
	public void getMinMergeCostTest1() {
		Integer[] costs = {10,5,100,50,20,15};
		long actual = this.fileMerge.getMinMergeCost(costs);
		assertEquals(200, actual);
	}
	
	/** Some costs are invalid. */
	@Test
	public void getMinMergeCostTest2() {
		Integer[] costs = {10,-5, 5, 100,50,-20, 20, 15};
		long actual = this.fileMerge.getMinMergeCost(costs);
		assertEquals(200, actual);
	}
	
	/** Some costs are invalid. */
	@Test
	public void getMinMergeCostTest4() {
		Integer[] costs = {10,null, 5, 100,50,null, 20, 15};
		long actual = this.fileMerge.getMinMergeCost(costs);
		assertEquals(200, actual);
	}
	
	/** Input is null.*/
	@Test
	public void getMinMergeCostTest3() {
		Integer[] costs = null;
		long actual = this.fileMerge.getMinMergeCost(costs);
		assertEquals(0, actual);
	}
	
	/** Input contains large values.*/
	@Test
	public void getMinMergeCostTest5() {
		final long expected = 8589934588L;
		Integer[] costs = {2147483647, 2147483647, 2147483647, 2147483647};
		long actual = this.fileMerge.getMinMergeCost(costs);
		assertEquals(expected, actual);
	}
}
