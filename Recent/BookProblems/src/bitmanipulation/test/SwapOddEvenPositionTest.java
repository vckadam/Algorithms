package bitmanipulation.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bitmanipulation.SwapOddEvenPosition;

public class SwapOddEvenPositionTest {

	SwapOddEvenPosition swapOddEvenPosition;
	
	@Before
	public void beforeMethod() {
		this.swapOddEvenPosition = new SwapOddEvenPosition();
	}
	
	@After
	public void afterMethod() {
		this.swapOddEvenPosition = null;
	}
	
	@Test
	public void changePositionTest1() {
		int number = this.swapOddEvenPosition.changePosition(54);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 32; i++) {
			sb.insert(0, (number & (1 << i)) == 0 ? 0 : 1);
		}
		assertEquals("00000000000000000000000000111001", sb.toString());
	}
	
	@Test
	public void changePositionTest2() {
		int number = this.swapOddEvenPosition.changePosition(9);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 32; i++) {
			sb.insert(0, (number & (1 << i)) == 0 ? 0 : 1);
		}
		assertEquals("00000000000000000000000000000110", sb.toString());
	}
	
	@Test
	public void changePositionTest3() {
		int number = this.swapOddEvenPosition.changePosition(0);
		assertEquals(0, number);
	}
}
