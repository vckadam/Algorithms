package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HamiltonianCycleTest {

	private HamiltonianCycle hamiltonianCycle;
	
	@Before
	public void setUp() throws Exception {
		this.hamiltonianCycle = new HamiltonianCycle();
	}

	@After
	public void tearDown() throws Exception {
		this.hamiltonianCycle = null;
	}

	@Test
	public void testContainCycle_PositiveScenario() {
		int[][] edges = {{0,1},{1,2},{2,0}};
		assertTrue(this.hamiltonianCycle.containCycle(3, edges));
	}
	
	@Test
	public void testContainCycle_NegativeScenario() {
		int[][] edges = {{0,1},{1,2},{2,1}};
		assertFalse(this.hamiltonianCycle.containCycle(3, edges));
	}
	
	@Test
	public void testContainCycle_NullInput() {
		int[][] edges = null;
		assertFalse(this.hamiltonianCycle.containCycle(3, edges));
	}

	@Test
	public void testContainCycle_NullEdges() {
		int[][] edges = {{0,1},{1,2},null,null,{2,0},null};
		assertTrue(this.hamiltonianCycle.containCycle(3, edges));
	}
	
	@Test
	public void testContainCycle_DuplicateEdges() {
		int[][] edges = {{0,1},{1,2},null,null,{2,0},null,{2,0},null};
		assertTrue(this.hamiltonianCycle.containCycle(3, edges));
	}
	
	@Test
	public void testContainCycle_ReverseDuplicateEdges() {
		int[][] edges = {{0,1},{1,2},null,null,{2,0},null,{2,0},null,{1,0},{2,1}};
		assertTrue(this.hamiltonianCycle.containCycle(3, edges));
	}
	
	@Test
	public void testContainCycle_MultipleCycles() {
		int[][] edges = {{0,1},{1,2},null,null,{2,3},{3,0},{2,4},{4,0},null,{2,0},null,{1,0},{2,1}};
		assertTrue(this.hamiltonianCycle.containCycle(4, edges));
	}
	
	@Test
	public void testContainCycle_SelfLoop() {
		int[][] edges = {{0,0}};
		assertTrue(this.hamiltonianCycle.containCycle(1, edges));
	}
	
	@Test
	public void testContainCycle_OneEdgeNoCycle() {
		int[][] edges = {{0,1}};
		assertTrue(this.hamiltonianCycle.containCycle(2, edges));
	}
	
	@Test
	public void testContainCycle_MissingOneEdgeForCycle() {
		int[][] edges = {{0,1},{1,2}};
		assertFalse(this.hamiltonianCycle.containCycle(3, edges));
	}
	
}
