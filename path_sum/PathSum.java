

public class PathSum{
	public static void main(String [] args){
		TreeNode root = new TreeNode( 5 );
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		int sum = 9;
		
		boolean test_result = Solution.hasPathSum(root, sum);

		System.out.print(test_result);
	}
}