package path_sum_II;

import java.util.*;

public class PathSumII{
	public static void main(String [] args){
		TreeNode root = new TreeNode( 5 );
		//root.left = new TreeNode(4);
		//root.right = new TreeNode(4);
		int sum = 5;
		
		ArrayList<ArrayList<Integer>> test_result = Solution.pathSum(root, sum);

		System.out.print(test_result);
	}
}
