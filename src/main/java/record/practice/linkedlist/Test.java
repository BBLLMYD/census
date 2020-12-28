package record.practice.linkedlist;

import record.practice.base.ListNode;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2020-12-26
 */
public class Test {

    public static void main(String[] args) {
        char[] chars = "没人比我更懂Java".toCharArray();
        System.out.println(chars.length);
        System.out.println("没人比我更懂java".getBytes().length);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(node1);
        ListNode node = deleteDuplicates(node1);
        System.out.println(node);
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
}
