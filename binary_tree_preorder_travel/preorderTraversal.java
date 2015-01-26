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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();

		if( root==null) {
			return resultList;
		}
		
		resultList.add(  new Integer(root.val) );
		
		// vist left child
		if( root.left != null) {
			resultList.addAll(preorderTraversal(root.left));
		}
		
		if( root.right != null) {
			resultList.addAll(preorderTraversal(root.right));
		}
		
		/*Integer tmp = new Integer(root.val);
		List<Integer> tmpI = new ArrayList<Integer>();
		tmpI.add(tmp);
		resultList.addAll( tmpI);*/
		
		
		return resultList;
    }
}