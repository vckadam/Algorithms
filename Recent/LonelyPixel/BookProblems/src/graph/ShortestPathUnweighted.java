package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathUnweighted {
	public List<Object> getShortestPath(char start, char[][] edges, int noOfVertex) {
		Map<Character,List<Character>> adjList = new HashMap<Character,List<Character>>();
		int[] distance = new int[noOfVertex];
		char[] path = new char[noOfVertex];
		for(char[] edge : edges) {
			if(!adjList.containsKey(edge[0])) adjList.put(edge[0], new ArrayList<Character>());
			adjList.get(edge[0]).add(edge[1]);
		}
		for(int i = 0; i < noOfVertex; i++) {
			distance[i] = -1;
		}
		distance[start-'A'] = 0;
		Queue<Character> queue = new LinkedList<Character>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			char currVertex = queue.poll();
			if(adjList.containsKey(currVertex)) {
				List<Character> neighbours = adjList.get(currVertex);
				for(Character neighbour : neighbours) {
					if(distance[neighbour-'A'] == -1) {
						distance[neighbour-'A'] = distance[currVertex-'A']+1;
						path[neighbour-'A'] = currVertex;
						queue.offer(neighbour);
					}
				}
			}
		}
		//System.out.println(Arrays.toString(distance));
		//System.out.println(Arrays.toString(path));
		List<Object> ret = new ArrayList<Object>();
		ret.add(distance); ret.add(path);
		return ret;
	}
}
