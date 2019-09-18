package leetcode.最小覆盖子串;

import java.util.*;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution {

    public static String minWindow(String s, String t) {

        if (t.length()>s.length()){
            return "";
        }


        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            if (tmap.get(a) != null) {
                tmap.put(a, tmap.get(a) + 1);
            } else {
                tmap.put(a, 1);
            }
        }

        //1.从第一个位置开始遍历和子串字符匹配，如果不满足，则扩大窗口右边 直到满足
        //2.记录下这个子串
        //3.此时收缩左边，如果满足则继续收缩，直到不满足，记录下这个子串，右边继续扩大，直到满足
        //4.然后重复3  直到右边达到最大长度
        int left = 0;
        int right = 0;
        int min=s.length();


        String child = "";

        LinkedHashMap<Character, Integer> smap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (smap.get(a) != null) {
                smap.put(a, smap.get(a) + 1);
            } else {
                smap.put(a, 1);
            }

            if (checkMap(tmap, smap)) {
                //相等 说明已经找到了满足的子串

                right = i;

                //收缩左边
                while (checkMap(tmap, smap)){
                   if (smap.get(s.charAt(left))>1){
                       smap.put(s.charAt(left),smap.get(s.charAt(left))-1);
                   }else {
                       smap.remove(s.charAt(left));
                   }
                   left++;
                }

                if (min>right-left){
                    String s1=s.substring( left-1,right + 1);
                    System.out.println("子串："+s1);
                    if (child==""){
                        child= s1;
                    }else {
                        if (child.length()>s1.length()){
                            child=s1;
                        }
                    }
                    min=right-left;
                }
            }
        }

        if (right==left&&left==0){
            return "";
        }
        return child;
    }


    static boolean checkMap(HashMap<Character, Integer> tmap, HashMap<Character, Integer> smap) {
        for (Map.Entry<Character, Integer> kv : tmap.entrySet()) {
            if (smap.get(kv.getKey())==null||smap.get(kv.getKey())<kv.getValue()){
                return  false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        //cwae
    }
}
