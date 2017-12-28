package tree;

import java.util.ArrayList;
import java.util.List;

public class KthAncester {
	public int getKthAncester(TreeNode root, int target, int k) {
		if(root == null) return -1;
		List<Integer> parents = new ArrayList<Integer>();
		if(!helper(root,target,parents) || parents.size() < k) return -1;
		return parents.get(k-1);
	}
	
	public boolean helper(TreeNode root, int target, List<Integer> parents) {
		if(root == null) return false;
		if(root.val == target) return true;
		parents.add(root.val);
		System.out.println(root.val+" "+ parents.toString());
		if(helper(root.left, target, parents) || helper(root.right, target, parents))
			return true;
		parents.remove(parents.size()-1);
		return false;
	}
}
