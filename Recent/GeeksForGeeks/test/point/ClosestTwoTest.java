package point;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClosestTwoTest {

	private ClosestTwo closestTwo;
	@Before
	public void setUp() throws Exception {
		this.closestTwo = new ClosestTwo();
	}

	@After
	public void tearDown() throws Exception {
		this.closestTwo = null;
	}

	@Test
	public void testGetTwoClosest_PositiveScenario_EvenLength() {
		int[][] points = {{2,3}, {12,30}, {40,50}, {5,1}, {12,10},{3,4}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint = {{2,3},{3,4}};
		Point[] expectedMinPoints = preparePoints_testGetTwoClosest(resultPoint);
		Set<String> expected = prepareSet_testGetTwoClosest(expectedMinPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetTwoClosest_PositiveScenario_OddLength() {
		int[][] points = {{2,3}, {12,30}, {40,50}, {5,1},{3,4}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint = {{2,3},{3,4}};
		Point[] expectedMinPoints = preparePoints_testGetTwoClosest(resultPoint);
		Set<String> expected = prepareSet_testGetTwoClosest(expectedMinPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetTwoClosest_DuplicatePoints() {
		int[][] points = {{2,3}, {12,30}, {40,50}, {5,1}, {12,10},{3,4}, {2,3}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint = {{2,3},{3,4}};
		Point[] expectedMinPoints = preparePoints_testGetTwoClosest(resultPoint);
		Set<String> expected = prepareSet_testGetTwoClosest(expectedMinPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetTwoClosest_NullPoints() {
		int[][] points = {{2,3}, {12,30}, null, {5,1}, {12,10},{3,4}, {2,3}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint = {{2,3},{3,4}};
		Point[] expectedMinPoints = preparePoints_testGetTwoClosest(resultPoint);
		Set<String> expected = prepareSet_testGetTwoClosest(expectedMinPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetTwoClosest_NullInput() {
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(null);
		assertEquals(0,actualMinPoint.length);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetTwoClosest_SinglePoint() {
		int[][] points = {{1,1}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		assertEquals(0,actualMinPoint.length);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetTwoClosest_DuplicateTwoPoints() {
		int[][] points = {{1,1},{1,1}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		assertEquals(0,actualMinPoint.length);
	}
	
	@Test
	public void testGetTwoClosest_TwoPoints() {
		int[][] points = {{2,3},{3,4}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint = {{2,3},{3,4}};
		Point[] expectedMinPoints = preparePoints_testGetTwoClosest(resultPoint);
		Set<String> expected = prepareSet_testGetTwoClosest(expectedMinPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetTwoClosest_MultipleResults() {
		int[][] points = {{1,1},{2,2},{3,3},{4,4},{2,30}, {12,30}, null, {50,1}, {12,10},{2,30}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint1 = {{1,1},{2,2}};
		Point[] expectedMinPoints1 = preparePoints_testGetTwoClosest(resultPoint1);
		Set<String> expected1 = prepareSet_testGetTwoClosest(expectedMinPoints1);
		
		int[][] resultPoint2 = {{3,3},{4,4}};
		Point[] expectedMinPoints2 = preparePoints_testGetTwoClosest(resultPoint2);
		Set<String> expected2 = prepareSet_testGetTwoClosest(expectedMinPoints2);
		
		Assert.assertTrue(expected1.equals(actual) || expected2.equals(actual));
		
	}
	
	@Test
	public void testGetTwoClosest_LargeIntegerValues() {
		int[][] points = {{1,1},{2,2},{3,3},{4,4},{2,30}, null, null, null, null, {12,30}, null, {1,1}, {2147483647,2147483647},{-2147483648,-2147483648}};
		Point[] actualPoints = preparePoints_testGetTwoClosest(points);
		Point[] actualMinPoint = this.closestTwo.getTwoClosest(actualPoints);
		Set<String> actual = prepareSet_testGetTwoClosest(actualMinPoint);
		
		int[][] resultPoint1 = {{1,1},{2,2}};
		Point[] expectedMinPoints1 = preparePoints_testGetTwoClosest(resultPoint1);
		Set<String> expected1 = prepareSet_testGetTwoClosest(expectedMinPoints1);
		
		int[][] resultPoint2 = {{3,3},{4,4}};
		Point[] expectedMinPoints2 = preparePoints_testGetTwoClosest(resultPoint2);
		Set<String> expected2 = prepareSet_testGetTwoClosest(expectedMinPoints2);
		
		Assert.assertTrue(expected1.equals(actual) || expected2.equals(actual));
		
	}
	
	private Point[] preparePoints_testGetTwoClosest(int[][] ptrA) {
		Point[] points = new Point[ptrA.length];
		for(int i = 0; i < ptrA.length; i++) {
			if(ptrA[i] != null) points[i] = new Point(ptrA[i][0], ptrA[i][1]);
		}
		return points;
	}
	
	private Set<String> prepareSet_testGetTwoClosest(Point[] points) {
		Set<String> set = new HashSet<String>();
		for(Point point : points) {
			set.add(point.toString());
		}
		return set;
	}

}
