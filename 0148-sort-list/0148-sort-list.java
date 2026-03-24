class Solution {
    public ListNode sortList(ListNode head) {

        List<Integer> list=new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        Collections.sort(list);

        ListNode dummy=new ListNode(0),cur=dummy;

        for(int x:list){
            cur.next=new ListNode(x);
            cur=cur.next;
        }

        return dummy.next;
    }
}