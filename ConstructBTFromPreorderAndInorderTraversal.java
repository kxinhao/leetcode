/**
 * LeetCode 105 Construct BT from Preorder and Inorder Traversal (Medium)
 * TC: O(N), SC: O(N) using recursion
 * root found from preorder first element can be used to derive num of left/right nodes in
 * inorder arr as the splitting index
 * ind of right child for curr node in the preorder arr can be derived from:
 *      preStart ind + numsOnLeft +1 
 * where numsOnLeft = root - inStart
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 2nd impl
class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++) inorderMap.put(inorder[i],i);
        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
   }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInd = inorderMap.get(root.val);
        int leftNodes = rootInd - inStart;
        root.left = build(preorder, preStart+1, preStart+leftNodes, inorder, inStart, rootInd-1);
        root.right = build(preorder, preStart+leftNodes+1, preEnd, inorder, rootInd+1, inEnd);
        return root;
    }
}
