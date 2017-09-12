package ternarysearchtree;

public class AutoCompleteTST {
	
	private TSTree tree;
	
	public AutoCompleteTST() {
		tree = new TSTree();
	}
	
	public void createDist(String[] words) {
		for(String word : words) 
			tree.insert(word);
	}
	
	public boolean contains(String word) {
		return tree.contains(word);
	}
}
