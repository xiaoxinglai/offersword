package leetcode.两数之和;

import java.util.HashMap;

/**
 * @lc app=leetcode.cn id=1 lang=java
 * <p>
 * [1] 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {

    //利用hashMap可以达到时间复杂度为n  空间复杂度为n的解法
    //


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] out = twoSum(nums, target);
        for (int i : out) {
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            Integer key = target - nums[i];
            if (tracker.get(key) == null) {
                tracker.put(nums[i], i);
            } else {
                return new int[]{ tracker.get(key),i};
            }
        }

        return new int[]{};
    }

}
