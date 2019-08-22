package leetcode.二叉树的层次遍历;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Solution {


    /**
     * 层次遍历 ，然后倒序
     * 难点在于知道自己的层数 通过size记录每一层元素个数完成
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            size = queue.size();
            result.add(list);
        }

        Collections.reverse(result);
        //倒序也可以全放栈里，然后倒出来
        return result;
    }



    /**
     * 层次遍历 递归解法
     * 每个节点将自己的值放到该节点所在层数对应的列表里面
     * 然后每个节点的左子树 将自己的值放到层数+1对应的列表里面
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        count(root,0,result);
        Collections.reverse(result);
        return result;
    }

    public void count(TreeNode root,int dept ,List<List<Integer>> result) {

        if (root==null){
            return;
        }

        //深度大于列表长度
        if (dept+1>result.size()){
            List<Integer> list=new ArrayList<>();
            result.add(list);
        }

        result.get(dept).add(root.val);

        count(root.left,dept+1,result);
        count(root.right,dept+1,result);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
