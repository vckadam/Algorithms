package graph;


public class BellmanFord {

	public int[] getShortestDistance(int v, int[][] edges) {
		int[][] weight = new int[v][v];
		int[] distance = new int[v];
		for(int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
		for(int[] edge : edges) {
			weight[edge[0]][edge[1]] = edge[2];
		}
		distance[0] = 0;
		while(v-- > 0) {
			for(int[] edge : edges) {
				if(distance[edge[1]] > distance[edge[0]] + weight[edge[0]][edge[1]]) {
					distance[edge[1]] = distance[edge[0]] + weight[edge[0]][edge[1]];
				}
			}
		}
		for(int[] edge : edges) { // check negative edge cycle exist.
			if(distance[edge[1]] > distance[edge[0]] + weight[edge[0]][edge[1]]) {
				return null;
			}
		}
		return distance;
	}
}
