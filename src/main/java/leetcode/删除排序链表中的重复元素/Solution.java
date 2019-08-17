package leetcode.删除排序链表中的重复元素;

/**
 * [83] 删除排序链表中的重复元素
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * }
 */
public class Solution {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 思路 快慢指针  （删除节点法）
     * 慢指针永远比快指针慢1
     * <p>
     * 相等的时候则删除一个元素 这一步要循环判断，如果删完还相等 还要继续删
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;

        }
        ListNode frist = head;
        ListNode second;
        while (frist != null) {
            //指针前移
            second = frist;
            frist = frist.next;

            while (frist != null && (frist.val == second.val)) {
                //删除元素
                second.next = frist.next;
                frist = frist.next;
            }
        }

        return head;

    }


    /**
     * 思路 快慢指针 优化以上代码 （和上面其实没啥本质区别，链表去重和数组去重还是不一样的）
     * 慢指针i 快指针j
     * <p>
     * 因为是排序，遇到相等 就快进j指针，然后看下还相等不，如果不， 且重置这值为j指针指向的值，否则继续快进j指针
     * 1 1
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;

        }
        ListNode j = head;
        ListNode i = head;
        while (j != null) {
            //快指针前移
            j = j.next;
            while (j != null && j.val == i.val) {
                j = j.next;
            }
            i.next = j;
            i = i.next;
        }
        return head;

    }

    /**
     * 输入: 1->1->2
     * 输出: 1->2
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
//        ListNode d = new ListNode(2);
//        ListNode e = new ListNode(2);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;
        deleteDuplicates3(a);
        while (a != null) {
            System.out.print(a.val);
            a = a.next;
        }
    }


    /**
     * 单指针 直接遍历，看自己和自己下一个是不是相同，如果是的话就看自己和自己下一个的下一个是不是相同
     * 直到找到一个和自己下一个不相同的，就把自己的下一个设置成那个
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode f=head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next=head.next.next;
            }else {
                head=head.next;
            }
        }

        return f;
    }

}
