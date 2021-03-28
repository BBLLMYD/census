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
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(node1);
        ListNode node = deleteNode(node1,1);
        System.out.println(node);
//        System.out.println(isPalindrome(node1));

    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2
     * 输出: 1->2
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
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

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3
     * 个节点是值为4的节点。
     *
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 1 ; i <= k && fast!=null ; i++){
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        int cnt = 0;
        ListNode cntHeader = head;
        while(cntHeader!=null){
            cntHeader = cntHeader.next;
            cnt++;
        }
        int[] ints = new int[cnt];
        for(int i=cnt-1; i>=0 ; i--){
            ints[i] = head.val;
            head = head.next;
        }
        return ints;
    }

    /**
     * 链表中间节点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        ListNode curr = head;
        while (curr!=null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return head;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode sNode = new ListNode(-1);
        sNode.next = head;

        ListNode pre = sNode;
        ListNode curr = head;

        while (curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }else {
                pre = curr;
            }
            curr = curr.next;
        }
        return sNode.next;
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }
        ListNode sNode = new ListNode(-1);
        sNode.next = head;



        return null;
    }
}
