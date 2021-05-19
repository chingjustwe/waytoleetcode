package cn.com.nightfield.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zhochi
 * @create: 2021/4/24
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 **/
public class RightSideView {
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        // helper
        Queue<TreeNode> primary = new LinkedList<>();
        Queue<TreeNode> secondary = new LinkedList<>();

        primary.offer(root);
        while (!primary.isEmpty() || !secondary.isEmpty()) {
            if (!primary.isEmpty()) {
                nextLevel(primary, secondary, result);
            }
            if (!secondary.isEmpty()) {
                nextLevel(secondary, primary, result);
            }
        }
        return result;
    }

    private void nextLevel(Queue<TreeNode> q1, Queue<TreeNode> q2, List<Integer> result) {
        for (int index = 0; !q1.isEmpty(); index++) {
            TreeNode node = q1.poll();
            // right goes first
            if (node.right != null) {
                q2.offer(node.right);
            }
            if (node.left != null) {
                q2.offer(node.left);
            }
            // add the right side node to result list
            if (index == 0) {
                result.add(node.val);
            }
        }
    }
}
