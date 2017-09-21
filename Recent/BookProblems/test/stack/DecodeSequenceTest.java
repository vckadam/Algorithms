package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecodeSequenceTest {

	private DecodeSequence decodeSequence;
	@Before
	public void setUp() throws Exception {
		this.decodeSequence = new DecodeSequence();
	}

	@Test
	public void testGetDecodeSequence_AllCharacters() {
		assertEquals(125437698, this.decodeSequence.getDecodeSequence("IIDDIDID"));
	}
	
	@Test
	public void testGetDecodeSequence_RandomCharacters() {
		assertEquals(1325467, this.decodeSequence.getDecodeSequence("IDIDII"));
	}
	
	@Test
	public void testGetDecodeSequence_AllDecreasing() {
		assertEquals(54321, this.decodeSequence.getDecodeSequence("DDDD"));
	}

	@Test
	public void testGetDecodeSequence_AllIncreasing() {
		assertEquals(12345, this.decodeSequence.getDecodeSequence("IIII"));
	}
}
