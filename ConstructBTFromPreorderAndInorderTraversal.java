/**
 * LeetCode 105 Construct BT from Preorder and Inorder Traversal (Medium)
 * preorder traversal: root, left, right
 * inorder traversal: left, root, right
 * Construction using principle that first node in preorder traversal is always subtree root,
 * thus we build the BT subtree root by subtree root while shifting the context the subtree is in
 * TC: O(N), SC: O(N) using recursion. full traversal of inorder/preorder trees needed and space
 * needed is directly proportional to length of the arrays
 * preorder first element is always root, can be used to derive num of left/right nodes in inorder
 * beginning of right subtree for curr node in the preorder can be derived using:
 *   preStart + numsOnLeft + 1 (eg. 0+1+1=2)
 * where numsOnLeft = root - inStart
 * exceeding the context window means the child node is null
 */

// 8th impl
// eg. preorder = [3,9,20,15,7]
//     inorder = [9,3,15,20,7]
class Solution {

    // for quick node ind reference from value, can only be used due to constraint
    // preorder and inorder arrays all contain unique values
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++) inorderMap.put(inorder[i],i);
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        // subtree root node formed from preorder array preStart index element
        TreeNode root = new TreeNode(preorder[preStart]);
        // retrieve subtree root index from inorderMap
        // left of rootInd in inorder will be left subtree, right will be right subtree
        int rootInd = inorderMap.get(root.val);
        // leftNodes count is used to contextualize where left subtree ends and right subtree begins
        int leftNodes = rootInd - inStart;
        // build left subtree, restricting range to only left subtree nodes
        // for preorder, left subtree starts at preStart+1 and ends at preStart+leftNodes
        // for inorder, left subtree starts at inStart and ends at rootInd-1
        // eg. root.left = build(preorder, 1, 1, inorder, 0, 0);
        root.left = build(preorder, preStart+1, preStart+leftNodes, inorder, inStart, rootInd-1);
        // build right subtree, restricting range to only right subtree nodes
        // for preorder, preStart+leftNodes+1 as start ind and preEnd as end ind
        // for inorder, rootInd+1 as start ind and inEnd as end ind
        // eg. root.right = build(preorder, 2, 4, inorder, 2, 4);
        // all +/- 1 is to account for root node
        root.right = build(preorder, preStart+leftNodes+1, preEnd, inorder, rootInd+1, inEnd);
        return root;
    }
}
