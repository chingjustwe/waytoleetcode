package cn.com.nightfield.tree;

import cn.com.nightfield.tree.TreeNode;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为： 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 **/
public class BalancedBinaryTree {
    public boolean solution(TreeNode root) {
        int height = treeHeight(root);
        return height >= 0;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightLeft = treeHeight(root.left);
        int heightright = treeHeight(root.right);

        if (heightLeft == -1 || heightright == -1 || Math.abs(heightLeft - heightright) > 1) {
            return -1;
        }
        return Math.max(heightLeft, heightright) + 1;
    }
}
