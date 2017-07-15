package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationOfTwoInArray {
	public List<List<Integer>> sumOfTwoInArray(int[] array) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(array == null || array.length <= 2) return ret;
		Map<Integer,List<Integer>> hm = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < array.length; i++) {
			if(!hm.containsKey(array[i])) hm.put(array[i], new ArrayList<Integer>());
			hm.get(array[i]).add(i);
		}
		for(int i = 0; i < array.length-1; i++) {
			for(int j = i+1; j < array.length; j++) {
				int currSum = array[i] + array[j];
				if(!hm.containsKey(currSum)) continue;
				List<Integer> currInds = hm.get(currSum);
				for(Integer ind : currInds) {
					if(ind != i && ind != j) {
						ret.add(new ArrayList<Integer>(Arrays.asList(i,j,ind)));
					}
				}
			}
		}
		return ret;
	}
	
	public List<List<Integer>> sumOfSquareOfTwoInArray(int[] array) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(array == null || array.length <= 2) return ret;
		Map<Integer,List<Integer>> hm = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < array.length; i++) {
			int sqr = array[i] * array[i];
			if(!hm.containsKey(sqr)) hm.put(sqr, new ArrayList<Integer>());
			hm.get(sqr).add(i);
		}
		for(int i = 0; i < array.length-1; i++) {
			for(int j = 0; j < array.length; j++) {
				int sumOfSqr = array[i]*array[i] + array[j]*array[j];
				if(!hm.containsKey(sumOfSqr)) continue;
				List<Integer> currInds = hm.get(sumOfSqr);
				for(Integer ind : currInds){
					if(i != ind && j != ind) {
						ret.add(new ArrayList<Integer>(Arrays.asList(i,j,ind)));
					}
				}
			}
		}
		return ret;
	}
}
