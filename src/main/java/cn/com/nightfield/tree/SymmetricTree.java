package cn.com.nightfield.tree;

/**
 * @author: zhochi
 * @create: 2021/5/8
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 **/
public class SymmetricTree {
    public boolean solution(TreeNode root) {
        // boundary check
        if (root == null) {
            return false;
        }

        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        else if (left == null && right == null) {
            return true;
        }

        return left.val == right.val && isEqual(left.right, right.left) && isEqual(left.left, right.right);
    }
}
