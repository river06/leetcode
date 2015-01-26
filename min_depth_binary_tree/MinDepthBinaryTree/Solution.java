package MinDepthBinaryTree;

import java.util.*;

public class Solution{
	public static int minDepth(TreeNode root) {
		if( root == null) return 0;

		int result = BFS(root);

		return result;
	}

	private static int BFS(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.add(root);
		level.add(1);

		TreeNode head = root;
		Integer hLevel = 1;

		while( head.left != null || head.right != null) {

			hLevel = level.peek();
			
			if(head.left != null) {
				queue.add(head.left);
				level.add(hLevel + 1);
			}
			if(head.right != null) {
				queue.add(head.right);
				level.add(hLevel + 1);
			}
			queue.remove();
			level.remove();
			
			head = queue.peek();
		}
		
		hLevel = level.peek();

		return (int) hLevel;
		
	}
}
