package greedy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {

	private Knapsack knapsack;
	
	@Before
	public void setUp() throws Exception {
		this.knapsack = new Knapsack();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetO1Knapsack_BasicScenario() {
		int[] items = {1,2,3,4};
		int[] val = {4,4,9,2}; //4,2,3,0.5 -> 4 + 9 + 4   -> 1, 3, 2
		int[] weights = {1,2,3,4};
		Object[] amountAndItems = this.knapsack.getO1Knapsack(items, weights, val, 6);
		int actualAmout = (int)amountAndItems[0];
		List<Integer> actualItems = (List<Integer>)amountAndItems[1];
		Collections.sort(actualItems,(a,b)->a-b);
		int expectedAmount = 17;
		List<Integer> expectedItems = Arrays.asList(1,2,3);
		assertEquals(expectedAmount, actualAmout);
		assertEquals(expectedItems,actualItems);
		
	}

	@Test
	public void testGetFractionalKnapsack() {
		int[] items = {1,2,3,4};
		int[] val = {4,4,9,2}; //4,2,3,0.5 -> 4 + 9 + 4   -> 1, 3, 2
		int[] weights = {1,2,3,4};
		Object[] amountAndItems = this.knapsack.getFractionalKnapsack(items, weights, val, 5);
		double actualAmout = (double)amountAndItems[0];
		@SuppressWarnings("unchecked")
		List<Integer> actualItems = (List<Integer>)amountAndItems[1];
		Collections.sort(actualItems,(a,b)->a-b);
		double expectedAmount = 15;
		List<Integer> expectedItems = Arrays.asList(1,2,3);
		assertEquals(expectedAmount, actualAmout, 0.009);
		assertEquals(expectedItems,actualItems);
	}

}
