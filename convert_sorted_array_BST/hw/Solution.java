package hw;

public class Solution {
	public TreeNode sortedArrayToBST(int [] num) {
		// this method creat the BST in a top-down fashion

		int length = num.length;

		TreeNode result = createBSTTopDown(num, 0, length-1);

		return result;
		
	}

	TreeNode createBSTTopDown(int[] num, int start, int end) {
		// base case
		if(start>end) return null;

		int mid = (start + end)/2;
		TreeNode root = new TreeNode( num[mid]);
		TreeNode left_child = createBSTTopDown(num, start, mid-1);
		TreeNode right_child = createBSTTopDown(num, mid+1, end);

		root.left = left_child;
		root.right = right_child;

		return root;
	}
}