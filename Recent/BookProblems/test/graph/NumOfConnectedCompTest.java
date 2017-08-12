package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumOfConnectedCompTest {

	private NumOfConnectedComp numOfConnectedComp;
	
	@Before
	public void setUp() throws Exception {
		this.numOfConnectedComp = new NumOfConnectedComp();
	}
	
	@After
	public void tearDown() throws Exception {
		this.numOfConnectedComp = null;
	}

	@Test
	public void testGetConnectedComponents_BasicScenario() {
		int[][] edges = {{0,1},{1,2},{3,4}};
		assertEquals(2, this.numOfConnectedComp.getConnectedComponents(5, edges));
	}
	
	@Test
	public void testGetConnectedComponents_ConnectedGraph() {
		int[][] edges = {{0,1},{1,2},{3,4},{2,3}};
		assertEquals(1, this.numOfConnectedComp.getConnectedComponents(5, edges));
	}
	
	@Test
	public void testGetConnectedComponents_CompleteGraph() {
		int[][] edges = {{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,4},{3,4},{2,3}};
		assertEquals(1, this.numOfConnectedComp.getConnectedComponents(5, edges));
	}
	
	@Test
	public void testGetConnectedComponents_WithoutEdges() {
		int[][] edges = {};
		assertEquals(5, this.numOfConnectedComp.getConnectedComponents(5, edges));
	}

	@Test
	public void testGetConnectedComponents_DuplicateEdge() {
		int[][] edges = {{0,1},{1,2},{3,4},{3,4},{1,2}};
		assertEquals(2, this.numOfConnectedComp.getConnectedComponents(5, edges));
	}
}
