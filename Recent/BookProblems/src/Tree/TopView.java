package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
	public List<Integer> getTopView(TreeNode root) {
		if(root == null)
			throw new IllegalArgumentException("Illegal Argument");
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> pos = new LinkedList<Integer>();
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		nodes.add(root);
		pos.add(0);
		while(!nodes.isEmpty()) {
			TreeNode currNode = nodes.poll();
			Integer currPos = pos.poll();
			if(!map.containsKey(currPos))
				map.put(currPos, currNode.val);
			if(currNode.left != null) {
				nodes.offer(currNode.left);
				pos.offer(currPos-1);
			}
			if(currNode.right != null) {
				nodes.offer(currNode.right);
				pos.offer(currPos+1);
			}
		}
		return new ArrayList<Integer>(map.values());
	}
}
