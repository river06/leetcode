package hw;

public class Solution {
	public static List<Integer> inorderTraversal(TreeNode root) {
        // base case: leaf, return
		
		List<Integer> resultList = new ArrayList<Integer>();

		if( root==null) {
			return resultList;
		}
		
		// vist left child
		if( root.left != null) {
			resultList.addAll(inorderTraversal(root.left));
		}

		resultList.add(  new Integer(root.val) );
		
		if( root.right != null) {
			resultList.addAll(inorderTraversal(root.right));
		}
		
		/*Integer tmp = new Integer(root.val);
		List<Integer> tmpI = new ArrayList<Integer>();
		tmpI.add(tmp);
		resultList.addAll( tmpI);*/
		
		
		return resultList;
    }
}