// Method 1:

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode temp = head;
        int cnt = k;
        while (cnt != 0 && temp != null) {
            temp = temp.next;
            cnt--;
        }

        if (cnt > 0) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null, next = null;
        cnt = k;

        while (curr != null && cnt != 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt--;
        }

        head.next = reverseKGroup(next, k);
        return prev;
    }
}


// Method 2:

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy, prev = dummy, next = dummy;
        int l = 0;
        
        while (curr.next != null) {
            curr = curr.next;
            l++;
        }
        
        while (l >= k) {
            curr = prev.next;
            next = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            prev = curr;
            l -= k;
        }
        
        return dummy.next;
    }
}