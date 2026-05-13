package cn.com.nightfield.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhochi
 * @create: 2021/5/12
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        TreeNode result = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[] {1, 2}, new int[] {1, 2});
        System.out.println(result);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return build(inIndexMap, preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> inIndexMap, int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }

        int rootValue = preorder[pStart];
        int rootIndex = inIndexMap.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inIndexMap, preorder, inorder, pStart + 1, pStart + rootIndex - iStart, iStart, rootIndex - 1);
        root.right = build(inIndexMap, preorder, inorder, pStart + rootIndex - iStart + 1, pEnd, rootIndex + 1, iEnd);
        return root;
    }
}
