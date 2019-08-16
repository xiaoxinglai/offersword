package leetcode.爬楼梯;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * <p>
 * 4
 * <p>
 * <p>
 * 1+1+1   +1
 * 1+1+2
 * 2+2
 * 2+1    +1
 * 1+2    +1
 */
public class Solution {

    public static void main(String[] args) {
        int num = climbStairs(44);
        System.out.println(num);
    }

    /**
     * 递归
     * 到达n阶， 可以是在n-1 阶后走1步， n-2 阶 后走2步
     * 所以可能性就是n-1 阶所有可能性+ n-2 阶的所有可能性
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int num = climbStairs(n - 2) + climbStairs(n - 1);
        return num;
    }


    /**
     * 加上数组暂存 来加快速度  这样的话 时间复杂度为n  空间复杂度为n
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] db = new int[n];
        int x = climbStairsN(n, db);
        return x;
    }

    public static int climbStairsN(int n, int[] db) {
        if (n == 0 || n == 1||n==2) {
            return n;
        }
        if (db[n-1]!=0){
            return db[n-1];
        }
        int num = climbStairsN(n - 2,db) + climbStairsN(n - 1,db);
        db[n-1] = num;

        return num;
    }


}
