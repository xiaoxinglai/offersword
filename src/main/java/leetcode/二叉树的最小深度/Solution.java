package leetcode.二叉树的最小深度;

/**
 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回它的最小深度  2


 */
public class Solution {

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    /**
     * 最小深度
     *思路：
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return 0;
    }

}
