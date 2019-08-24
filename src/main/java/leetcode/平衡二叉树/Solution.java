package leetcode.平衡二叉树;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
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
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
     * <p>
     * root节点的高度差为 左子树的高度减去右子树的高度
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //当前节点的两个子树差是不是大于2 与上 当前节点的左子树的的子节点高度差是不是大于2 与上 前节点的右子树的的子节点高度差是不是大于2
        return Math.abs(height(root.left)-height(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);
    }


    /**
     * 求最大深度
     * @param root
     * @return
     */
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }


}
