package leetcode.整数反转;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 */
public class Solution {

    //利用数学上的知识
    //123 = 1*100+2*20+3
    //321=3*100+2*20+1

    //思路： 一次弹出数字x的最后一个数字，（即对10取模）  然后加入到rev的最后一位上去 直到x为0为止，此时的rev就等于x的反转
    //注意点：需要判断是否溢出
    //也可以利用栈或者数组协助

    public static void main(String[] args) {
        int res = rever(0x7fffffff);
        System.out.println(res);
    }
//
//    public static int rever(int x) {
//        int rev = 0;
//        while (x != 0) {
//            //找x的最后一位
//            int r = x % 10;
//            //x去掉最后一位之后的数字
//            x = x / 10;
//            //由x的最后一位组合成的数字
//            rev = rev * 10 + r;
//
//            //这个会有问题，比如说a<Integer.MAX_VALUE
//            // 但是a+x之后就大于了Integer.MAX_VALUE 然后溢出之后变成了负数就小于了Integer.MAX_VALUE
//            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
//                return 0;
//            }
//        }
//
//        return rev;
//    }

    public static int rever(int x) {
        long rev = 0;
        while (x != 0) {
            //找x的最后一位
            int r = x % 10;
            //x去掉最后一位之后的数字
            x = x / 10;
            //由x的最后一位组合成的数字
            rev = rev * 10 + r;
        }
        //用long去比较
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
            return 0;
        }

        return (int)rev;
    }

}
