import java.util.*;
public class solution {
	public static List<Integer> postorderTraversal(TreeNode root) {
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
		
		/*Integer tmp = new Integer(root.val);
		List<Integer> tmpI = new ArrayList<Integer>();
		tmpI.add(tmp);
		resultList.addAll( tmpI);*/
		resultList.add(  new Integer(root.val) );
		
		return resultList;
    }
}