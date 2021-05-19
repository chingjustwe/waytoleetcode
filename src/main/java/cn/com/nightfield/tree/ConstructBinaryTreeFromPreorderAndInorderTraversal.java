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

    private TreeNode build(Map<Integer, Integer> inIndexMap, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootValue = preorder[preLeft];
        int rootIndex = inIndexMap.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inIndexMap, preorder, inorder, preLeft + 1, preLeft + rootIndex - inLeft, inLeft, rootIndex - 1);
        root.right = build(inIndexMap, preorder, inorder, preLeft + rootIndex - inLeft + 1, preRight, rootIndex + 1, inRight);
        return root;
    }
}
