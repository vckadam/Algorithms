package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StronglyConnectedGraph {
	
	boolean isStrConn = true;
	
	public boolean isStronglyConnected(int n, int[][] edges) {
		if(n == 1)
			return true;
		if(n <= 0 || edges.length < n) 
			return false;
		Map<Integer,List<Integer>> adjMap = creatAdjListMap(edges);
		boolean[] visited = new boolean[n];
		int[] arrival = new int[n];
		dfs(0,adjMap,arrival,visited,0);
		for(int i = 0; i < n; i++) 
			if(!visited[i])
				return false;
		return isStrConn;
	}
	
	public int dfs(int v, Map<Integer,List<Integer>> adjMap, int[] arrival, boolean[] visited, int time) {
		int currTime = time;
		arrival[v] = time;
		visited[v] = true;
		List<Integer> neighbours = adjMap.get(v);
		for(Integer neighbour : neighbours) {
			if(visited[neighbour]) {
				currTime = Math.min(currTime, arrival[neighbour]);
			} else {
				currTime = Math.min(currTime, dfs(neighbour,adjMap,arrival,visited,time+1));
			}
		}
		if(v != 0 && arrival[v] == currTime) 
			isStrConn = false;
		arrival[v] = currTime;
		return currTime;
	}
	
	public Map<Integer,List<Integer>> creatAdjListMap(int[][] edges) {
		Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
		for(int[] edge : edges) {
			if(!adjMap.containsKey(edge[0])) 
				adjMap.put(edge[0], new ArrayList<Integer>(Arrays.asList(edge[1])));
			else 
				adjMap.get(edge[0]).add(edge[1]);
		}
		return adjMap;
	}
}
