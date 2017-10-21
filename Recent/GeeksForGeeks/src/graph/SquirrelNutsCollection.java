package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SquirrelNutsCollection {
	
	public static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public int getNumberOfSteps(int n, int m, int startI, int startJ, int treeI, int treeJ, int[][] locs) {
		if(n <= 0 || m <= 0 || !isValid(n,m,startI, startJ) || !isValid(n,m,treeI,treeJ)) 
			throw new IllegalArgumentException("Illegal Argument");
		if(locs == null || locs.length == 0)
			return 0;
		int count = 0;
		Set<String> set = new HashSet<String>();
		for(int[] loc : locs) 
			set.add(loc[0]+"#"+loc[1]);
		count += getFirstNut(n, m, startI, startJ, set);
		count += getPathForOtherNuts(n, m, treeI, treeJ, set);
		return count;
	}
	
	public boolean isValid(int n, int m, int i, int j) {
		return !(i < 0 || j < 0 || i >= n || j >= m);
	}
	
	public int getPathForOtherNuts(int n, int m, int tI, int tJ, Set<String> set) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {tI, tJ});
		visited[tI][tJ] = true;
		int level = 0, count = 0;
		while(!queue.isEmpty()) {
			int currSize = queue.size();
			for(int i = 0; i < currSize; i++) {
				int[] temp = queue.poll();
				if(set.contains(temp[0]+"#"+temp[1])) {
					count += 2 * level;
				} else if(set.contains("#"+temp[0]+"#"+temp[1]+"#")) {
					count += level;
				}
				for(int[] dir : dirs) {
					int nI = dir[0] + temp[0];
					int nJ = dir[1] + temp[1];
					if(!isValid(n,m,nI,nJ) || visited[nI][nJ]) 
						continue;
					visited[nI][nJ] = true;
					queue.offer(new int[] {nI, nJ});
				}
			}
			level++;
		}
		return count;
	}
	
	public int getFirstNut(int n, int m, int sI, int sJ, Set<String> set) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		int level = 0;
		queue.add(new int[] {sI, sJ});
		visited[sI][sJ] = true;
		while(!queue.isEmpty()) {
			int currSize = queue.size();
			for(int i = 0; i < currSize; i++) {
				int[] temp = queue.poll(); 
				if(set.contains(temp[0]+"#"+temp[1])) {
					set.remove(temp[0]+"#"+temp[1]);
					set.add("#"+temp[0]+"#"+temp[1]+"#");
					return level;
				}
				for(int[] dir : dirs) {
					int nI = dir[0] + temp[0];
					int nJ = dir[1] + temp[1];
					if(!isValid(n,m,nI,nJ) || visited[nI][nJ])
						continue;
					visited[nI][nJ] = true;
					queue.offer(new int[] {nI, nJ});
				}
			}
			level++;
		}
		return 0;
	}
}
