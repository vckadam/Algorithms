package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSchedulingWeight {
	/*
	 * {{'a',1,3,5},{'b',2,5,6},{'c',4,6,5}}
	 * schedule jobs such as way so that we get the maximum profit
	 * 'a' - jobId
	 * 1 - start time
	 * 3 - end time
	 * 5 - profit by performing job
	 */
	
	public List<Character> getSequence(List<Object[]> jobDesc) {
		if(jobDesc == null)
			throw new IllegalArgumentException("Illegal Argument");
		Collections.sort(jobDesc,(a,b)->(int)a[2]-(int)b[2]);
		int[] profit = new int[jobDesc.size()];
		int[] prevInd = new int[jobDesc.size()];
		for(int i = 0; i < profit.length; i++)
			profit[i] = (int)jobDesc.get(i)[3];
		Arrays.fill(prevInd, -1);
		int maxProfit = profit[0], maxInd = 0;
		for(int i = 1; i < jobDesc.size(); i++) {
			Object[] curr = jobDesc.get(i);
			for(int j = 0; j < i; j++) {
				Object[] prev = jobDesc.get(j);
				if((int)curr[1] >= (int)prev[2]) { //No overlap
					if(profit[j]+(int)curr[3] > profit[i]) { //If earn more profit
						profit[i] = profit[j]+(int)curr[3];
						prevInd[i] = j;
					}
				}
			}
			if(profit[i] > maxProfit) { //No guarantee to be last at last Index
				maxProfit = profit[i];
				maxInd = i;
			}
		}
		List<Character> sequence = new ArrayList<Character>();
		while(maxInd != -1) {
			sequence.add((char)jobDesc.get(maxInd)[0]);
			maxInd = prevInd[maxInd];
		}
		return sequence;
	}
}
