package leetcode.无重复字符的最长子串;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution {


    /**
     * 暴力遍历所有的子串，然后从里面找不重复的字串的长度 找到最大的
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        char[] a = s.toCharArray();
        int max = 0;
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {
                if (hashMap.get(String.valueOf(a[j])) != null) {
                    hashMap.clear();
                    hashMap.put(String.valueOf(a[j]), "");
                } else {
                    hashMap.put(String.valueOf(a[j]), "");
                    if (max < hashMap.size()) {
                        max = hashMap.size();
                    }
                }
            }

            hashMap.clear();

        }


        return max;
    }


    /**
     * 使用了一定的优化  避开了重复的比较 n
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }

        char[] a = s.toCharArray();
        int max = 0;
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        for (int i = 0; i < a.length; i++) {

            if (hashMap.get(String.valueOf(a[i])) != null) {
                //重新定位i的位置
                i = next(i, s, hashMap) - 1;
                hashMap.clear();
            } else {
                hashMap.put(String.valueOf(a[i]), String.valueOf(i));
                if (max < hashMap.size()) {
                    max = hashMap.size();
                }
            }
        }

        return max;
    }


    static int next(int i, String s, LinkedHashMap<String, String> hashMap) {
        String s1 = "";
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            s1 += stringStringEntry.getKey();
        }


        String s2 = s.substring(i, s.length());
        char[] sc1 = s1.toCharArray();
        char[] sct = s2.toCharArray();

        int j = 0;
        //找到两个字串相同的位置
        while (sc1[j] != sct[0]) {
            j++;
            if (j > sc1.length || j > sct.length) {
                return i;
            }
        }

        for (int i1 = j, i2 = 0; i1 < sc1.length && i2 < sct.length; i1++, i2++) {
            //在字串相同的位置继续查找
            if (sc1[i1] != sct[i2]) {
                return Integer.valueOf(hashMap.get(String.valueOf(sc1[i1])));
            }
        }
        return i;
    }


    /**
     * 滑动窗口完善版本
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            //如果以前出现过 则重置位置
            if (map.containsKey(s.charAt(i))) {
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);

        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("ohvhjdml"));
    }
}
