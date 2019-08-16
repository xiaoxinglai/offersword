package leetcode.二进制求和;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution {


    /**
     * 逢1进1 返回10
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        char[] op1 = a.toCharArray();
        char[] op2 = b.toCharArray();

        char[] big = null;
        char[] sm = null;
        if (op1.length > op2.length) {
            big = op1;
            sm = op2;
        } else {
            big = op2;
            sm = op1;
        }


        //进位数
        int t = 0;
        int i = 0;
        while (t != 0 || i < big.length) {
            t = sum(big, sm, i, t);
            i++;
            if (i == big.length) {
                break;
            }
        }

        if (t == 1) {
            char[] newbig = new char[big.length + 1];
            for (int i1 = 0; i1 < big.length; i1++) {
                newbig[i1 + 1] = big[i1];
            }
            newbig[0] = '1';
            return String.valueOf(newbig);

        }

        return String.valueOf(big);

    }


    /**
     * @param big 大数
     * @param sm  小数
     * @param i   位置
     * @param t   进位数
     * @return
     */
    private static int sum(char[] big, char[] sm, int i, int t) {
        int tag = 0;
        if (i < sm.length) {
            tag = big[big.length - 1 - i] - '0' + sm[sm.length - 1 - i] - '0' + t;
        } else {
            tag = big[big.length - 1 - i] - '0' + t;
        }
        big[big.length - 1 - i] = (char) ('0' + tag % 2);
        if (tag > 1) {
            return 1;
        } else {
            return 0;
        }

    }


    public static void main(String[] args) {
        String sum = addBinary("1010", "1011");
        System.out.println(sum);
    }


    /**
     * 利用字符串的charAt和reverse简化以上的实现
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        //长度
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        //是否需要进一位
        int plus = 0;

        while (i >= 0 || j >= 0) {
            //单个位数的和
            int sum = 0;

            //交换律和结合律
            if (i >= 0) {
                sum = sum + (a.charAt(  i) - '0');
                i--;
            }
            if (j >= 0) {
                sum = sum + (b.charAt( j) - '0');
                j--;
            }

            //和加上进一位
            sum = sum + plus;
            //记录当前位置数的值
            int curr = sum % 2;
            sb.append(curr);
            plus = sum / 2;
        }

        if (plus == 1) {

            sb.append(plus);
        }
        return sb.reverse().toString();
    }
}
