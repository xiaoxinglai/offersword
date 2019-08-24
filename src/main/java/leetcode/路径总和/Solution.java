package leetcode.路径总和;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 思路 深度搜索 且累计和判断
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //目标值减去当前值
        sum = sum - root.val;
        //如果两个子树都存在，则两个有一个路径为true 就返回true
        if (root.left != null && root.right != null) {
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }

        //如果只有单子树，就找这个单子树
        if (root.left != null) {
            return hasPathSum(root.left, sum);
        } else  if (root.right != null){
            return hasPathSum(root.right, sum);
        }

        //遍历完的时候，刚好sum值递减为0，则返回true 说明累计和为0
        if (sum == 0) {
            return true;
        } else {
            return false;
        }


    }


    public static void main(String[] args) {
        Integer[] res = new Integer[]{-2,null,-3};
        int tar = -2;
        TreeNode node = build(res, 0);
        System.out.println(hasPathSum(node, tar));

    }


    static TreeNode build(Integer[] res, int index) {
        if (index >= res.length) {
            return null;
        }

        if (res[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(res[index]);
        root.left = build(res, 2 * index + 1);
        root.right = build(res, 2 * index + 2);
        return root;
    }

}
