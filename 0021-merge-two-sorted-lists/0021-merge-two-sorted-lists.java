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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d = new ListNode(0);
        ListNode cur = d;
        ListNode a = list1;
        ListNode b = list2;
        while(a!=null && b!=null){
            if(a.val<b.val){
                cur.next=a;
                a=a.next;
            }
            else{
                cur.next=b;
                b=b.next;
            }
            cur=cur.next;
        }
        cur.next=(a!=null)?a:b;
        return d.next;
    }
}