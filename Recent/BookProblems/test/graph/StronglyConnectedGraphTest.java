package graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StronglyConnectedGraphTest {

	private StronglyConnectedGraph stronglyConnectedGraph;
	
	@Before
	public void setUp() throws Exception {
		this.stronglyConnectedGraph  = new StronglyConnectedGraph();
	}

	@Test(timeout=100)
	public void testIsStronglyConnected_BasicScenario() {
		int[][] edges = {{0,1},{1,0}};
		assertTrue(this.stronglyConnectedGraph.isStronglyConnected(2, edges));
	}
	
	@Test(timeout=250)
	public void testIsStronglyConnected_ThreeVertex() {
		int[][] edges = {{0,1},{1,0},{0,2},{2,1}};
		assertTrue(this.stronglyConnectedGraph.isStronglyConnected(3, edges));
	}
	
	@Test(timeout=250)
	public void testIsStronglyConnected_ThreeVertexWithSelfCycle() {
		int[][] edges = {{0,1},{1,0},{0,2},{2,1},{2,2}};
		assertTrue(this.stronglyConnectedGraph.isStronglyConnected(3, edges));
	}
	
	@Test(timeout=250)
	public void testIsStronglyConnected_OneVertex() {
		int[][] edges = {};
		assertTrue(this.stronglyConnectedGraph.isStronglyConnected(1, edges));
	}
	
	@Test(timeout=250)
	public void testIsStronglyConnected_NegativeScenario() {
		int[][] edges = {{0,1},{1,0},{2,0},{2,1}};
		assertFalse(this.stronglyConnectedGraph.isStronglyConnected(3, edges));
	}

}
