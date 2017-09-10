package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KnightTour {
	/** returns all sequence of moves of a knight on a chess-board such that
	 * knight visits every square only once.*/
	public List<List<String>> getTour(int n, int m) {
		if(n <= 0 || m <= 0)
			throw new IllegalArgumentException("Illegal Argument");
		List<List<String>> allSeq = new ArrayList<List<String>>();
		Set<String> pos = new HashSet<String>();
		helper(0,0,pos,allSeq, n, m, 1);
		return allSeq;
	}
	
	public void helper(int row, int col, Set<String> pos, List<List<String>> allSeq, int n, int m, int count) {
		if(count == n * m) {
			allSeq.add(new ArrayList<String>(pos));
			return;
		}
		pos.add(row+"#"+col);
		List<int[]> nextMoves = getNextMoves(row,col,n,m);
		for(int[] next : nextMoves) {
			if(!pos.contains(next[0]+"#"+next[1])) {
				helper(next[0],next[1],pos,allSeq,n,m,count+1);
			}
		}
		pos.remove(row+"#"+col);
	}
	
	public List<int[]> getNextMoves(int row, int col, int n, int m) {
		List<int[]> next = new ArrayList<int[]>();
		for(int i = 1; i <= 2; i++) {
			int j = 3 - i;
			if(row-i >= 0 && col-j >= 0)
				next.add(new int[]{row-i,col-j});
			if(row-i >= 0 && col+j < m)
				next.add(new int[]{row-i,col+j});
			if(row+i < n && col-j >= 0)
				next.add(new int[]{row+i,col-j});
			if(row+i < n && col+j < m) 
				next.add(new int[]{row+i,col+j});
		}
		return next;
	}
}
