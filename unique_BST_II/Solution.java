import java.util.*;
// how to handle null pointer in java??
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> ret = recurGenTree(1, n);
		return ret;
    }

	public ArrayList<TreeNode> recurGenTree( int l, int r ) {
		// create tree based on the nodes from l to (r-1)
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		
		if(l>r) {
			ret.add(null);
			return ret;
		}

		for(int i=l; i<=r; i++) {

			ArrayList<TreeNode> l_children = recurGenTree(l, i-1);
			ArrayList<TreeNode> r_children = recurGenTree(i+1, r);

			for( int ii =0; ii<l_children.size(); ii++) {
				for(int jj =0; jj<r_children.size(); jj++) {
					TreeNode root = new TreeNode(i);
					root.left = l_children.get(ii);
					root.right = r_children.get(jj);
					ret.add(root);
				}
			}
		}
		return ret;
	}
}