/*
676. Implement Magic Dictionary

Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.

*/

class MagicDictionary {

    private Map<String,List<String>> hm;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        hm = new HashMap<String,List<String>>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str : dict) {
            for(int i = 0; i < str.length(); i++) {
                String curr = str.substring(0,i)+"#"+str.substring(i+1);
                if(!hm.containsKey(curr)) 
                    hm.put(curr, new ArrayList<String>());
                hm.get(curr).add(str);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i = 0; i < word.length(); i++) {
            String curr;
            if(hm.containsKey((curr = word.substring(0,i)+"#"+word.substring(i+1)))) {
                List<String> vals = hm.get(curr);
                for(String str : vals) {
                    if(!str.equals(word))
                        return true;
                }
            }
        }      
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */