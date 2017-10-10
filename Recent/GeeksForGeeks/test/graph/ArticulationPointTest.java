package graph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArticulationPointTest {

	private ArticulationPoint articulationPoint;
	
	@Before
	public void setUp() {
		this.articulationPoint = new ArticulationPoint();
	}
	
	@Test
	public void testGetArticulationPoint() {
		int[][] edges = {{0,1},{1,2},{0,2},{2,3},{3,4},{4,6},{4,5},{5,6},{5,7}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(8, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>(Arrays.asList(2,3,4,5));
		assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testGetArticulationPoint_SingleLine() {
		int[][] edges = {{0,1},{1,2},{2,3}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(4, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>(Arrays.asList(1,2));
		assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testGetArticulationPoint_SingleACPoint() {
		int[][] edges = {{0,1},{1,2},{1,3}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(4, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>(Arrays.asList(1));
		assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testGetArticulationPoint_NoACPoint() {
		int[][] edges = {{0,1},{1,2},{0,2}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(3, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>();
		assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testGetArticulationPoint_GFG1() {
		int[][] edges = {{1,0},{0,2},{2,1},{0,3},{3,4}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(5, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>(Arrays.asList(0,3));
		assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testGetArticulationPoint_GFG2() {
		int[][] edges = {{1,0},{0,2},{2,1},{1,3},{1,4},{1,6},{3,5},{4,5}};
		List<Integer> actual = this.articulationPoint.getArticulationPoint(7, edges);
		Set<Integer> actualPoints = new HashSet<Integer>(actual);
		Set<Integer> expectedPoints = new HashSet<Integer>(Arrays.asList(1));
		assertEquals(expectedPoints, actualPoints);
	}

}
