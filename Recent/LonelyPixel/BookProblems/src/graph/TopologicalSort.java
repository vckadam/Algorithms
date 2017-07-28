package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
	public List<Integer> getTopologicalSort(int n, int[][] edges) {
		if(n <= 0) return null;
		List<Integer> ret = new ArrayList<Integer>();
		int[] indegree = new int[n];
		Map<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
		for(int[] edge : edges) {
			indegree[edge[1]]++;
			if(!adjList.containsKey(edge[0])) adjList.put(edge[0],new ArrayList<Integer>());
			adjList.get(edge[0]).add(edge[1]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			ret.add(curr);
			if(adjList.containsKey(curr)) {
				List<Integer> neighbours = adjList.get(curr);
				for(Integer neighbour : neighbours) {
					if(--indegree[neighbour] == 0) queue.offer(neighbour);
				}
			}
		}
		return ret.size() != n ? null : ret;
	}
}
