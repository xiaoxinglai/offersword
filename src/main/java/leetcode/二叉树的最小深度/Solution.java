package leetcode.二叉树的最小深度;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2
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
     * 最小深度
     * 思路： root节点的最小深度 = min（左子树高度，右子树高度）
     *如果只有单一子树不为空， 那么只要计算那边的子树的高度就好了
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right == null) {

            return 1 + minDepth(root.left);
        }

        if (root.right != null && root.left == null) {

            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }


}
