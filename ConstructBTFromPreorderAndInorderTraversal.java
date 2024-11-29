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

// 4th impl
// eg. preorder = [3,9,20,15,7]
//     inorder = [9,3,15,20,7]
class Solution {
    // map to store index of each inorder array value
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++) inorderMap.put(inorder[i],i);
        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
   }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        // subtree root node formed from preorder array preStart index element
        // starting from preorder[0]
        TreeNode root = new TreeNode(preorder[preStart]);
        // subtree root index from inorder array
        // left of rootInd will be left subtree, right will be right subtree
        int rootInd = inorderMap.get(root.val);
        // num of left nodes is derived from root index - subtree inorder start ind
        int leftNodes = rootInd - inStart;
        // build left and right nodes based off root
        // build left subtree, restricting range to only left subtree nodes
        // for preorder, preStart+1 as start ind and preStart + num of left nodes as end ind
        // for inorder, inStart as start ind and rootInd-1 as end ind
        // eg. root.left = build(preorder, 1, 1, inorder, 0, 0);
        root.left = build(preorder, preStart+1, preStart+leftNodes, inorder, inStart, rootInd-1);
        // build right subtree, restricting range to only right subtree nodes
        // for preorder, preStart+leftNodes+1 as start ind and preEnd as end ind
        // for inorder, rootInd+1 as start ind and inEnd as end ind
        // eg. root.right = build(preorder, 2, 4, inorder, 2, 4);
        root.right = build(preorder, preStart+leftNodes+1, preEnd, inorder, rootInd+1, inEnd);
        return root;
    }
}
