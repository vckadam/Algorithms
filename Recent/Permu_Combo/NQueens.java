/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        if(n <= 0) return ret;
        StringBuilder[] sbA = setUpInitial(n);
        Set<Integer> dia = new HashSet<Integer>();
        Set<Integer> orDia = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        helper(ret, sbA, colSet, dia, orDia, n, 0);
        return ret;
    }
    
    public void helper(List<List<String>> ret, StringBuilder[] sbA, Set<Integer> colSet, Set<Integer> dia, Set<Integer> orDia, int n, int row) {
        if(row == n) {
            addCurrentBoard(ret,sbA);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!colSet.contains(col) && !dia.contains(col-row) && !orDia.contains(row+col)) {
                addOrRemoveFromSet(colSet,dia,orDia, col, col-row, row+col, true);
                sbA[row].setCharAt(col,'Q');
                helper(ret, sbA, colSet, dia, orDia, n, row+1);
                sbA[row].setCharAt(col,'.');
                addOrRemoveFromSet(colSet,dia,orDia, col, col-row, row+col, false);
            }
        }
    }
    public void addOrRemoveFromSet(Set<Integer> colSet, Set<Integer> dia, Set<Integer> orDia, int col, int diaVal,
                                  int orDaiVal, boolean add) {
        if(add) {
            colSet.add(col);
            dia.add(diaVal);
            orDia.add(orDaiVal);
        } else {
            colSet.remove(col);
            dia.remove(diaVal);
            orDia.remove(orDaiVal);
        }
    }
    
    public void addCurrentBoard(List<List<String>> ret, StringBuilder[] sbA) {
        List<String> curr = new ArrayList<>();
        for(int i = 0; i < sbA.length; i++) {
            curr.add(sbA[i].toString());
        }
        ret.add(curr);
    }
	
    public StringBuilder[] setUpInitial(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) 
            sb.append(".");
        StringBuilder[] sbA = new StringBuilder[n];
        for(int i = 0; i < sbA.length; i++) 
            sbA[i] = new StringBuilder(sb);
        return sbA;
    }
}