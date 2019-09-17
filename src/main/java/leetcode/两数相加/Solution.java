package leetcode.两数相加;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 32+312=344
 */
public class Solution {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode h = p;

        int tag = 0;
        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + tag;
            tag = 0;
            if (sum > 9) {
                int a = sum % 10;
                p.next = new ListNode(a);
                tag = tag + 1;
            } else {
                p.next = new ListNode(sum);
            }
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }


        while (l1 != null) {
            if (tag != 0) {
                l1.val = l1.val + tag;
                if (l1.val > 9) {
                    tag = 1;
                    l1.val = l1.val % 10;
                } else {
                    tag = 0;
                }
            }
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            if (tag != 0) {
                l2.val = l2.val + tag;
                if (l2.val > 9) {
                    tag = 1;
                    l2.val = l2.val % 10;
                } else {
                    tag = 0;
                }

            }
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }


        if (tag != 0) {
            p.next = new ListNode(tag);
        }


        return h.next;
    }


    /**
     * 非常规做法，先转成数字，然后数字相加，再转成链表
     *风险  会溢出
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long s1 = 0;
        int i = 0;
        while (l1 != null) {
            for (int j = 0; j < i; j++) {
                l1.val = l1.val * 10;
            }
            s1 += l1.val;
            l1 = l1.next;
            i++;
        }


        long s2 = 0;
        int i1 = 0;
        while (l2 != null) {
            for (int j = 0; j < i1; j++) {
                l2.val = l2.val * 10;
            }
            s2 += l2.val;
            l2 = l2.next;
            i1++;
        }

        long sum = s1 + s2;

        if (sum == 0) {
            return new ListNode(0);
        }

        ListNode h = new ListNode(-1);
        ListNode p = h;
        while (sum / 10 != 0 || sum % 10 != 0) {
            long a = sum % 10;
            sum = sum / 10;
            h.next = new ListNode((int) a);
            h = h.next;
        }

        return p.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        //        ListNode l2 = new ListNode(4);
        //        ListNode l3 = new ListNode(3);
        //        l1.next = l2;
        //        l2.next = l3;


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(9);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(9);
        ListNode a7 = new ListNode(9);
        ListNode a8 = new ListNode(9);
        ListNode a9 = new ListNode(9);
        ListNode a10 = new ListNode(9);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;


        ListNode h = addTwoNumbers2(l1, a1);
        while (h != null) {
            System.out.print(h.val);
            h = h.next;
        }

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
