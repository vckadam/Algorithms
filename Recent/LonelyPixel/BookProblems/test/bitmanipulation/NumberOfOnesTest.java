package bitmanipulation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bitmanipulation.NumberOfOnes;

public class NumberOfOnesTest {
	
	NumberOfOnes numberOfOnes;
	
	@Before
	public void beforeMethod() {
		this.numberOfOnes = new NumberOfOnes();
	}
	
	@After
	public void afterMethod() {
		this.numberOfOnes = null;
	}
	
	@Test
	public void getNumberOfOnesTest1() {
		int actual = this.numberOfOnes.getNumberOfOnes(1);
		assertEquals(1, actual);
	}
	
	@Test
	public void getNumberOfOnesTest2() {
		int actual = this.numberOfOnes.getNumberOfOnes(7);
		assertEquals(3, actual);
	}
	
	@Test
	public void getNumberOfOnesTest3() {
		int actual = this.numberOfOnes.getNumberOfOnes(2147483647);
		assertEquals(31, actual);
	}
}
