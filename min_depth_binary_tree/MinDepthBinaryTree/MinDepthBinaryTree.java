package MinDepthBinaryTree;


public class MinDepthBinaryTree{
	public static void main (String[] args){

		TreeNode root =	new TreeNode(1);
		root.left = new TreeNode(1);
		//root.right = new TreeNode(2);
		//	root.right.right = new TreeNode(1);

		int result = Solution.minDepth(root);

		System.out.println(result);
	}
}