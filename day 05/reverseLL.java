// Method 1:

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        
        return dummy;
    }
}


// Method 2:

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = head;
        dummy = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }
}