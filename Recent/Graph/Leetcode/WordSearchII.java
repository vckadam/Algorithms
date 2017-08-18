/*
212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<String>();
        if(board.length == 0 || words.length == 0)
            return new ArrayList<String>();
        Map<Character,List<int[]>> hm = new HashMap<Character,List<int[]>>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!hm.containsKey(board[i][j]))
                    hm.put(board[i][j],new ArrayList<int[]>());
                hm.get(board[i][j]).add(new int[]{i,j});
            }
        }
        for(int i = 0; i < words.length; i++) {
            String currWord  = words[i];
            if(currWord != null && currWord.length() > 0 && !ret.contains(currWord)) {
                char key  = currWord.charAt(0);
                List<int[]> pos = hm.get(key);
                if(pos != null && pos.size() > 0) {
                    for(int[] ele : pos) {
                        if(helper(board,currWord,ele[0],ele[1],0)) {
                            ret.add(currWord);
                            break;
                        }
                    }
                }
            }
        }
        return new ArrayList<String>(ret);
    }
    public boolean helper(char[][] board, String word, int i, int j, int ind) {
        if(ind == word.length())
            return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '\0') 
            return false;
        if(word.charAt(ind) == board[i][j]) {
            char currChar = board[i][j];
            board[i][j] = '\0';
            boolean ret = false;
            if(helper(board,word,i+1,j,ind+1) || 
               helper(board,word,i-1,j,ind+1) ||
               helper(board,word,i,j+1,ind+1) ||
               helper(board,word,i,j-1,ind+1)) {
                board[i][j] = currChar;
                return true;
            }
            board[i][j] = currChar;    
        }
        return false;
    }
}