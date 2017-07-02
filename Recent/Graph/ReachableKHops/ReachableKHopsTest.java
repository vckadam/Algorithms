package ReachableKHops;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ReachableKHopsTest {
	ReachableKHops tp;
	
	@Before
	public void beforeTest() {
		tp = new ReachableKHops();
	}
	
	@After
	public void afterTest() {
		tp = null;
	}
	/** Reachable in K steps without duplicate elements in grid. **/
	@Test
	public void isReachableTest() {
		char[][] grid = {{'1','2','3','4','5','6'},
				         {'7','8','9','a','b','c'},
				         {'d','e','f','g','h','i'},
				         {'j','k','l','m','n','o'},
				         {'p','q','r','s','t','u'},
				         {'v','w','x','y','z','.'}};
		assertTrue(tp.isReachable(grid, '9', 3));	
	}
	
	/** Character is not present in grid.**/
	@Test
	public void isReachableTest1() {
		char[][] grid = {{'1','2','3','4','5','6'},
		         		 {'7','8','9','a','b','c'},
		                 {'d','e','f','g','h','i'},
		                 {'j','k','l','m','n','o'},
		                 {'p','q','r','s','t','u'},
		                 {'v','w','x','y','z','.'}};
		assertFalse(tp.isReachable(grid, ',', 3));	
	}
	
	/** Character is present in grid, but unreachable.**/
	@Test
	public void isReachableTest2() {
		char[][] grid = {{'1','2','3','4','5','6'},
		        		 {'7','8','9','a','b','c'},
		                 {'d','e','f','g','h','i'},
		                 {'j','k','l','m','n','o'},
		                 {'p','q','r','s','t','u'},
		                 {'v','w','x','y','z','.'}};
		assertFalse(tp.isReachable(grid, '.', 3));	
	}
	/** Reachable in K steps with duplicate elements in grid. **/
	@Test
	public void isReachableTest3() {
		char[][] grid = {{'1','2','3','4','5','6'},
				         {'7','8','2','a','b','c'},
				         {'d','e','f','g','h','i'},
				         {'j','k','l','m','n','o'},
				         {'p','q','r','s','t','u'},
				         {'v','w','x','y','z','.'}};
		assertTrue(tp.isReachable(grid, '2', 3));	
	}
	
	/** Not Reachable elements in grid with High value of K. **/
	@Test
	public void isReachableTest4() {
		char[][] grid = {{'1','2','3','4','5','6'},
				         {'7','8','2','a','b','c'},
				         {'d','e','f','g','h','i'},
				         {'j','k','l','m','n','o'},
				         {'p','q','r','s','t','u'},
				         {'v','w','x','y','z','.'}};
		assertFalse(tp.isReachable(grid, ',', 300));
	}
	
	/** Reachable with 0 hops. **/
	@Test
	public void isReachableTest5() {
		char[][] grid = {{'1','2','3','4','5','6'},
				         {'7','8','2','a','b','c'},
				         {'d','e','f','g','h','i'},
				         {'j','k','l','m','n','o'},
				         {'p','q','r','s','t','u'},
				         {'v','w','x','y','z','.'}};
		assertTrue(tp.isReachable(grid, '1', 0));
	}
}
