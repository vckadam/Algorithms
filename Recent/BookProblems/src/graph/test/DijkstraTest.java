package graph.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.Dijkstra;

public class DijkstraTest {
	
	Dijkstra dijstra;
	
	@Before
	public void beforeMethod() {
		this.dijstra = new Dijkstra();
	}
	
	@After
	public void afterMethod() {
		this.dijstra = null;
	}
	
	@Test
	public void shortestPathTest() {
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		List<Integer> edge1 = new ArrayList<Integer>(Arrays.asList(0,1,4));
		List<Integer> edge2 = new ArrayList<Integer>(Arrays.asList(0,2,1));
		List<Integer> edge3 = new ArrayList<Integer>(Arrays.asList(2,1,2));
		List<Integer> edge4 = new ArrayList<Integer>(Arrays.asList(2,3,4));
		List<Integer> edge5 = new ArrayList<Integer>(Arrays.asList(1,4,4));
		List<Integer> edge6 = new ArrayList<Integer>(Arrays.asList(3,4,4));
		edges.add(edge6); edges.add(edge5); edges.add(edge4); edges.add(edge3);
		edges.add(edge2); edges.add(edge1);
		List<Object> actual = this.dijstra.shortestPath(5, edges, 0);
		int[] actualDist = (int[])actual.get(0);
		int[] actualPar = (int[])actual.get(1);
		int[] expectedDist = {0,3,1,5,7};
		int[] expectedPar = {0, 2, 0, 2, 1};
		Assert.assertArrayEquals(expectedDist, actualDist);
		Assert.assertArrayEquals(expectedPar, actualPar);
	}
}
