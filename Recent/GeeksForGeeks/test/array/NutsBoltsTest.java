package array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NutsBoltsTest {

	private NutsBolts nutsBolt;
	@Before
	public void setUp() throws Exception {
		this.nutsBolt = new NutsBolts();
	}

	@After
	public void tearDown() throws Exception {
		this.nutsBolt = null;
	}

	@Test
	public void testGetArragedNuts_BasicScenario() {
		int[] bolts = {2,1,3,5,4};
		int[] nuts = {2,4,3,1,5};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test
	public void testGetArragedNuts_OneElement() {
		int[] bolts = {2};
		int[] nuts = {2};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test
	public void testGetArragedNuts_Reverse() {
		int[] bolts = {1,2,3,4,5};
		int[] nuts = {5,4,3,2,1};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test
	public void testGetArragedNuts_AlreadySorted() {
		int[] bolts = {1,2,3,4,5};
		int[] nuts = {1,2,3,4,5};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test
	public void testGetArragedNuts_Duplicate() {
		int[] bolts = {5,2,1,3,4,2};
		int[] nuts = {1,2,3,2,4,5};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetArragedNuts_NullBoltsInput() {
		int[] bolts = null;
		int[] nuts = {1,2,3,2,4,5};
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetArragedNuts_NullNutsInput() {
		int[] bolts = {1,2,3,2,4,5};
		int[] nuts = null;
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetArragedNuts_BothInputNull() {
		int[] bolts = null;
		int[] nuts = null;
		this.nutsBolt.getArragedNuts(bolts, nuts);
		assertArrayEquals(bolts,nuts);
	}

}
