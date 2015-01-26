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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        TreeNode result = recurBuild(inorder, postorder, 0, inorder.length-1,
                                     0, postorder.length-1);
        return result;
    }
    
    private TreeNode recurBuild(int[] inorder, int[] postorder,
                                int instart, int inend,
                                int postart, int poend) {
        
        
        // base case
        if(instart>inend || postart>poend) {
            return null;
        }
        // other case
        int root_val = postorder[poend];
        TreeNode root = new TreeNode( root_val );
        // find proper index
        int i=0;
        for(i=instart; i<inend; i++) {
            if( inorder[i] == root_val ) {
                break;
            }
        }
        
        root.left = recurBuild(inorder, postorder, instart, i-1,
                               postart, postart+i-instart-1);
        
        root.right = recurBuild(inorder, postorder, i+1, inend,
                                postart+i-instart, poend-1);
        return root;
        
    }
}