package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoinChangeTest {

	private CoinChange coinChange;
	
	@Before
	public void setUp() throws Exception {
		this.coinChange = new CoinChange();
	}

	@Test(timeout = 250)
	public void testGetChange_BasicScenario() {
		List<Integer> coins = Arrays.asList(1,2,5);
		List<Integer> expectedCoins = Arrays.asList(2,2,5);
		assertEquals(expectedCoins,this.coinChange.getChange(9, coins));
	}
	
	@Test(timeout = 250)
	public void testGetChange_EvenAmount() {
		List<Integer> coins = Arrays.asList(1,2,5);
		List<Integer> expectedCoins = Arrays.asList(5,5);
		assertEquals(expectedCoins,this.coinChange.getChange(10, coins));
	}
	
	@Test(timeout = 250)
	public void testGetChange_NotPossibleAmount() {
		List<Integer> coins = Arrays.asList(2,5);
		List<Integer> expectedCoins = Arrays.asList();
		assertEquals(expectedCoins,this.coinChange.getChange(3, coins));
	}
	
	@Test(timeout = 250)
	public void testGetChange_DuplicateCoins() {
		List<Integer> coins = Arrays.asList(2,2,2,5,3,3,3,5);
		List<Integer> expectedCoins = Arrays.asList(3,3,3);
		assertEquals(expectedCoins,this.coinChange.getChange(9, coins));
	}
	
	@Test(timeout = 250)
	public void testGetChange_OneCoin() {
		List<Integer> coins = Arrays.asList(1);
		List<Integer> expectedCoins = Arrays.asList(1);
		assertEquals(expectedCoins,this.coinChange.getChange(1, coins));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetChange_InvalidAmount() {
		List<Integer> coins = Arrays.asList(1);
		List<Integer> expectedCoins = Arrays.asList();
		assertEquals(expectedCoins,this.coinChange.getChange(-1, coins));
	}

}
