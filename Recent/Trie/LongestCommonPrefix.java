/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

*/

class Solution {
    class Node {
        Node[] array;
        int count;
        boolean eow;
        public Node() {
            array = new Node[26];
            count = 0;
            eow = false;
        }
    }
    class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        public int add(String str) {
            if(str == null || str.length() == 0)
                return 0;
            int len = 0;
            Node temp = root;
            for(int i = 0; i < str.length(); i++) {
                int ind;
                if(temp.array[(ind = str.charAt(i)-'a')] == null && temp.count > 0)
                    break;
                if(temp.array[ind] == null)
                    temp.array[ind] = new Node();
                temp.count += 1;
                temp = temp.array[ind];
                len++;
                if(temp.eow) {
                    return len;
                }
            }
            temp.eow = true;
            return len;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        int minLen = Integer.MAX_VALUE;
        String str = null;
        for(int i = 0; i < strs.length; i++) {
            int len;
            if((len  = trie.add(strs[i])) < minLen) {
                minLen = len;
                str = strs[i];
            }
            if(minLen == 0) 
                return "";
        }
        return str == null ? "" : str.substring(0,minLen);
    }
}