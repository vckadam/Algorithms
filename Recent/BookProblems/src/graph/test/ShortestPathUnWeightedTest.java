package graph.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.ShortestPathUnweighted;

public class ShortestPathUnWeightedTest {
	
	ShortestPathUnweighted shortedPathUnweighted;
	
	@Before
	public void beforeMethod() {
		this.shortedPathUnweighted = new ShortestPathUnweighted();
	}
	
	@After
	public void afterMethod() {
		this.shortedPathUnweighted = null;
	}
	
	@Test
	public void getShortestPathTest1() {
		char[][] edges = {{'A','B'},{'A','D'},{'B','D'},{'B','E'},{'C','A'},{'D','F'},{'D','G'},{'E','G'},{'G','F'}};
		List<Object> actual = this.shortedPathUnweighted.getShortestPath('A', edges, 7);
		int[] actualDistance = (int[])actual.get(0);
		int[] expectedDistance = {0,1,-1,1,2,2,2};
		Assert.assertArrayEquals(expectedDistance, actualDistance);
	}
}
