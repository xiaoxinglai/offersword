package leetcode.加一;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution {

    public static void main(String[] args) {
        int[] aa = new int[]{1, 9, 9, 9};
        int[] res = plusOne2(aa);
        for (int re : res) {
            System.out.print(re);
        }
    }

    /**
     * 思路：
     * 递归 在9+1的时候返回10
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        while (plus(digits, i) == 0) {
            i--;
            if (i == -1) {
                int[] c = new int[digits.length + 1];
                c[0] = 1;
                return c;
            }
        }
        return digits;
    }

    static int plus(int[] digits, int i) {
        if (digits[i] < 9) {
            digits[i] = digits[i] + 1;
        } else {
            digits[i] = 0;
        }
        return digits[i];
    }


    /**
     * 简化版的二进制求和
     */
    public static int[] plusOne2(int[] digits) {

        int i = digits.length - 1;
        int plus = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int sum = 0;
            if (i == digits.length - 1) {
                sum = digits[i] + 1 + plus;
            } else {
                sum = digits[i] + plus;
            }
            sb = sb.append(sum % 10);
            plus = sum / 10;
            i--;
        }

        if (plus == 1) {
            sb = sb.append("1");
        }

        char[] res = sb.reverse().toString().toCharArray();
        int[] intres = new int[res.length];
        for (int i1 = 0; i1 < res.length; i1++) {
            intres[i1] = res[i1] - '0';
        }
        return intres;
    }
}
