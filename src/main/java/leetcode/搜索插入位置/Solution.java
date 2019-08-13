package leetcode.搜索插入位置;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>m
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        int res = searchInsert(nums, target);
        System.out.println(res);
    }

    /**
     * 因为是有序的 所以用二分查找要快
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        //定义二分查找的边界
        int min = 0;
        int max = nums.length - 1;
        while (min <=max) {
            int mid = (min + max) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }
}
