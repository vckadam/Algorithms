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
		assertEquals(expectedPath, actualPath) ;
	}
	
	@Test
	public void testGetSortestPath_GraphWithCyclesNoHighWays() {
		int[][] edges = {{0,1},{0,2},{1,2},{2,3},{2,4},{2,9},{3,5},{4,5},{4,7},{5,6},{5,7},{6,8},{7,8},{8,9}};
		int[][] highways = {};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(10, edges, highways, 0, 9);
		String expectedPath = "0->2->9";
		assertEquals(expectedPath, actualPath);
	}
	
	@Test
	public void testGetSortestPath_GraphWithCyclesOneHighWays() {
		int[][] edges = {{0,1},{0,2},{1,2},{2,3},{2,4},{2,9},{3,5},{4,5},{4,7},{5,6},{5,7},{6,8},{7,8},{8,9}};
		int[][] highways = {{2,9}};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(10, edges, highways, 0, 9);
		String expectedPath = "0->2->4->7->8->9";
		assertEquals(expectedPath, actualPath);
	}
	
	@Test
	public void testGetSortestPath_GraphWithCyclesTwoHighWays() {
		int[][] edges = {{0,1},{0,2},{1,2},{2,3},{2,4},{2,9},{3,5},{4,5},{4,7},{5,6},{5,7},{6,8},{7,8},{8,9}};
		int[][] highways = {{2,9},{4,7}};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(10, edges, highways, 0, 9);
		String expectedPath = "0->2->3->5->6->8->9";
		assertEquals(expectedPath, actualPath);
	}
	
	@Test
	public void testGetSortestPath_NoPathExist() {
		int[][] edges = {{0,1},{0,2},{1,2},{2,3},{2,4},{2,9},{3,5},{4,5},{4,7},{5,6},{5,7},{6,8},{7,8},{8,9}};
		int[][] highways = {{2,9},{4,7},{8,9}};
		String actualPath = this.shortestPathAvoidHighway.getSortestPath(10, edges, highways, 0, 9);
		String expectedPath = null;
		assertEquals(expectedPath, actualPath);
	}

}
