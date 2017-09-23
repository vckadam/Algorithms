package graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LongestPathGridTest {

	private LongestPathGrid longestPathGrid;
	@Before
	public void setUp() throws Exception {
		this.longestPathGrid = new LongestPathGrid();
	}

	@Test
	public void testGetLongestPath_BasicScenario() {
		char[][] grid = {{'a','d'},{'c','b'}};
		assertEquals(2, this.longestPathGrid.getLongestPath(grid, 'a', 'b'));
	}

	@Test
	public void testGetLongestPath_DiffRowAndCol() {
		char[][] grid = {{'a','d'},{'c','b'},{'e','f'}};
		assertEquals(4, this.longestPathGrid.getLongestPath(grid, 'a', 'e'));
	}
	
	@Test
	public void testGetLongestPath_DuplicateEnd() {
		char[][] grid = {{'a','d'},{'c','b'},{'e','e'}};
		assertEquals(4, this.longestPathGrid.getLongestPath(grid, 'a', 'e'));
	}
}
