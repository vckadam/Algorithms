package ternarysearchtree;

public class TSTree {
	TSTNode root;
	public TSTree() {
		root = null;
	}
	
	public void insert(String word) {
		if(word == null || word.length() == 0)
			return;
		this.root = insertHelper(root,word,0);
	}
	
	public TSTNode insertHelper(TSTNode root, String word, int ind) {
		if(ind == word.length()) {
			root = new TSTNode('\0');
			root.eof = true;
			return root;
		}
		if(root == null) {
			root = new TSTNode(word.charAt(ind));
			root.mid = insertHelper(root.mid, word, ind+1);
		}
		else if(root.ch == word.charAt(ind) || root.ch == '\0') {
			root.ch = word.charAt(ind);
			root.mid = insertHelper(root.mid, word, ind+1);
		} else if(word.charAt(ind) < root.ch) {
			root.left = insertHelper(root.left, word, ind);
		} else {
			root.right = insertHelper(root.right, word, ind);
		}
		return root;
	}
	
	public boolean contains(String word) {
		if(word == null || word.length() == 0)
			return false;
		return containsHelper(root,word,0);
	}
	
	public boolean containsHelper(TSTNode root, String word, int ind) {
		if(root == null) 
			return false;
		if(ind == word.length()) 
			return root.eof;
		if(word.charAt(ind) == root.ch) 
			return containsHelper(root.mid,word,ind+1);
		else if(word.charAt(ind) < root.ch) 
			return containsHelper(root.left,word,ind);
		else
			return containsHelper(root.right,word,ind);
	}
}
