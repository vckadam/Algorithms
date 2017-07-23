/*
648. Replace Words My SubmissionsBack to Contest
User Accepted: 708
User Tried: 823
Total Accepted: 721
Total Submissions: 1517
Difficulty: Hard
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
*/

public class Solution {
    class TrieNode {
        TrieNode[] array;
        boolean isTrue;
        public TrieNode() {
            array = new TrieNode[26];
            isTrue = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
        public void add(String str) {
            TrieNode temp = root;
            int i = 0;
            while(i < str.length()) {
                if(temp.array[str.charAt(i)-'a'] == null) {
                    temp.array[str.charAt(i)-'a'] = new TrieNode();
                } 
                temp = temp.array[str.charAt(i)-'a'];
                i++;
            }
            temp.isTrue = true;
        }
        public String contain(String str) {
            int i = 0;
            TrieNode temp = root;
            while(i < str.length()) {
                if(temp.array[str.charAt(i)-'a'] != null) {
                    temp = temp.array[str.charAt(i)-'a'];
                    if(temp.isTrue) return str.substring(0,i+1);
                } else return "";
                i++;
            }
            return "";
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String str : dict) {
            trie.add(str);
        }
        String[] strA = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strA) {
            String temp = trie.contain(str);
            System.out.println("temp"+temp);
            if(temp.equals("")) {
                sb.append(str+" ");
            } else sb.append(temp+" ");
        }
        if(sb.length() > 0) return sb.substring(0,sb.length()-1);
        return sb.toString();
    }
}