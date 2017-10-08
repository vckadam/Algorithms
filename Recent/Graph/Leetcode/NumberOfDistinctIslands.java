/*
694. Number of Distinct Islands

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class NumberOfDistinctIslands {

    private static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> structure = new HashSet<String>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> island = new ArrayList<int[]>();
                    helper(i,j,island,visited,grid);
                    Collections.sort(island, (a,b)->a[0] != b[0] ? a[0]-b[0] : a[1] - b[1]);
                    structure.add(getStructure(island));
                }
            }
        }
        return structure.size();
    }

    public void helper(int i, int j, List<int[]> island, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;
        island.add(new int[]{i,j});
        for(int[] next : dir) {
            int nI = i + next[0];
            int nJ = j + next[1];
            if(nI < 0 || nJ < 0 || nI == grid.length || nJ == grid[0].length || visited[nI][nJ] || grid[nI][nJ] == 0)
                continue;
            helper(nI,nJ,island,visited,grid);
        }
    }

    public String getStructure(List<int[]> island) {
        StringBuilder sb = new StringBuilder();
        int[] min = getMin(island);
        return getGrid(island,min);
    }

    public String getGrid(List<int[]> island, int[] min) {
        StringBuilder sb = new StringBuilder();
        for(int[] ele : island) {
            sb.append((ele[0]-min[0])+","+(ele[1]-min[1])+"#");
        }
        return sb.toString();
    }

    public int[] getMin(List<int[]> island) {
        int[] min = new int[2];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int[] ele : island) {
            min[0] = Math.min(min[0], ele[0]);
            min[1] = Math.min(min[1], ele[1]);
        }
        return min;
    }

}
