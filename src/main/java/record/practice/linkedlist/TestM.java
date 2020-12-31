package record.practice.linkedlist;

import record.practice.base.ListNode;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2020-12-26
 */
public class TestM {

    public static void main(String[] args) {
//        char[] chars = "没人比我更懂Java".toCharArray();
//        System.out.println(chars.length);
//        System.out.println("没人比我更懂java".getBytes().length);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
//        System.out.println(node1);

        ListNode node11 = new ListNode(5);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(1);
//        ListNode node44 = new ListNode(7);
//        ListNode node55 = new ListNode(2);
//        ListNode node66 = new ListNode(1);
        node11.setNext(node22);
        node22.setNext(node33);
//        node33.setNext(node44);
//        node44.setNext(node55);
//        node55.setNext(node66);
//        System.out.println(node11);

        ListNode node = addTwoNumbers(node1, node11);
        System.out.println(node);

    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sNode = new ListNode(-1);
        ListNode curr = sNode;
        int jw = 0;
        while (l1!=null || l2!=null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + jw;
            jw = sum <= 9 ? 0 :1;
            int i = sum % 10;
            curr.next = new ListNode(i);

            curr = curr.next;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        if(jw == 1){
            curr.next = new ListNode(1);
        }
        return sNode.next;
    }

}
