package leetcode.返回杨辉三角的第k行;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class Solution {

    /**
     * 思路：不再需要保存所有的数，只需当前行和上一行
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tag = new ArrayList<>();
        tag.add(1);

        if (rowIndex == 0) {
            return tag;
        }

        for (int i = 1; i <= rowIndex; i++) {
            int size = tag.size();

            List<Integer> newtag = new ArrayList<>();
            newtag.add(1);

            for (int j = 0; j + 1 < size; j++) {
                newtag.add(tag.get(j) + tag.get(j + 1));
            }

            newtag.add(1);
            tag = newtag;
        }
        return tag;
    }




    /**
     * 思路：不再需要保存所有的数，只需当前行和上一行
     *  上面代码的优化版本，不需要在每个循环里面都创建对象 都在同一个数组里面操作
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> tag = new ArrayList<>();
        tag.add(1);

        if (rowIndex == 0) {
            return tag;
        }

        for (int i = 1; i <= rowIndex; i++) {
            int size = tag.size();
            int pre=1;
            for (int j = 0; j + 1 < size; j++) {
                int  newPre=tag.get(j+1);
                tag.set(j+1,pre+tag.get(j+1));
                pre=newPre;
            }

            tag.add(1);
        }
        return tag;
    }


}
