package leetcode.easy.twoSum;

import java.util.HashMap;

/**
 * @ClassName twoSum
 * @Author laixiaoxing
 * @Date 2019/3/20 下午2:26
 * @Description TODO
 * @Version 1.0
 */
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (45.36%)
 * Total Accepted:    289.6K
 * Total Submissions: 638.5K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 */

public class twoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
//        int[] aa = twoSum(nums, target);
//        for (int i : aa) {
//            System.out.println(i);
//        }


        int[] bb = twoSum2(nums, target);
        for (int i : bb) {
            System.out.println(i);
        }


//        int[] cc = twoSum3(nums, target);
//        for (int i : cc) {
//            System.out.println(i);
//        }

    }

    /**
     * 蛮力法 nxn 复杂度
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    int[] num = {i, j};
                    return num;
                }

            }
        }
        int[] num = {};
        return num;
    }


    /**
     * map法 n+n复杂度
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            map.put(num, i);
            i++;
        }

        for (int i1 = 0; i1 < nums.length; i1++) {
            int a = target - nums[i1];
            if (map.get(a) != null) {
                 if (map.get(a)==i1){
                     continue;
                 }
                int[] num = {i1, map.get(a)};
                return num;
            }
        }

        int[] num = {};
        return num;
    }


    /**
     * map法 n复杂度
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            int a = target - nums[i1];
            if (map.get(a) != null) {
                if (map.get(a)==i1){
                    continue;
                }
                int[] num = {map.get(a),i1};
                return num;
            }else {
                map.put(nums[i1],i1);
            }
        }

        int[] num = {};
        return num;
    }


}

