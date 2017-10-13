package backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class FirstColoumToLast {
	
	public static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public int getShortedPath(int[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		markUnsafeNodes(grid);
		int minCount = Integer.MAX_VALUE;
		for(int i = 0; i < grid.length; i++) {
			if(grid[i][0] == 1)
				minCount = Math.min(minCount, helper(grid,i,0));
		}
		return minCount != Integer.MAX_VALUE ? minCount : -1;
	}
	
	public int helper(int[][] grid, int i, int j) {
		if(j == grid[0].length-1)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int[] dir : dirs) {
			int nI = i + dir[0];
			int nJ = j + dir[1];
			if(nI < 0 || nJ < 0 || nI >= grid.length || nJ >= grid[0].length || grid[nI][nJ] == 0)
				continue;
			grid[i][j] = 0;
			int currStep = helper(grid, nI, nJ);
			grid[i][j] = 1;
			if(currStep == Integer.MAX_VALUE)
				continue;
			min = Math.min(min, 1 + currStep);
		}
		return min;
	}
	
	public void markUnsafeNodes(int[][] grid) {
		if(grid == null || grid.length == 0)
			return;
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0)
					queue.offer(new int[] {i,j});
			}
		}
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int[] dir : dirs) {
				int nI = temp[0] + dir[0];
				int nJ = temp[1] + dir[1];
				if(nI < 0 || nJ < 0 || nI >= grid.length || nJ >= grid[0].length || grid[nI][nJ] == 0)
					continue;
				grid[nI][nJ] = 0;
			}
		}
	}
}
