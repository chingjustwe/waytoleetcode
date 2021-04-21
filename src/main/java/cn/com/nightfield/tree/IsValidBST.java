package cn.com.nightfield.tree;

import cn.com.nightfield.tree.TreeNode;

/**
 * @author: zhochi
 * @create: 2021/4/18
 **/
public class IsValidBST {
    public boolean solution(TreeNode root) {
        boolean result = isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return result;
    }

    private boolean isValid(TreeNode root, long leftBase, long rightBase) {
        if (root == null) {
            return true;
        }

        if (root.val >= rightBase || root.val <= leftBase) {
            return false;
        }
        return isValid(root.left, leftBase, root.val)
                && isValid(root.right, root.val, rightBase);
    }
}
