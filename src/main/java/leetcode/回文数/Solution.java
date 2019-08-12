package leetcode.回文数;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {


    public static void main(String[] args) {

        System.out.println(isPalindrome(0));
    }

    //思路 利用整数反转里面的思路，先转整数进行反转，反转之后的数如果和之前的数相同 ，则说明数回文数
    //注意 0也是回文数
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x!=0&&x % 10 == 0)) {
            return false;
        } else {
            if (x == revers(x)) {
                return true;

            } else {
                return false;
            }
        }
    }


    /**
     * 整数反转
     * 先一步步获取x的最后一位，再一步步将最后一位按位数累计起来
     * @param x
     * @return
     */
    public static int revers(int x) {
        int r=0;
        while(x!=0){
            int res=x%10;
            x=x/10;
            r=r*10+res;
        }
        return r;
    }


}
