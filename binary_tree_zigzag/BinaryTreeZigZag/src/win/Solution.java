package win;

import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
		
		ArrayList<Integer> pLevel = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if(root == null) return result;
		
		//result.add(pLevel);
		Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
		queueNode.add(root);
		int level = 1;

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			LinkedList<TreeNode> stack_new = new LinkedList<TreeNode> ();
			pLevel = new ArrayList<Integer>();
			while(!stack.isEmpty()) {
				TreeNode pTree = stack.pop();
				
				pLevel.add(pTree.val);
				
				//System.out.println(pLevel);
				
				if(level %2==1) {
					if(pTree.left != null) {
						stack_new.push(pTree.left);
					}
					if(pTree.right != null) {
						stack_new.push(pTree.right);
					}
				} else {
					if(pTree.right != null) {
						stack_new.push(pTree.right);
					}
					if(pTree.left != null) {
						stack_new.push(pTree.left);
					}
				}
			}
			
			stack = stack_new;
			
			level ++;
			
			result.add(pLevel);
			
			//System.out.println(result);
		}

		return result;
    }
}