/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
		if(root == null) return;
		
		while(root!=null){
			if(root.left!=null) {
				TreeNode pLeft = root.left;
				while(pLeft.right!=null) pLeft=pLeft.right;
				pLeft.right = root.right;
				root.right = root.left;
				root.left = null;
				
			}
			root = root.right;
		}
        
    }
}