package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TernaryExpressionParserTest {

	private TernaryExpressionParser ternaryExpressionParser;
	@Before
	public void setUp() throws Exception {
		this.ternaryExpressionParser = new TernaryExpressionParser();
	}

	@Test
	public void testEvaluate_BasicScenario() {
		assertEquals('2', this.ternaryExpressionParser.evaluate("T?2:3"));
	}

	@Test
	public void testEvaluate_NestedInSecond() {
		assertEquals('4', this.ternaryExpressionParser.evaluate("F?1:T?4:5"));
	}

	@Test
	public void testEvaluate_NestedInFirst() {
		assertEquals('F', this.ternaryExpressionParser.evaluate("T?T?F:5:3"));
	}
}
