package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticulationPoint {
	public List<Integer> getArticulationPoint(int n, int[][] edges) {
		if(n < 0 || edges == null || edges.length == 0)
			throw new IllegalArgumentException("Illegal Arguments");
		Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
		for(int[] edge : edges) {
			addToMap(adjList, edge[0], edge[1]);
			addToMap(adjList, edge[1], edge[0]);
		}
		boolean[] status = new boolean[n];
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		int[] time = new int[n];
		int[] low = new int[n];
		for(int i = 0; i < parent.length; i++)
			parent[i] = i;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i, adjList, status, visited, parent, time, low, 0, -1);
			}
		}
		List<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i < status.length; i++)
			if(status[i])
				ret.add(i);
		return ret;	
	}
	
	public void dfs(int curr, Map<Integer,List<Integer>> adjList, boolean[] status, boolean[] visited, int[] parent, int[] time, int[] low, int currTime, int from) {
		time[curr] = currTime;
		low[curr] = currTime;
		int childern = 0;
		visited[curr] = true;
		List<Integer> neighbours = adjList.get(curr);
		for(Integer neighbour : neighbours) {
			if(neighbour == from)
				continue;
			if(!visited[neighbour]) {
				parent[neighbour] = curr;
				childern++;
				dfs(neighbour, adjList, status, visited, parent, time, low, currTime+1, curr);
				if(parent[curr] == curr && childern >= 2) 
					status[curr] = true;
				if(parent[curr] != curr && time[curr] <= low[neighbour]) {
					status[curr] = true;
				}
			} else {
				low[curr] = Math.min(low[curr], low[neighbour]);
			}
		}
	}
	
	public void addToMap(Map<Integer,List<Integer>> adjList, int key, int val) {
		if(!adjList.containsKey(key))
			adjList.put(key, new ArrayList<Integer>());
		adjList.get(key).add(val);
	}
}
