package UndirectedGraphCycle;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraphCycle {
	public boolean containCycle(int n, int[][] edges) {
		if(n <= 0 || edges == null) return false;
		Set<String> set = new HashSet<String>(); // avoid duplicate edges
		int[] array = new int[n];
		for(int i = 0; i < n; i++) array[i] = i;
		for(int[] edge : edges) {
			if(set.contains(edge[0]+"#"+edge[1])) continue;
			set.add(edge[0]+"#"+edge[1]);
			int ind1 = getParent(array, edge[0]);
			int ind2 = getParent(array, edge[1]);
			if(ind1 == ind2) return true;
			array[ind2] = ind1;
		}
		return false;
	}
	public int getParent(int[] array, int ind) {
		if(ind == array[ind]) return ind;
		array[ind] = getParent(array, array[ind]);
		return array[ind];
	}
}
