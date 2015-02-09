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
public class BSTIterator {
	private Stack<TreeNode> path_stack;

    public BSTIterator(TreeNode root) {
		path_stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p!=null) {
			path_stack.push(p);
			p = p.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !path_stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = path_stack.pop();
		if(cur.right != null) {
			//path_stack.push(cur.right);
			TreeNode p = cur.right;
			while(p!=null) {
				path_stack.push(p);
				p = p.left;
			}
		}

		return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */