package leetcode.罗马数字转整数;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution {

    public static int romanToInt(String s) {
        //将所有可能的罗马数字组合都写到字典里，然后遍历每个元素，去字典里面查找对应的值，有则取出来
        //假如没有那几条特殊的规则，就是最简单的文字转换。那像XIV这样就可以直接转换为10+1+5=16
        //注意：这是我们的整体思路，即字符的转换。

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int pre = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            //IV IX  XL XC  CD CM 等特殊值的处理
            //会发现 右边数字是左边数字的5倍或者10倍的时候，就要特殊处理 此时的值为当前值减去2倍的前一个值
            //比如说IV 为 1+5-2 值为4
            //iX为  1+10-2 为9
            //为什么会这样，因为当前总值已经包含了一个之前值，所以要减去， 然后现在的这个值也等于当前这个字符代表的值减去它前一个字符代表的值
            current = map.get(c);
            if (pre != 0) {
                if (current / pre == 5 || current / pre == 10) {
                    res = res + (current - pre) - pre;
                    pre = current;
                    continue;
                }
            }
            res = current + res;
            pre = current;
        }

        return res;
    }

    public static void main(String[] args) {


         int a = 0;

        ArrayList list = new ArrayList();
        



        System.out.println(romanToInt("MCMXCIV"));
    }
}
