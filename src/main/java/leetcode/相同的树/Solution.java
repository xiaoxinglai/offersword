package leetcode.相同的树;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class Solution {


    /**
     * 时间复杂度 : O(N)O(N)，其中 N 是树的结点数，因为每个结点都访问一次。

     空间复杂度 : 最优情况（完全平衡二叉树）时为 O(\log(N))O(log(N))，最坏情况下（完全不平衡二叉树）时为 {O}(N)O(N)，用于维护递归栈。
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p != null && q == null) {
            return false;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q != null) {

            if (p.val == q.val) {
                boolean left = isSameTree(p.left, q.left);
                if (!left) {
                    return false;

                }
                boolean right = isSameTree(p.right, q.right);
                if (!right){
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }


    /**
     * 优化写法
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        //说明到了叶子节点
        if (q==null&&p==null){
            return true;
        }
        //说明有一侧节点不存在
        if (q==null||p==null){
            return false;
        }

        //节点值不同
        if (q.val!=p.val){
            return false;
        }

        return  isSameTree2(p.left,q.left)&&isSameTree2(p.right,q.right);
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 构建一个二叉树
     *
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        //用递归的形式构建树，其实和先序遍历的顺序是一样的
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(new Integer[]{1, 2}));

        TreeNode p = Solution.createBinaryTree(linkedList);
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>(Arrays.asList(new Integer[]{1, null, 2}));

        TreeNode q = Solution.createBinaryTree(linkedList2);

        System.out.println(isSameTree(p, q));

    }
}
