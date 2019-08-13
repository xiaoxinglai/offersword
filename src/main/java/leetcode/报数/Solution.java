package leetcode.报数;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class Solution {

    /**
     * 这道题难在哪里？难在看不懂题！重新解释一遍题目：
     * 生活中有很多种序列，比如斐波那契爱吃兔子数列，这个报数序列也是一种序列，不过这个「报数」不是体育课上那种报数，而是「下一项对上一项以计数方式（count）进行报读（say）」的报数。
     * 约定第一项为1，那么第二项就是念出第一项“一个一”即11，第三项就是念出第二项“两个一”即21，以此类推。那么我们可以知道，每一项都是“几个几 几个几 几个几”的形式。所以编程也就很简单了，递归+遍历即可
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        //获取前一个数字
        String pre = countAndSay(n - 1);

        //对前一个进行处理得到现在的
        char[] c = pre.toCharArray();
        String res = "";


        char i = c[0];
        //出现次数
        int count = 0;
        //通项公式为 出现次数+数字
        for (char c1 : c) {
            if (i == c1) {
                count++;
            } else {
                res = res + count + i + "";
                count = 1;
                i = c1;
            }
        }

        return res + count + i + "";
    }

    public static void main(String[] args) {
        String str = countAndSay(4);
        System.out.println(str);
    }


}
