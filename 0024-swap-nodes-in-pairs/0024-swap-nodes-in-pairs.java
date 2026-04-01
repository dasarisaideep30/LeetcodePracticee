/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode d = new ListNode(0,head);
        ListNode cur = d;
        while(cur.next!=null && cur.next.next!=null){
            ListNode a = cur.next;
            ListNode b = cur.next.next;
            a.next=b.next;
            b.next=a;
            cur.next=b;
            cur=a;
        }
        return d.next;
    }
}