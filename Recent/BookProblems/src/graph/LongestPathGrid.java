package graph;

public class LongestPathGrid {
	
	public static final int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
	public int getLongestPath(char[][] grid, char start, char end) {
		if(grid.length == 0)
			return 0;
		int max = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == start)
					max = Math.max(max, helper(grid, end, i, j, 0));
			}
		}
		return max;
	}
	
	public int helper(char[][] grid, char end, int i, int j, int step) {
		if(grid[i][j] == end)
			return step;
		char ch = grid[i][j];
		grid[i][j] = '\0';
		int max = 0;
		for(int[] dir : dirs) {
			int nextI = i + dir[0];
			int nextJ = j + dir[1];
			if(nextI < 0 || nextJ < 0 || nextI == grid.length || nextJ == grid[0].length || grid[nextI][nextJ] == '\0')
				continue;
			max = Math.max(max, helper(grid, end, nextI, nextJ, step+1));
		}
		grid[i][j] = ch;
		return max;
	}
}
