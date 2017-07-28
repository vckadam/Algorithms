package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HamiltonianCycle {

	public boolean containCycle(int n, int[][] edges) {
		if(edges != null && n > 0 && edges.length >= n-1) {
			Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
			Set<String> set = new HashSet<String>(); // avoids duplicates
			for(int[] edge : edges) {
				if(edge != null && !set.contains(edge[0]+"#"+edge[1]) && !set.contains(edge[1]+"#"+edge[0])) {
					if(!adjMap.containsKey(edge[0])) adjMap.put(edge[0], new ArrayList<Integer>());
					if(!adjMap.containsKey(edge[1])) adjMap.put(edge[1], new ArrayList<Integer>());
					adjMap.get(edge[0]).add(edge[1]);
					adjMap.get(edge[1]).add(edge[0]);
					set.add(edge[0]+"#"+edge[1]);
					set.add(edge[1]+"#"+edge[0]);
				}
			}
			boolean[] visited = new boolean[n];
			visited[0] = true;
			return helper(0, adjMap, visited, 0);
		}
		else 
			return false;
	}
	
	public boolean helper(int i, Map<Integer,List<Integer>> adjMap, boolean[] visited, int count) {
		if(count == visited.length-1) {
			List<Integer> neighbours = adjMap.get(i);
			if(neighbours != null) {
				for(Integer neighbour : neighbours) if(neighbour == 0) return true;
			}
			return false;
		}
		List<Integer> neighbours = adjMap.get(i);
		if(neighbours != null) {
			for(Integer neighbour : neighbours) {
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					if(helper(neighbour, adjMap, visited, count+1)) return true;
					visited[neighbour] = false;
				}
			}
		}
		return false;
	}
}
