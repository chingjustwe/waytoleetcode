package cn.com.nightfield.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 **/
public class ZigzagLevelOrder {
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.add(root);
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            List<Integer> temp;
            if (!deque2.isEmpty()) {
                temp = new LinkedList<>();
                while (!deque2.isEmpty()) {
                    TreeNode node = deque2.pop();
                    temp.add(node.val);
                    // 从右往左放下一层元素
                    if (node.right != null) {
                        deque1.push(node.right);
                    }
                    if (node.left != null) {
                        deque1.push(node.left);
                    }
                }
                result.add(temp);
            }

            if (!deque1.isEmpty()) {
                temp = new LinkedList<>();
                while (!deque1.isEmpty()) {
                    TreeNode node = deque1.pop();
                    temp.add(node.val);
                    // 从左到右放下一层元素
                    if (node.left != null) {
                        deque2.push(node.left);
                    }
                    if (node.right != null) {
                        deque2.push(node.right);
                    }
                }
                result.add(temp);
            }
        }

        return result;
    }
}
