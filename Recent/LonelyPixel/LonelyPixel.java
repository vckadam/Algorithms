package Leetcode.LonelyPixel;

public class LonelyPixel {
	public int getLonelyPixel(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int[] row = new int[grid.length];
		int[] col = new int[grid[0].length];
		int ret = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 'B') {
					row[i]++;
					col[j]++;
				}
			}
		}
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
					ret++;
				}
			}
		}
		return ret;
	}

}
