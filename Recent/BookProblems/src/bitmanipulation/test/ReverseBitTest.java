package bitmanipulation.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bitmanipulation.ReverseBit;

public class ReverseBitTest {
	
	ReverseBit reverseBit;
	
	@Before
	public void beforeMethod() {
		this.reverseBit = new ReverseBit();
	}
	
	@After
	public void afterMethod() {
		this.reverseBit = null;
	}
	
	@Test
	public void getReversedBitNumberTest1() {
		int actualNumber = this.reverseBit.getReversedBitNumber(1);
		StringBuilder actual = new StringBuilder();
		for(int i = 0; i < 32; i++) {
			actual.insert(0, (actualNumber&(1<<i)) == 0 ? 0 : 1);
		}
		assertEquals("10000000000000000000000000000000", actual.toString());
	}
	
	@Test
	public void getReversedBitNumberTest2() {
		int actualNumber = this.reverseBit.getReversedBitNumber(0);
		assertEquals(0, actualNumber);
	}
	
	@Test
	public void getReversedBitNumberTest3() {
		int actualNumber = this.reverseBit.getReversedBitNumber(2);
		StringBuilder actual = new StringBuilder();
		for(int i = 0; i < 32; i++) {
			actual.insert(0, (actualNumber&(1<<i)) == 0 ? 0 : 1);
		}
		assertEquals("01000000000000000000000000000000", actual.toString());
	}
	
	@Test
	public void getReversedBitNumberTest4() {
		int actualNumber = this.reverseBit.getReversedBitNumber(7);
		StringBuilder actual = new StringBuilder();
		for(int i = 0; i < 32; i++) {
			actual.insert(0, (actualNumber&(1<<i)) == 0 ? 0 : 1);
		}
		assertEquals("11100000000000000000000000000000", actual.toString());
	}
}
