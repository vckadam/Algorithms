package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BellmanFordTest {

	BellmanFord bellmanFord;
	@Before
	public void setUp() throws Exception {
		this.bellmanFord = new BellmanFord();
	}

	@After
	public void tearDown() throws Exception {
		this.bellmanFord = null;
	}

	@Test
	public void testGetShortestDistance() {
		int[][] edges = {{0,1,4},{0,3,8},{0,2,5},{1,2,-3},{2,4,4},{4,3,1},{3,4,2}};
		int[] actual = this.bellmanFord.getShortestDistance(5, edges);
		int[] expected = {0,4,1,6,5};
		assertArrayEquals(expected, actual);
	}

}
