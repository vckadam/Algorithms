package search;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindElementMaxOccurTest {

	FindElementMaxOccur obj;
	
	@Before
	public void beforeMethod() {
		obj = new FindElementMaxOccur();
	}
	
	@After
	public void afterMethod() {
		obj = null;
	}
	
	@Test
	public void getMaxOccurTest1() {
		int[] array = {1,2,2,2,1,3,5};
		int actual = obj.getMaxOccur(array);
		assertEquals(2, actual);
	}
	
	@Test
	public void getMaxOccurTes21() {
		int[] array = {1,2,2,1,1,3,5};
		int actual = obj.getMaxOccur(array);
		assertEquals(1, actual);
	}
}
