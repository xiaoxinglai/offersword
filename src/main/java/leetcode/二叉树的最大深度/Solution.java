package leetcode.二叉树的最大深度;

import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Solution {


    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    /**
     * 思路： 递归
     * 最高的高度为: root根节点的最大高度为1+max(左子树高度，右子树高度)
     * 依次类推
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }




//    /**
//     * 利用栈替代之前的递归
//     *
//     * @param root
//     * @return
//     */
//    public int maxDepth2(TreeNode root) {
//        Stack<TreeNode> stack = new Stack();
//
//        stack.push(root);
//        int n = 0;
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (node == null) {
//                n = n + 0;
//            }
//
//            stack.push(node.left);
//            stack.push(node.right);
//
//
//        }
//
//
//        return n;
//    }


}
