/*
820. Short Encoding of Words

Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].
Note:

1 <= words.length <= 2000.
1 <= words[i].length <= 7.
Each word has only lowercase letters.

*/

class ShortEncodingOfWords {
    class Node {
        Node[] array;
        int count;
        public Node() {
            array = new Node[26];
        }
    }
    
    class Trie {
        
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void add(String s) {
            Node temp = root;
            boolean status = false;
            for(int i = s.length()-1; i >= 0; i--) {
                if(temp.array[s.charAt(i)-'a'] == null) {
                    temp.array[s.charAt(i)-'a'] = new Node();
                    status = true;
                }
                temp = temp.array[s.charAt(i)-'a'];
                if(i != 0) temp.count = 0;
            }
            if(status) temp.count = s.length()+1;
        }
        
        public int countAll(Node root) {
            int ret = 0;
            ret += root.count;
            for(int i = 0; i < 26; i++) {
                if(root.array[i] != null) {   
                    ret += countAll(root.array[i]);
                }
            }
            return ret;
        }
        
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.add(word);
        }
        return trie.countAll(trie.root);
    }
}