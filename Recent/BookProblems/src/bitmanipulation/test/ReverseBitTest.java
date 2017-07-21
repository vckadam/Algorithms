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
		assertEquals(-2147483648, actualNumber);
	}
}
