package UndirectedGraphCycle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UndirectedGraphCycleTest {
	UndirectedGraphCycle tp;
	
	@Before
	public void beforeTest() {
		tp = new UndirectedGraphCycle();
	}
	
	@After
	public void afterTest() {
		tp = null;
	}
	/** Graph without cycle.**/
	@Test
	public void containCycleTest() {
		int[][] edges = {{1,2},{1,3},{2,6},{2,7},{3,4},{3,5},{4,8},{5,0}};
		assertFalse(tp.containCycle(9, edges));	
	}
	
	/** Graph with cycle.**/
	@Test
	public void containCycleTest1() {
		int[][] edges = {{1,2},{1,3},{2,6},{2,7},{3,4},{3,5},{4,8},{5,0},{7,8}};
		assertTrue(tp.containCycle(9, edges));	
	}
	
	/** Graph without cycle, but duplicate edge.**/
	@Test
	public void containCycleTest2() {
		int[][] edges = {{1,2},{1,3},{2,6},{2,7},{3,4},{3,5},{4,8},{5,0},{5,0}};
		assertFalse(tp.containCycle(9, edges));	
	}
	
	/** Graph with cycle on single node.**/
	@Test
	public void containCycleTest3() {
		int[][] edges = {{1,2},{1,3},{2,6},{2,7},{3,4},{3,5},{4,8},{5,0},{7,8},{7,7}};
		assertTrue(tp.containCycle(9, edges));	
	}
}
