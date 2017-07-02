package ReachableKHops;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachableKHops {
	public boolean isReachable(char[][] grid, char ch, int k) {
		if(grid == null || grid.length == 0 || k < 0) return false;
		if(k == 0) return (grid[0][0] == ch);
		int level = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		Set<String> visited = new HashSet<String>();
		q.offer(new int[]{0,0});
		visited.add(0+"#"+0);
		q.offer(null);
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp != null) {
				int row = temp[0], col = temp[1];
				if(grid[row][col] == ch) return true;
				if(row > 0 && !visited.contains((row-1)+"#"+col)) {
					q.offer(new int[]{row-1,col});
					visited.add((row-1)+"#"+col);
				}
				if(col > 0 && !visited.contains(row+"#"+(col-1))) {
					q.offer(new int[]{row,col-1});
					visited.add(row+"#"+(col-1));
				}
				if(row < grid.length-1 && !visited.contains((row+1)+"#"+col)) {
					q.offer(new int[]{row+1, col});
					visited.add((row+1)+"#"+col);
				}
				if(col < grid[0].length-1 && !visited.contains(row+"#"+(col+1))) {
					q.offer(new int[]{row, col+1});
					visited.add(row+"#"+(col+1));
				}
				
			} else {
				level++;
				if(level > k) break;
				if(!q.isEmpty()) q.offer(null);
			}
			
		}
		return false;
	}
}
