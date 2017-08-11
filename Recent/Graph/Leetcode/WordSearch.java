/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0)
            return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int i, int j, int ind) {
         if(ind == word.length()) 
            return true;
        
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) 
            return false;
       
        if(word.charAt(ind) == board[i][j]) {
            char currChar = board[i][j];
            board[i][j] = '.';
            boolean ret = helper(board,word,i-1,j,ind+1) ||
                helper(board,word,i+1,j,ind+1) ||
                helper(board,word,i,j-1,ind+1) ||
                helper(board,word,i,j+1,ind+1);
            board[i][j] = currChar;
            return ret;
        }
        return false;
    }
}