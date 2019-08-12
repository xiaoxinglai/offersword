package leetcode.最长公共前缀;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {

    public static void main(String[] args) {

        String  s="a12a";
        System.out.println(s.indexOf("12"));

        String[] str = new String[]{"aa", "a"};
        String res = longestCommonPrefix(str);
        System.out.println(res);
    }

    /**
     * 思路： 先找到最短的字符串 然后遍历最短的字符串的长度次数的循环，
     * 里面挨个去取每个字符串的元素，遇到不相等的就返回
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String shorts = strs[0];
        for (String str : strs) {
            if (str.length() < shorts.length()) {
                shorts = str;
            }
        }

        String res = "";

        int len = shorts.length();
        char[] s = shorts.toCharArray();

        for (int i = 0; i < len; i++) {

            for (String str : strs) {
                if (str.toCharArray()[i] != s[i]) {
                    return res;
                }
            }

            res = res + s[i];
        }

        return res;
    }


    /**
     * 优化写法
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //找出最短的
        String shorts = strs[0];
        for (String str : strs) {
            if (str.length() < shorts.length()) {
                shorts = str;
            }
        }

        //indexOf会返回子串的第一个位置的索引，因为是前缀 所以必定返回0
        for (String str : strs) {
            while (str.indexOf(shorts) != 0) {
                shorts = shorts.substring(0, shorts.length() - 1);
            }

        }

        return shorts;


    }


}
