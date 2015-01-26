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
    public List<Integer> postorderTraversal(TreeNode root) {
        // base case: leaf, return
		
		List<Integer> resultList = new ArrayList<Integer>();

		if( root==null) {
			return resultList;
		}
		
		// vist left child
		if( root.left != null) {
			resultList.addAll(postorderTraversal(root.left));
		}
		
		if( root.right != null) {
			resultList.addAll(postorderTraversal(root.right));
		}
		
		resultList.addAll( new ArrayList<Integer>( new Integer(root.val) ));
		
		return resultList;
    }
}