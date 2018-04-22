/*
821. Shortest Distance to a Character

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
*/

class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        Arrays.fill(ret, ret.length);
        for(int i = 0; i < S.length(); i++) 
            if(S.charAt(i) == C)
                fillArray(ret,i,S);
        return ret;
    }
    
    public void fillArray(int[] ret, int i, String S) {
        ret[i] = 0;
        int count = 1;
        for(int ind = i-1; ind >= 0; ind--, count++) {
            if(S.charAt(ind) == S.charAt(i)) break;
            ret[ind] = Math.min(ret[ind], count);
        }
        count = 1;
        for(int ind = i+1; ind < ret.length; ind++, count++) {
            if(S.charAt(ind) == S.charAt(i)) break;
            ret[ind] = Math.min(ret[ind], count);
        }  
    }
}