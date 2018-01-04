package graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MotherVertexTest {

	private MotherVertex motherVertex;
	
	@Before
	public void setUp() {
		this.motherVertex = new MotherVertex();
	}
	
	@After
	public void tearDown() {
		this.motherVertex = null;
	}
	
	@Test
	public void testBasicScenario() {
		int[][] edges = {{0,1},{1,4},{0,2},{2,3},{3,6},{0,5}};
		assertEquals(0, this.motherVertex.getMotherVertex(7, edges));
	}

}
