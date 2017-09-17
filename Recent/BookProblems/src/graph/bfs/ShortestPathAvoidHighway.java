package graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathAvoidHighway {
	public String getSortestPath(int n, int[][] edges, int[][] highways, int start, int end) {
		if(n <= 0)
			throw new IllegalArgumentException("Illegal Argument");
		if(start == end)
			return "";
		Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
		for(int[] edge : edges) {
			putInMap(adjList,edge[0],edge[1]);
			putInMap(adjList,edge[1],edge[0]);
		}
		Set<String> highwaySet = new HashSet<String>();
		for(int[] highway : highways) {
			highwaySet.add(highway[0]+"->"+highway[1]);
			highwaySet.add(highway[1]+"->"+highway[0]);
		}
		return bfs(start,end,adjList,highwaySet,n);
	}
	
	public String bfs(int start, int end, Map<Integer,List<Integer>> adjList, Set<String> highwaySet, int n) {
		boolean[] visited = new boolean[n];
		Queue<Integer> nodeQue = new LinkedList<Integer>();
		Queue<String> pathQue = new LinkedList<String>();
		nodeQue.add(start);
		pathQue.add("");
		visited[start] = true;
		while(!nodeQue.isEmpty()) {
			Integer currNode = nodeQue.poll();
			String currPath = pathQue.poll();
			currPath += (currPath != "" ? ("->"+currNode) : currNode);
			if(currNode == end)
				return currPath;
			List<Integer> neighbours = adjList.get(currNode);
			for(Integer neighbour : neighbours) {
				if(!visited[neighbour] && !highwaySet.contains(currNode+"->"+neighbour)) {
					visited[neighbour] = true;
					nodeQue.add(neighbour);
					pathQue.add(currPath);
				}
			}
			
		}
		return null;
	}
	
	public void putInMap(Map<Integer,List<Integer>> hm, int key, int val) {
		if(!hm.containsKey(key))
			hm.put(key, new ArrayList<Integer>(Arrays.asList(val)));
		else 
			hm.get(key).add(val);
	}
}
