/*
61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;
        k %= len;
        k = len - k; 
        temp = head;
        while(k-- > 1) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}