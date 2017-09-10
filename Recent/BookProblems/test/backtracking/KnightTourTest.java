package backtracking;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class KnightTourTest {

	private KnightTour knighTour;
	
	@Before
	public void setUp() throws Exception {
		this.knighTour = new KnightTour();
	}

	@Test(timeout = 5000)
	public void testGetTour() {
		List<List<String>> ret = this.knighTour.getTour(5, 5);
		System.out.println(ret.toString());
	}
	
	@Test
	public void testgetNextMoves() {
		List<int[]> actual = this.knighTour.getNextMoves(2, 2, 5, 5);
		Set<String> actualPos = prepareSet(actual);
		int[][] expected = {{0,1},{0,3},{1,0},{1,4},{3,0},{3,4},{4,1},{4,3}};
		Set<String> expectedPos = prepareExpSet(expected);
		assertEquals(expectedPos, actualPos);
	}
	
	public Set<String> prepareSet(List<int[]> actual) {
		Set<String> ret = new HashSet<String>();
		for(int[] ele : actual) {
			ret.add(ele[0]+"#"+ele[1]);
		}
		return ret;
	}
	
	public Set<String> prepareExpSet(int[][] exp) {
		Set<String> ret = new HashSet<String>();
		for(int[] ele : exp) {
			ret.add(ele[0]+"#"+ele[1]);
		}
		return ret;
	}

}
