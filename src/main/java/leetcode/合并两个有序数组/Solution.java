package leetcode.合并两个有序数组;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [3,5,6],       n = 3
 * <p>
 * 输出: [1,2,3,3,5,6]
 */
public class Solution {


    /**
     * 利用System.arraycopy(源数组，源数组的位置，目标数组，目标数组位置，要拷贝的长度);
     * 然后利用Arrays的sort方法
     * 本质上就是先合并数组，然后再快速排序

     时间复杂度 : O((n + m)\log(n + m))O((n+m)log(n+m))。
     空间复杂度 : O(1)O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     * 利用数组是有序的这点，说明 每个数组最大的必定是在最后一个，那么只要比较最后一个，就可以找出最大的
     * 将最大的放到nums1的最后一个位置
     * <p>
     * 这里的时间复杂度为n 因为充分利用到了数组有序这个特点
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; k--) {

            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
                continue;
            }

            if (j < 0) {
                nums1[k] = nums1[i];
                i--;
                continue;
            }


            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }


        }


    }


    /**
     * 传统方法，先找每一个的元素的插入位置（二分法找插入位置），然后进行插入
     * 每插入一个都要移动一个位置 时间复杂度为n2 加上二分查找法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {


        int j = 0;
        int position = -1;
        while (j < n) {
            //关键点 第二个数组的每一个元素都需要先去去在第一个数组中找到自己的插入位置
            position = postion(nums1, nums2[j]);
            //插入操作
            insert(nums1, nums2[j], position);
            j++;
        }
    }


    /**
     * 二分法返回插入位置
     *
     * @param nums1
     * @param n
     * @return
     */
    static int postion(int[] nums1, int n) {
        int min = 0;
        int max = 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == max) {
                max = i - 1;
                break;
            }
        }

        while (min <= max) { ///注意！ 每一次新的边界值 都不包含中间值
            int mid = (min + max) / 2;
            if (nums1[mid] == n) {
                return mid;
            } else if (nums1[mid] > n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }


    static void insert(int[] nums1, int tar, int position) {
        int max = 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == max) {
                max = i;
                break;
            }
        }

        for (int i = max; i >= position; i--) {
            nums1[i] = nums1[i - 1];
        }
        nums1[position] = tar;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{3, 5, 6};
        int n = 3;
        merge3(nums1, m, nums2, n);
        //   System.out.println(postion(nums1, 2));

        // insert(nums1,2,1);

        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
