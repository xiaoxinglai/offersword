package leetcode.寻找两个有序数组的中位数;

import java.util.Arrays;

/**
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0

 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5


 中位数是这样一个数，它把一个有序数组分成两等份，
 位于它之前的数的个数等于它之后的数的个数。因此我们可以根据这个特点来找到中位数。

 */
public class Solution {



    /**
     * O(log(m + n)) 解不出来 ，但是直接合并后排序可以解出来
     * 如果合并排序后是奇数个，则取中间位置的数，如果合并排序后是偶数个，就取中间两个数的平均数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,a,0,nums1.length);
        System.arraycopy(nums2,0,a,nums1.length,nums2.length);
        Arrays.sort(a);
        if (a.length%2==1){
            return a[a.length/2];
        }else {
            return (double) (a[a.length/2-1]+a[a.length/2])/2;
        }
    }


    public static void main(String[] args) {
       int[] nums1 = new int[]{1, 2};
       int[] nums2 = new int[]{3,4};
       double a= findMedianSortedArrays(nums1,nums2);
        System.out.println(a);
    }
}
