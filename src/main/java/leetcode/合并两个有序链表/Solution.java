package leetcode.合并两个有序链表;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 常规思路 遍历其中一个链表，然后挨个取当前元素比大小，然后排序，放到新链表上
     * 递归思路：先得出退出条件，其中之一为null了就可以返回， 每一轮先判断大小，
     * 然后小的下一个继续和当前的链表进行合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //1231 1311    1231311
        if (l1.val<l2.val){
            //l1要和 l1下一个元素与l2的合并   合并
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            //l2要和 l2下一个元素与l1的合并  合并
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }


    }


}
