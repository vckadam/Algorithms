/*

421. Maximum XOR of Two Numbers in an Array
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.

*/

public class Solution {
    class Node {
        Node[] nodes;
        public Node() {
            nodes = new Node[2];
        }
    }
    class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        public void add(int n) {
            Node temp = root;
            /* 
            n = 10000000000000000000000000000010
            n >> 31 
            00000000000000000000000000000001 & 1 - 1
            */
            for(int i = 31; i >= 0; i--) {
                int digit = ((n >> i) & 1);
                if(temp.nodes[digit] == null) temp.nodes[digit] = new Node();
                temp = temp.nodes[digit];
            }
        }
        
        public int maxXOR() {
            /*
            n1 - 00000000000000000000000000000010
            n2 - 10000000000000000000000000000011
            ans= 10000000000000000000000000000001
            ret -00000000000000000000000000000000
            
            1
            1 << 31
            10000000000000000000000000000000 | ret
            10000000000000000000000000000000
            */
            return helper(31,root,root,0);
        }
        public int helper(int ind, Node root1, Node root2, int ret) {
            if(ind < 0) {
                return ret;
            }
            if(root1 == null || root2 == null) return 0;
            int num1 = 0;
            if(root1.nodes[0] != null && root2.nodes[1] != null)
                num1 = Math.max(num1, helper(ind-1, root1.nodes[0], root2.nodes[1], ret|(1<<ind)));
            if(root1.nodes[1] != null && root2.nodes[0] != null)
                num1 = Math.max(num1, helper(ind-1, root1.nodes[1], root2.nodes[0], ret|(1<<ind)));
            if(root1.nodes[0] != null && root2.nodes[0] != null)
                num1 = Math.max(num1, helper(ind-1, root1.nodes[0], root2.nodes[0], ret|(0<<ind)));
            if(root1.nodes[1] != null && root2.nodes[1] != null)
                num1 = Math.max(num1, helper(ind-1, root1.nodes[1], root2.nodes[1], ret|(0<<ind)));
            return num1;
        }
    }
    public int findMaximumXOR(int[] nums) {
        /* 
         3 -     11
         10 -  1010
         5  -   101
         25 - 11001
         2  -    10
         8     1000
        */
        Trie trie = new Trie();
        for(int num : nums) {
            trie.add(num);
        }
        return trie.maxXOR();
    }
}