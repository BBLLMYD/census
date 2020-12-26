package record.practice.linkedlist;

import record.practice.base.ListNode;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2020-12-26
 */
public class Test {

    public static void main(String[] args) {
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
}
