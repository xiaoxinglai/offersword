package leetcode.最大子序和;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Solution {

    public static void main(String[] args) {
        int[] i = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int res = maxSubArray(i);
        System.out.println(res);

    }


    /**
     * 用一个值记录当前和， 一个值记录最大和
     * 当 当前和大于最大和的时候  就把最大和给当前和
     * 如果变小了，就放弃了这个序列，并把当前和设置和新起点的第一个值
     * <p>
     * 这里已经用了剪枝，将序列比当前最大值小的组合都过滤了
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //记录最大和
        int res = Integer.MIN_VALUE;
        //记录当前和
        int sum = -1;
        for(int i = 0; i < nums.length; ++i)
        {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(sum, res);
        }
        return res;


    }
}
