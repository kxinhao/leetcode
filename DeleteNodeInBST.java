/*
 * LeetCode 450 Delete Node in a BST (Medium)
 * recursion soln, replaces value of Node
 * TC: O(H), worst case O(N)
 * SC: O(1)
 */

// 7th impl
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key<root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key>root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else {
                TreeNode min = root.right;
                // select leftmost value(min) of right subtree
                while(min.left!=null) min = min.left;
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
                return root;
            }
        }
    }
// node reconnection instead of value swap, same TC: O(H), SC: O(1)
/*
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode newRoot = root.right, par = null;
                while(newRoot.left != null){
                    par = newRoot;
                    newRoot = newRoot.left;
                }
                if(par == null){
                    newRoot.left = root.left;
                    return newRoot;
                }
                par.left = newRoot.right;
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        return root;
    }
*/
}
