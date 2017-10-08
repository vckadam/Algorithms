/*
695. Max Area of Island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class maxAreaOfIsland {

    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i,j,grid,visited));
                }
            }
        }
        return max;
    }

    public int bfs(int i, int j, int[][] grid, boolean[][] visited) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            count++;
            for(int[] next : dirs) {
                int nI = curr[0] + next[0];
                int nJ = curr[1] + next[1];
                if(nI < 0 || nJ < 0 || nI >= grid.length || nJ >= grid[0].length || visited[nI][nJ] || grid[nI][nJ] == 0)
                    continue;
                queue.offer(new int[]{nI,nJ});
                visited[nI][nJ] = true;
            }
        }
        return count;
    }
}
