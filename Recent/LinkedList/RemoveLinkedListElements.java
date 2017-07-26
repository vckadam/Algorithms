/*
203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

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
    public ListNode removeElements(ListNode head, int val) {
        if(head != null) {
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            for(ListNode temp = fakeHead; temp != null && temp.next != null;) {
                if(temp.next.val == val) temp.next = temp.next.next;
                else temp = temp.next;
            }
            return fakeHead.next;
        }
        else return null;
    }
}
