package point;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KNearestNeighbourTest {

	private KNearestNeighbour kNearestNeighbour;
	@Before
	public void setUp() throws Exception {
		this.kNearestNeighbour = new KNearestNeighbour();
	}

	@After
	public void tearDown() throws Exception {
		this.kNearestNeighbour = null;
	}

	@Test
	public void testGetNeighbourForOrigin_PositiveScenario() {
		int[][] pointA = {{1,1},{2,2},{3,3},{4,4},{5,5}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 2);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{1,1},{2,2}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetNeighbourForOrigin_NullInput() {
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(null, 2);
		assertEquals(0, actualPoints.length);
		
	}
	
	@Test
	public void testGetNeighbourForOrigin_NullPoint() {
		int[][] pointA = {null,{2,2},{3,3},{4,4},{5,5}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 1);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{2,2}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetNeighbourForOrigin_DuplicatePoints() {
		int[][] pointA = {{1,1},{2,2},{1,1},{1,1},{1,1}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 2);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{1,1},{2,2}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetNeighbourForOrigin_OriginPoint() {
		int[][] pointA = {{1,1},{2,2},null,{0,0},{1,1}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 2);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{1,1},{2,2}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetNeighbourForOrigin_NegativeK() {
		int[][] pointA = {{1,1},{2,2},null,{0,0},{1,1}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, -2);
		assertEquals(0, actualPoints.length);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetNeighbourForOrigin_ZeroK() {
		int[][] pointA = {{1,1},{2,2},null,{0,0},{1,1}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 0);
		assertEquals(0, actualPoints.length);
		
	}
	
	
	@Test
	public void testGetNeighbourForOrigin_KGraterThanArrayLength() {
		int[][] pointA = {{1,1},{2,2},{3,3},{4,4},{5,5}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 20);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{1,1},{2,2},{3,3},{4,4},{5,5}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetNeighbourForOrigin_MultipleQuadrants() {
		int[][] pointA = {{-1,-1},{-2,-2},{-3,-3},{1,1},{2,2}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 2);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{-1,-1},{1,1}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetNeighbourForOrigin_LargeIntegerVal() {
		int[][] pointA = {{-1,-1},{-2,-2},{-3,-3},{2147483647,2147483647},{-2147483648,-2147483648}};
		Point[] points = prepareArray_testGetNeighbourForOrigin(pointA);
		Point[] actualPoints = this.kNearestNeighbour.getNeighbourForOrigin(points, 2);
		List<String> actual = prepareList_testGetNeighbourForOrigin(actualPoints);
		
		int[][] expectedPointA = {{-1,-1},{-2,-2}};
		Point[] expectedPoints = prepareArray_testGetNeighbourForOrigin(expectedPointA);
		List<String> expected = prepareList_testGetNeighbourForOrigin(expectedPoints);
		
		assertEquals(expected, actual);
		
	}
	
	private Point[] prepareArray_testGetNeighbourForOrigin(int[][] pointA) {
		Point[] point = new Point[pointA.length];
		for(int i = 0; i < point.length; i++) {
			if(pointA[i] != null) point[i] = new Point(pointA[i][0], pointA[i][1]);
		}
		return point;
	}
	
	private List<String> prepareList_testGetNeighbourForOrigin(Point[] points) {
		List<String> list = new ArrayList<String>();
		for(Point point : points) {
			list.add(point.toString());
		}
		return list;
	}

}
