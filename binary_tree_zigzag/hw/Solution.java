

package hw;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
		
		ArrayList<Integer> pLevel = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if(root == null) return result;
		
		result.add(pLevel);
		Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
		queueNode.add(root);
		Queue<Integer> queueInt = new LinkedList<Integer>();
		queueInt.add(1);

		int level_old = 1;

		while(!queueNode.isEmpty()) {
			TreeNode pTree = queueNode.remove();
			int level = queueInt.remove();
			
			if(level_old != level) {
				pLevel = new ArrayList<Integer>( );
				pLevel.add(pTree.val);
				result.add(pLevel);
				level_old = level;
			}else {
				if(level % 2 == 1) {
					pLevel.add(pTree.val);
				} else {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(pTree.val);
					tmp.addAll(pLevel);
					pLevel = tmp;
				}
			}

			//System.out.println(level_old);

			if(pTree.left != null) {
				queueNode.add(pTree.left);
				queueInt.add(level + 1);
			}
			if(pTree.right != null) {
				queueNode.add(pTree.right);
				queueInt.add(level + 1);
			}
			//System.out.println(pLevel);
			
		}

		return result;
    }
}