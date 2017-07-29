/* 
No Prefix Set
Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.

Input Format 
First line contains , the number of strings in the set. 
Then next  lines follow, where  line contains  string.

Constraints 
 
 Length of the string 

Output Format 
Output GOOD SET if the set is valid. 
Else, output BAD SET followed by the first string for which the condition fails.

Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh
*/

import java.io.*;
import java.util.*;

public class Solution {

    static class Node {
        Node[] nodes;
        int visited;
        int eow; 
        public Node() {
            nodes = new Node[26];
            eow = 0;
            visited = 0;
        }
    }
    
    static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        
        public boolean add(String str) {
            Node temp = root;
            for(int i = 0; i < str.length(); i++) {
                if(temp.nodes[str.charAt(i)-'a'] == null) temp.nodes[str.charAt(i)-'a'] = new Node();
                temp = temp.nodes[str.charAt(i)-'a'];
                if(i < str.length()-1 && temp.eow > 0) { // ex g followed by ghi 
                    return false;
                }
                temp.visited++;
            }
            if(temp.visited > 1 || temp.eow > 0) {  // for visited - ghi followed by g
                return false;                       // eow - ghi followed by ghi
            }
            temp.eow++;
            return true;
        }
        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie trie = new Trie();
        String str = "";
        for(int i = 0; i < n; i++) {
            str = sc.next();            
            if(!trie.add(str)){
                System.out.println("BAD SET");
                System.out.println(str);
                System.exit(0);
            }
            
        }
         System.out.println("GOOD SET");
    }
}