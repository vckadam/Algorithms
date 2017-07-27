package graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.PrimMST;

public class PrimMSTTest {
	
	private PrimMST prim;
	
	@Before
	public void beforeMethod() {
		this.prim = new PrimMST();
	}
	
	@After
	public void afterMethod() {
		this.prim = null;
	}
	
	/** Graph is Connected. MST exist.*/
	@Test
	public void getMSTTest() {
		List<List<Object>> edges = new ArrayList<List<Object>>();
		List<Object> edge1 = new ArrayList<Object>(); edge1.add('A'); edge1.add('C'); edge1.add(1);
		List<Object> edge2 = new ArrayList<Object>(); edge2.add('A'); edge2.add('B'); edge2.add(4);
		List<Object> edge3 = new ArrayList<Object>(); edge3.add('C'); edge3.add('B'); edge3.add(2);
		List<Object> edge4 = new ArrayList<Object>(); edge4.add('C'); edge4.add('D'); edge4.add(4);
		List<Object> edge5 = new ArrayList<Object>(); edge5.add('B'); edge5.add('D'); edge5.add(1);
		List<Object> edge6 = new ArrayList<Object>(); edge6.add('B'); edge6.add('E'); edge6.add(4);
		List<Object> edge7 = new ArrayList<Object>(); edge7.add('D'); edge7.add('E'); edge7.add(3);
		edges.add(edge7); edges.add(edge6); edges.add(edge5); edges.add(edge4);
		edges.add(edge3); edges.add(edge1); edges.add(edge2);
		
		List<String> actualEdges = this.prim.getMST(5, edges);
		
		Set<String> expectedSet = new HashSet<String>(Arrays.asList("AC","BC","BD","DE"));
		
		//System.out.println(actualEdges.toString());
		assertEquals(expectedSet.size(), actualEdges.size());
		
		
		for(String edge : actualEdges) {
			if(expectedSet.contains(edge)) continue;
			if(expectedSet.contains(new StringBuilder(edge).reverse().toString())) continue;
			fail("wrong edge"+edge);
		}
	}
	
	/** Graph is not connected. MST doesn't exist.*/
	@Test
	public void getMSTTest2() {
		List<List<Object>> edges = new ArrayList<List<Object>>();
		List<Object> edge1 = new ArrayList<Object>(); edge1.add('A'); edge1.add('C'); edge1.add(1);
		edges.add(edge1);
		assertEquals(null, this.prim.getMST(3, edges));
	}
}
