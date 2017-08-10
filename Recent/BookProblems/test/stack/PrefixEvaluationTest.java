package stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrefixEvaluationTest {

	private PrefixEvaluation prefixEvaluation;
	@Before
	public void setUp() throws Exception {
		this.prefixEvaluation = new PrefixEvaluation();
	}

	@After
	public void tearDown() throws Exception {
		this.prefixEvaluation = null;
	}

	@Test
	public void testGetResult_BasicScenario() {
		assertEquals(3,this.prefixEvaluation.getResult("+12"));
	}
	
	@Test
	public void testGetResult_TwoOperationSamePrece() {
		assertEquals(4, this.prefixEvaluation.getResult("-+523"));
	}
	
	@Test
	public void testGetResult_TwoOperationDiffPrece() {
		assertEquals(22, this.prefixEvaluation.getResult("*2+56"));
	}
	
	@Test
	public void testGetResult_FourOperationDiffPrece() {
		assertEquals(52, this.prefixEvaluation.getResult("*2+*23*45"));
	}
	
	@Test
	public void testGetResult_SingleLengthStr() {
		assertEquals(2, this.prefixEvaluation.getResult("2"));
	}
	
	@Test
	public void testGetResult_EmptyStr() {
		assertEquals(0, this.prefixEvaluation.getResult(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_NullStr() {
		this.prefixEvaluation.getResult(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_NoOperatorInvalidStr() {
		this.prefixEvaluation.getResult("2345");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_OnlyOperatorInvalidStr() {
		this.prefixEvaluation.getResult("+-/");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_NotValidPreOrderStr() {
		this.prefixEvaluation.getResult("+56*34");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_NotValidOperatorStr() {
		this.prefixEvaluation.getResult("++56#34");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_NotValidNumberStr() {
		this.prefixEvaluation.getResult("++56*a4");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_InorderStr() {
		this.prefixEvaluation.getResult("5+6");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetResult_postorderStr() {
		this.prefixEvaluation.getResult("56+");
	}

}
