package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
	public List<Object> shortestPath(int n, List<List<Integer>> edges, int start) {
		int[] parent = new int[n];
		int[] distance = new int[n];
		int[][] weight = new int[n][n];
		for(int i = 0; i < n; i++) distance[i] = -1;
		Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
		for(List<Integer> edge : edges) {
			if(!adjList.containsKey(edge.get(0))) adjList.put(edge.get(0), new ArrayList<Integer>());
			adjList.get(edge.get(0)).add(edge.get(1));
			weight[edge.get(0)][edge.get(1)] = edge.get(2);
		}
		Map<Integer, int[]> hm = new HashMap<Integer,int[]>();
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				return a1[1] - a2[1];
			}
		};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comp);
		pq.add(new int[]{start, 0});
		hm.put(start, new int[]{start,0});
		distance[start] = 0;
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			hm.remove(curr[0]);
			if(adjList.containsKey(curr[0])) {
				List<Integer> neighbours = adjList.get(curr[0]);
				for(Integer neighbour : neighbours) {
					if(distance[neighbour] == -1) {
						distance[neighbour] = distance[curr[0]] + weight[curr[0]][neighbour];
						parent[neighbour] = curr[0];
						pq.add(new int[]{neighbour,distance[neighbour]});
						hm.put(neighbour, new int[]{neighbour, distance[neighbour]});
						
					} else {
						if(hm.containsKey(neighbour)) {
							int[] val = hm.get(neighbour);
							if(distance[curr[0]] + weight[curr[0]][neighbour] < val[1]) {
								pq.remove(val);
								val[1] = distance[curr[0]] + weight[curr[0]][neighbour];
								distance[neighbour] = val[1];
								parent[neighbour] = curr[0];
								pq.add(val);
							}
						}
					}
				}
			}
		}
		List<Object> ret = new ArrayList<Object>();
		ret.add(distance);
		ret.add(parent);
		return ret;
	}
}
