package Trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TrieNode {
	TrieNode[] nodes;
	String endString;
	int count;
	public TrieNode() {
		nodes = new TrieNode[26];
		endString = null;
		count = 0;
	}
}
class Trie {
	TrieNode root;
	int maxCount;
	public Trie() {
		root = new TrieNode();
	}
	public void add(String str) {
		if(str == null || str.length() == 0)
			return;
		TrieNode temp = root;
		for(int i = 0; i < str.length(); i++) {
			int ind = str.charAt(i)-'a'; 
			if(temp.nodes[ind] == null)
				temp.nodes[ind] = new TrieNode();
			temp = temp.nodes[ind];
		}
		if(temp.endString == null) 
			temp.endString = str;
		temp.count++;
		maxCount = Math.max(maxCount, temp.count);
	}
	public List<Object[]> getAllStrings() {
		List<Object[]> strCount = new ArrayList<Object[]>();
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TrieNode temp = queue.poll();
			if(temp.endString != null) {
				strCount.add(new Object[]{temp.endString,temp.count});
			}
			for(int i = 0; i < 25; i++) {
				if(temp.nodes[i] != null) {
					queue.add(temp.nodes[i]);
				}
			}
		}
		return strCount;
	}
}
public class KMaxOccWords {
	public List<String>[] bucketSort(List<Object[]> strWithCount, int max) {
		@SuppressWarnings("unchecked")
		List<String>[] buckets = new List[max+1];
		for(Object[] ele : strWithCount) {
			int ind = (int)ele[1];
			String currStr = (String)ele[0];
			if(buckets[ind] == null)
				buckets[ind] = new ArrayList<String>();
			buckets[ind].add(currStr);
		}
		return buckets;
	}
	
	public List<String> getFirstKString(List<String>[] buckets, int k) {
		List<String> strList = new ArrayList<String>();
		int i = buckets.length-1, count = 0;
		while(i >= 0 && count < k) {
			while(i >= 0 && buckets[i] == null) i--;
			if(i < 0) break;
			for(int j = 0; j < buckets[i].size(); j++,count++) {
				if(count < k) strList.add(buckets[i].get(j));
				else break;
			}
			i--;
		}
		return strList;
	}
	public List<String> getKMostOccuringWords(String[] strA, int k) {
		if(strA == null || strA.length == 0 || k <= 0) 
			throw new IllegalArgumentException("Illegal Argument");
		Trie trie = new Trie();
		for(String str : strA) {
			trie.add(str);
		}
		List<Object[]> strWithCount = trie.getAllStrings();
		List<String>[] strInBuckets = bucketSort(strWithCount,trie.maxCount);
		return getFirstKString(strInBuckets,k);
	}
}
