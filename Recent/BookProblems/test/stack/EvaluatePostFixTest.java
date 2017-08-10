package stack;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvaluatePostFixTest {
	
	/* 
	 * 56+
	 * 3 + 2 + 3  - 3 2 + 3 +
	 * 4 + 3 * 2 + 5 - 4 3 2 * + 5 +
	 * 3 * 2 + 2 = 3 2 * 2 +
	 * 3 * 3 + 4 * 4 = 3 3 * 4 4 * +
	 * 
	 * */
	private EvaluatePostFix evaluatePostFix;
	
	@Before
	public void setUp() throws Exception {
		this.evaluatePostFix = new EvaluatePostFix();
	}

	@After
	public void tearDown() throws Exception {
		this.evaluatePostFix = null;
	}

	@Test
	public void testGetEvaluation() {
		assertEquals(11,this.evaluatePostFix.getEvaluation("56+"));
	}

}
