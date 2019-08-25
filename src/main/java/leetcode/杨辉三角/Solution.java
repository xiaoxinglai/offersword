package leetcode.杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * [118] 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Solution {

    /**
     * 思路：如果知道一行，就可以推算出下一行的数据
     * 这个算作动态规划，因为每一行都依赖了上一行的数据
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> trangle = new ArrayList<>();
        if (numRows == 0) {
            return trangle;
        }

        trangle.add(new ArrayList<>());
        //给第一行赋值1
        trangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            trangle.add(new ArrayList<>());
            trangle.get(i).add(1);

            List<Integer> sec = trangle.get(i - 1);
            for (int j = 0; j+1 < sec.size(); j++) {
                trangle.get(i).add(sec.get(j)+sec.get(j+1));
            }

            trangle.get(i).add(1);
        }

        return trangle;
    }
}
