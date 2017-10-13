package backtracking;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstColoumToLastTest {

	private FirstColoumToLast firstColoumToLast; 
	
	@Before
	public void setUp() {
		this.firstColoumToLast = new FirstColoumToLast();
	}
	
	@After
	public void tearDown() {
		this.firstColoumToLast = null;
	}
	
	@Test
	public void testGetShortedPath_NoObstacles() {
		int[][] grid = {{1,1,1,1}, {1,1,1,1}};
		assertEquals(3, this.firstColoumToLast.getShortedPath(grid));
	}
	
	@Test
	public void testGetShortedPath_WithObstacles() {
		int[][] grid = {{1,1,1,1,0,1,1}, {1,1,1,1,1,1,1}, {0,1,1,1,1,1,1}, {1,1,1,1,1,1,1},{1,1,1,1,0,1,1}};
		assertEquals(8, this.firstColoumToLast.getShortedPath(grid));
	}
	
	@Test
	public void testGetShortedPath_WithObstaclesAvoidNeighbours() {
		int[][] grid = {{1,1,0,1}, {0,1,1,1}, {1,1,0,1}};
		assertEquals(-1, this.firstColoumToLast.getShortedPath(grid));
	}
	
	

}
