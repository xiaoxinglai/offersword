package leetcode.x的平方根;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution {

    public static void main(String[] args) {
        int a = mySqrt2(9);
        System.out.println(a);
    }

    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        double a = 0;
        double low = 0;
        double max = x;

        if (x == 0 || x == 1) {
            return x;
        }

        /**
         * 精度很重要6位小数点后，再后面就不准了
         * 其次是二分法的上下界更新是用mid去更新的每次
         */
        while (Math.abs(a * a - x) > 0.000001) {
            a = (low + max) / 2;
            if (a * a > x) {
                max = a;
            } else {
                low = a;
            }

        }
        return (int) a;
    }


    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {

        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }


}
