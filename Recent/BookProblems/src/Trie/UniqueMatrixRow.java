package Trie;

import java.util.ArrayList;
import java.util.List;

/*Given a binary matrix, print all unique rows of the given matrix.*/
class Node {
	Node[] children;
	boolean eor;
	public Node() {
		children = new Node[2];
		eor = false;
	}
}

class Trie2 {
	Node root;
	public Trie2() {
		root = new Node();
	}
	public boolean addRow(int[] row) {
		Node curr = root;
		for(int i = 0; i < row.length; i++) {
			if(curr.children[row[i]] == null)
				curr.children[row[i]] = new Node();
			curr = curr.children[row[i]];
		}
		boolean temp = curr.eor;
		curr.eor = true;
		return !temp;
	}
}
public class UniqueMatrixRow {
	
	public List<Integer> getUniqueMatrixRowIndices(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			throw new IllegalArgumentException("Illegal Argument Exception");
		Trie2 trie = new Trie2();
		List<Integer> uniqueRows = new ArrayList<Integer>();
		int i = 0;
		for(int[] row : matrix) {
			if(trie.addRow(row)) 
				uniqueRows.add(i);
			i++;
		}
		return uniqueRows;
	}
	
}
