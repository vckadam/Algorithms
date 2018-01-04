package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotherVertex {
	public int getMotherVertex(int n, int[][] edges) {
		if(n <= 0 || edges.length == 0) 
			return -1;
		Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
		for(int[] edge : edges) {
			if(!adjMap.containsKey(edge[0]))
				adjMap.put(edge[0], new ArrayList<Integer>());
			adjMap.get(edge[0]).add(edge[1]);
		}
		Map<Integer,List<Integer>> reached = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < n; i++) {
			if(!reached.containsKey(i)) {
				helper(i, adjMap, reached);
				if(reached.get(i).size() == n - 1)
					return i;
			}
		}
		return -1;
	}
	
	public List<Integer> helper(int v, Map<Integer,List<Integer>> adjMap, Map<Integer,List<Integer>> reached) {
		if(reached.containsKey(v))
			return reached.get(v);
		List<Integer> neighbours = adjMap.get(v);
		if(neighbours == null || neighbours.size() == 0) return neighbours;
		List<Integer> currReach = new ArrayList<Integer>();
		currReach.addAll(neighbours);
		for(Integer neighbour : neighbours) {
			List<Integer> temp = helper(neighbour, adjMap, reached);
			if(temp != null && temp.size() > 0) currReach.addAll(temp);
		}
		reached.put(v, currReach);
		return currReach;
	}
}
