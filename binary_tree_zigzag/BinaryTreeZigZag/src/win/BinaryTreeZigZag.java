package win;
import java.util.*;
public class BinaryTreeZigZag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		//root.right = new TreeNode(3);
		//root.left = new TreeNode(2);

		ArrayList<ArrayList<Integer>> result = Solution.zigzagLevelOrder(root);

		System.out.println(result);
	}

}
