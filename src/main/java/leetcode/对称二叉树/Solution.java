package leetcode.对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
     * 思路：
     * 如果互为镜像  那么就会出现，a的左子树等于b的右子树   a的右子树等于b的左子树
     * 递归比较
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.right == null && root.left == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return equalTree(root.left, root.right);

    }

    public boolean equalTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.val == t2.val) && equalTree(t1.right, t2.left) && equalTree(t1.left, t2.right);
    }


    /**
     * 链表先序构建二叉树
     */
    TreeNode creat(LinkedList<Integer> linkedList) {

        TreeNode treeNode = new TreeNode(linkedList.removeFirst());
        treeNode.left = creat(linkedList);
        treeNode.right = creat(linkedList);
        return treeNode;

    }


    /**
     * 思路：
     * 如果互为镜像  那么就会出现，a的左子树等于b的右子树   a的右子树等于b的左子树
     * 利用队列替代递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetricStack(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.right == null && root.left == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 =  queue.poll();
            TreeNode t2 =  queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }


        return true;

    }

    public static void main(String[] args) {


    }
}
