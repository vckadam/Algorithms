package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinElementInCircularTest {

	private MinElementInCircular minElementInCircular;
	@Before
	public void setUp() throws Exception {
		this.minElementInCircular = new MinElementInCircular();
	}

	@After
	public void tearDown() throws Exception {
		this.minElementInCircular = null;
	}

	@Test(timeout = 100)
	public void testGetMinElement_EvenEleFirstPos() {
		int[] array = {1,2,3,4};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_EvenEleLastPos() {
		int[] array = {2,3,4,1};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_EvenEleThirdPos() {
		int[] array = {3,4,1,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_EvenEleSecondPos() {
		int[] array = {4,1,2,3};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}

	@Test(timeout = 100)
	public void testGetMinElement_OddEleFirstPos() {
		int[] array = {1,2,3};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_OddEleLastPos() {
		int[] array = {2,3,1};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_OddEleSecPos() {
		int[] array = {3,1,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupOddEleFirstPos() {
		int[] array = {1,2,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupOddEleLastPos() {
		int[] array = {2,2,1};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupOddEleSecPos() {
		int[] array = {2,1,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupEvenEleFirstPos() {
		int[] array = {1,2,2,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupEvenEleLastPos() {
		int[] array = {2,2,2,1};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupEvenEleThirdPos() {
		int[] array = {2,2,1,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_DupEvenEleSecPos() {
		int[] array = {2,1,2,2};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(timeout = 100)
	public void testGetMinElement_SingleElement() {
		int[] array = {1};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElement_EmptyArray() {
		int[] array = {};
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElement_NullArray() {
		int[] array = null;
		assertEquals(1, this.minElementInCircular.getMinElement(array));
	}
}
