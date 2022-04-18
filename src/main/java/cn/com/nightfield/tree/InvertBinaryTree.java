package cn.com.nightfield.tree;

/**
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 思路：
 * 递归，可以用前序遍历和后序遍历，但不能用中序遍历，会导致重复翻转。
 *
 * @author: zhochi
 * @create: 2022/4/18
 *
 **/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
