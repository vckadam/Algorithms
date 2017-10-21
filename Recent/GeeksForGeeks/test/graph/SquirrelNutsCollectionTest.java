package graph;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquirrelNutsCollectionTest {

	private SquirrelNutsCollection squirrelNutsCollection;
	
	@Before
	public void setUp() {
		this.squirrelNutsCollection = new SquirrelNutsCollection();
	}
	
	@After
	public void tearDown() {
		this.squirrelNutsCollection = null;
	}
	
	@Test
	public void testGetNumberOfSteps_BasicScenario() {
		int[][] nutLocs = {{0,4},{2,4},{2,0},{4,1},{4,3}};
		Assert.assertEquals(28, this.squirrelNutsCollection.getNumberOfSteps(5, 5, 0, 0, 2, 2, nutLocs));
	}
	
	@Test
	public void testGetNumberOfSteps_StartAndTreeSamePos() {
		int[][] nutLocs = {{0,4},{2,0},{4,3}};
		Assert.assertEquals(26, this.squirrelNutsCollection.getNumberOfSteps(5, 5, 0, 0, 0, 0, nutLocs));
	}
	
	@Test
	public void testGetNumberOfSteps_StartAndTreeSamePosWithNut() {
		int[][] nutLocs = {{0,4},{2,0},{4,3},{0,0}};
		Assert.assertEquals(26, this.squirrelNutsCollection.getNumberOfSteps(5, 5, 0, 0, 0, 0, nutLocs));
	}
	
	@Test
	public void testGetNumberOfSteps_StartLocWithNut() {
		int[][] nutLocs = {{0,0}, {1,4}, {2,2}, {3,2} };
		Assert.assertEquals(14, this.squirrelNutsCollection.getNumberOfSteps(5, 5, 3, 2, 1, 2, nutLocs));
	}
	
	@Test
	public void testGetNumberOfSteps_StartAndTreeLocWithNut() {
		int[][] nutLocs = {{0,0}, {1,4}, {2,2}, {3,2}, {1,2} };
		Assert.assertEquals(14, this.squirrelNutsCollection.getNumberOfSteps(5, 5, 3, 2, 1, 2, nutLocs));
	}

}
