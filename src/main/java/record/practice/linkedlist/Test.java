package record.practice.linkedlist;

import record.practice.base.ListNode;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2020-12-26
 */
public class Test {

    public static void main(String[] args) {
//        char[] chars = "没人比我更懂Java".toCharArray();
//        System.out.println(chars.length);
//        System.out.println("没人比我更懂java".getBytes().length);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
//        System.out.println(node1);
//        ListNode node = removeElements(node1,3);
//        System.out.println(node);
        System.out.println(isPalindrome(node1));

    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head.getNext() == null){
            return head;
        }
        ListNode newHead = head;
        while(head.getNext()!= null){
            if(head.getVal().equals(head.getNext().getVal())){
                head.setNext(head.getNext().getNext());
            }else {
                head = head.getNext();
            }
        }
        return newHead;
    }


    public static boolean hasCycle(ListNode head) {
        if(head == null || head.getNext() == null){
            return false;
        }
        ListNode slow = head.getNext();
        ListNode fast = head.getNext().getNext();
        while(fast!=null){
            if(slow == fast){
                return true;
            }
            slow = slow.getNext();
            if(fast.getNext()==null){
                break;
            }
            fast = fast.getNext().getNext();
        }
        return false;
    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B
     * 中，相交节点前有 3 个节点。
     *
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (!pA.getVal() .equals( pB.getVal())){
            pA = pA.getNext() == null? headB:pA.getNext();
            pB = pB.getNext() == null? headA:pB.getNext();
        }
        return pA;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode s = new ListNode(-1);
        s.next = head;
        ListNode concurrent = head;
        ListNode pre = s;
        while (concurrent!=null){
            if(concurrent.val == val){
                pre.next = concurrent.next;
            }else {
                pre = concurrent;
            }
            concurrent = concurrent.next;
        }
        return s.next;
    }


    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null, newHead = null;
        ListNode curr = slow ;
        // 反转
        while(curr!=null){
            ListNode next = curr.next;
            if(next == null){
                // 需要保留新的头节点，以遍历
                newHead = curr;
            }
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        // 判断两段链表
        while (newHead!=null){
            Integer val = newHead.val;
            Integer val1 = head.val;
            if(!val.equals(val1)){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}
