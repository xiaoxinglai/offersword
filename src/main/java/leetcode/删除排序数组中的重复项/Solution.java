package leetcode.删除排序数组中的重复项;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int t = removeDuplicates(nums);
        System.out.println(t);
        for (int i = 0; i < t; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 思路：这个是排序数组 也就是已经排好了顺序
     * 那么重复的必然相邻 重复的也会相等 因此,遍历一遍 用比之前大的元素去覆盖num[i]的值
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i == 0) {
                nums[i] = num;
                i++;
                continue;
            }
            if (num > nums[i - 1]) {
                nums[i] = num;
                i++;
            }
        }
        return i;

    }


    /**
     * 双指针法
     * 定义i 和j  i为慢指针，j为快指针
     * 当i指针指向的值和j指针指向的值相等的时候，就快进j指针  且重置这值为j指针指向的值
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;

    }
}
