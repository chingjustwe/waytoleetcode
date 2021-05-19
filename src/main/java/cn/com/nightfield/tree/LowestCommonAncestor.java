package cn.com.nightfield.tree;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 **/
public class LowestCommonAncestor {
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);

        if (left != null && right != null) {
            // found target node
            return root;
        }
        else if (left != null) {
            return left;
        }
        else {
            return right;
        }
    }
}
