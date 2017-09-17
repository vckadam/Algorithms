package graph.bfs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class shortestPathAvoidHighwayTest {

	private ShortestPathAvoidHighway shortestPathAvoidHighway;
	@Before
	public void setUp() throws Exception {
		this.shortestPathAvoidHighway = new ShortestPathAvoidHighway();
	}

	@Test
	public void testGetSortestPath_BasicScenario() {
		int[][] edges = {{0,1},{0,2},{1,2}};
		int[][] highways = {{0,2}};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(3, edges, highways, 0, 2);
		String expectedPath = "0->1->2";
		assertEquals(expectedPath, actualPath);
	}
	
	@Test
	public void testGetSortestPath_OppositeBasicScenario() {
		int[][] edges = {{0,1},{0,2},{1,2}};
		int[][] highways = {{0,1},{1,2}};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(3, edges, highways, 0, 2);
		String expectedPath = "0->2";
		assertEquals(expectedPath, actualPath);
	}

}
