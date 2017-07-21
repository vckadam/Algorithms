package graph.test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.TopologicalSort;

public class TopologicalSortTest {
	
	TopologicalSort topologicalSort;
	
	@Before
	public void beforeMethod() {
		this.topologicalSort = new TopologicalSort();
	}
	
	@After
	public void afterMethod() {
		this.topologicalSort = null;
	}
	
	/** Topological order exist. No cycle in Graph.*/
	@Test
	public void getTopologicalSortTest1() {
		int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
		List<Integer> order = this.topologicalSort.getTopologicalSort(8, edges);
		Map<Integer,Integer> actualOrder = new HashMap<Integer,Integer>();
		for(int i = 0; i < order.size(); i++) {
			actualOrder.put(i, order.get(i));
		}
		for(int[] edge : edges) {
			if(actualOrder.get(edge[0]) > actualOrder.get(edge[1])) fail("Order is not correct");
		}
	}
	
	/** Topological order doesn't exist. Cycle in Graph.*/
	@Test
	public void getTopologicalSortTest2() {
		int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6},{3,4},{4,1}};
		List<Integer> order = this.topologicalSort.getTopologicalSort(8, edges);
		assertEquals(null, order);
	}
	
	/** Topological order exist. No edge in Graph.*/
	@Test
	public void getTopologicalSortTest3() {
		int[][] edges = new int[0][0];
		List<Integer> order = this.topologicalSort.getTopologicalSort(8, edges);
		Map<Integer,Integer> actualOrder = new HashMap<Integer,Integer>();
		for(int i = 0; i < order.size(); i++) {
			actualOrder.put(i, order.get(i));
		}
		for(int[] edge : edges) {
			if(actualOrder.get(edge[0]) > actualOrder.get(edge[1])) fail("Order is not correct");
		}
	}
	
	/** Topological order exist. No cycle in Graph.*/
	@Test
	public void getTopologicalSortTest4() {
		int[][] edges = {{0,1},{0,2},{1,2},{1,3},{1,4},{3,2},{3,4},{2,4}};
		List<Integer> order = this.topologicalSort.getTopologicalSort(5, edges);
		Map<Integer,Integer> actualOrder = new HashMap<Integer,Integer>();
		for(int i = 0; i < order.size(); i++) {
			actualOrder.put(i, order.get(i));
		}
		for(int[] edge : edges) {
			if(actualOrder.get(edge[0]) > actualOrder.get(edge[1])) fail("Order is not correct");
		}
	}
}
