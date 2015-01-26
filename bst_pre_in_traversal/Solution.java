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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode result = recurBuild(preorder, inorder, 0, preorder.length-1,
                                     0, inorder.length-1);
        return result;
    }
    
    private TreeNode recurBuild(int[] preorder, int[] inorder,
                                int preStart, int preEnd,
                                int inStart, int inEnd) {
        
        
        // base case
        if(preStart>preEnd || inStart>inEnd) {
            return null;
        }
        // other case
        int root_val = preorder[preStart];
        TreeNode root = new TreeNode( root_val );
        // find proper index
        int i=0;
        for(i=inStart; i<inEnd; i++) {
            if( inorder[i] == root_val ) {
                break;
            }
        }
        
        root.left = recurBuild(preorder, inorder, preStart+1, preStart + i-inStart,
                               inStart, i-1);
        
        root.right = recurBuild(preorder, inorder, preStart+i-inStart+1, preEnd,
                                i+1, inEnd);
        return root;
        
    }
}