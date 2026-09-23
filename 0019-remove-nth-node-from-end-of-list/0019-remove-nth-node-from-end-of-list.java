class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode fast = a;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        ListNode slow = a;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return a.next;
    }
}