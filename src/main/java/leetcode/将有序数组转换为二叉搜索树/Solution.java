package leetcode.将有序数组转换为二叉搜索树;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
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
     * 平衡二叉树：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
     * 二叉搜索树：
     * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 任意节点的左、右子树也分别为二叉查找树；
     * 没有键值相等的节点。
     * <p>
     * <p>
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 这个题目里面， 二叉搜索树，其中序遍历就是一个有序的数组，刚好满足要求， 而要求平衡
     * 那么就选取数组的中点作为二叉树的根点 然后构建二叉树即可
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        int min = 0;
        int max = nums.length;


        TreeNode root = buildSorted(nums, min, max);
        return root;
    }

    public static TreeNode buildSorted(int[] nums, int min, int max) {
        if (min >= max) {
            return null;

        }
        int mid = (max + min) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //注意这里的边界情况，包括左边界，不包括右边界。
        root.left = buildSorted(nums, min, mid );
        root.right = buildSorted(nums, mid + 1, max);
        return root;
    }


    public  static void midOrder(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        midOrder(treeNode.left);
        System.out.print(treeNode.val+" ");
        midOrder(treeNode.right);
    }


    public static void main(String[] args) {
        int[] a = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(a);
        midOrder(treeNode);
    }
}
