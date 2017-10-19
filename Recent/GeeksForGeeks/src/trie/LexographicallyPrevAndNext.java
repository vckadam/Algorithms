package trie;

class Node {
	Node[] nodes;
	String endString;
	public Node() {
		nodes = new Node[26];
		endString = null;
	}
}

class Trie {
	Node root;
	
	public Trie() {
		root = new Node();
	}
	
	public void add(String str) {
		Node temp = root;
		for(int i = 0; i < str.length(); i++) {
			int currInd = str.charAt(i) - 'a';
			if(temp.nodes[currInd] == null) 
				temp.nodes[currInd] = new Node();
			temp = temp.nodes[currInd];
		}
		temp.endString = str;
	}
	
	public Node getNextNode(String str) {
		return getNextNodeHelper(str, root, 0);
	}
	
	public Node getNextNodeHelper(String str, Node root, int ind) {
		if(ind == str.length()) {
			for(int i = 0; i < 26; i++) {
				if(root.nodes[i] != null)
					return root.nodes[i];
			}
			return null;
		}
		int i = str.charAt(ind) - 'a';
		if(root.nodes[i] != null) {
			Node prev = getNextNodeHelper(str, root.nodes[i], ind+1);
			if(prev != null) 
				return prev;	
		} 
		for(i = i + 1; i < 26; i++) {
			if(root.nodes[i] != null)
				return root.nodes[i];
		}
		return null;
	}
	
	public String getLeftMost(Node node) {
		if(node == null)
			return null;
		if(node.endString != null)
			return node.endString;
		for(int i = 0; i < 26; i++) {
			if(node.nodes[i] != null) 
				return getLeftMost(node.nodes[i]);
		}
		return null;
	}
}

public class LexographicallyPrevAndNext {
	Trie trie = new Trie();
	public String getNext(String[] strs, String str) {
		if(strs == null || strs.length == 0) 
			throw new IllegalArgumentException("Illegal Argument");
		for(int i = 0; i < strs.length; i++) 
			trie.add(strs[i]);
		Node nextNode = trie.getNextNode(str);
		return trie.getLeftMost(nextNode);
	}
}
