package cn.com.nightfield.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/5/11
 **/
public class BinaryTreeInorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
