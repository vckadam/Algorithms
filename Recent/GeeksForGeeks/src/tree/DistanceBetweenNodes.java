package tree;

public class DistanceBetweenNodes {
	/*
	 * node1 & node2 present in the tree
	 */
	public int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {
		int[] dist = new int[3];
		dist[2] = -1;
		helper(root,node1,node2,dist,1);
		return dist[0] + dist[1] - 2 * dist[2];
	}
	
	public void helper(TreeNode root, TreeNode node1, TreeNode node2, int[] dist, int currDist) {
		if(root == null)
			return;
		if(root == node1) {
			dist[0] = currDist;
			if(dist[2] == -1) {
				dist[2] = currDist;
			}
		} if(root == node2) {
			dist[1] = currDist;
			if(dist[2] == -1) {
				dist[2] = currDist;
			}
		}
		if(root.val < node1.val && root.val < node2.val) {
			helper(root.right, node1, node2, dist, currDist+1);
		} else if(root.val > node1.val && root.val > node2.val) {
			helper(root.left, node1, node2, dist, currDist+1);
		} else {
			dist[2] = currDist;
			helper(root.left, node1, node2, dist, currDist+1);
			helper(root.right, node1, node2, dist, currDist+1);
		}
	}
}
