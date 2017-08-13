package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChange {
	public List<Integer> getChange(int n, List<Integer> coins) {
		if(n < 0 || coins == null)
			throw new IllegalArgumentException("Illegal Argument n = "+n+" coins = "+coins);
		List<Integer> ret = new ArrayList<Integer>();
		Collections.sort(coins, (a,b)->b-a);
		int[] count = new int[n+1];
		int[][] prevCoin = new int[n+1][2];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;
		for(int j = 0; j < coins.size(); j++) {
			int coin = coins.get(j);
			if(j == 0 || coins.get(j-1) != coin) {
				for(int i = coin; i <= n; i++) {
					if(count[i-coin] != Integer.MAX_VALUE) {
						if(count[i-coin]+1 < count[i]) {
							count[i] = 1 + count[i-coin];
							prevCoin[i][0] = i-coin;
							prevCoin[i][1] = coin;
						}
					}
				}
			}
		}
		if(count[n] == Integer.MAX_VALUE)
			return ret;
		int ind = n;
		while(ind > 0) {
			ret.add(prevCoin[ind][1]);
			ind = prevCoin[ind][0];
		}
		return ret;
	}
}
