package graph;

public class NumOfConnectedComp {
	public int getConnectedComponents(int n, int[][] edges) {
		if(n <= 0 || edges == null) 
			throw new IllegalArgumentException("Illegal Argument");
		int[] rank = new int[n];
		int[] parent = new int[n];
		for(int i = 0; i < n; i++)
			parent[i] = i;
		int connectedComp = n;
		for(int[] edge : edges) {
			int par1, par2;
			if((par1=find(edge[0],parent)) != (par2=find(edge[1],parent))) {
				connectedComp--;
				if(rank[par1] >= rank[par2]) {
					rank[par1]++;
					parent[par2] = par1;
				}
				else {
					rank[par2]++;
					parent[par1] = par2;
				}
			}
		}
		return connectedComp;
	}
	
	public int find(int ind, int[] parent) {
		while(ind != parent[ind]) {
			parent[ind] = parent[parent[ind]];
			ind = parent[ind];
		}
		return ind;
	}
}
