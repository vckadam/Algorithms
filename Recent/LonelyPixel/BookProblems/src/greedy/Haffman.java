package greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TreeNode {
	int freq;
	char ch;
	TreeNode left, right;
	public TreeNode(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
		this.left = null;
		this.right = null;
	}
}
public class Haffman {
	public Map<Character,String> getHaffmanCode(List<List<Object>> charList) {
		/* 
		 *  a - 4, b - 5, c - 8, d - 9
		 * */
		if(charList == null || charList.size() == 0) return null;
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(new Comparator<TreeNode>(){
			public int compare(TreeNode t1, TreeNode t2) {
				return t1.freq - t2.freq;
			}
		});
		
		for(List<Object> list : charList) {
			if(list == null || list.size() != 2) continue;
			char ch = (char)list.get(0);
			int freq = (int)list.get(1);
			TreeNode newNode = new TreeNode(ch,freq);
			pq.add(newNode);
		}
		while(pq.size() > 1) {
			TreeNode left = pq.poll();
			TreeNode right = pq.poll();
			TreeNode newNode = new TreeNode('\0', left.freq+right.freq);
			newNode.left = left;
			newNode.right = right;
			pq.add(newNode);
		}
		Map<Character,String> ret = new HashMap<Character,String>();
		helper(pq.poll(),ret,"");
		return ret;
	}
	
	public void helper(TreeNode root, Map<Character,String> hm, String code) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			hm.put(root.ch, code);
			return;
		}
		helper(root.left, hm, code+"0");
		helper(root.right, hm, code+"1");
	}
}
