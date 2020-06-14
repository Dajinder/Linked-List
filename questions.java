public class questions{
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    // leetcode 876

    public ListNode middleNode(ListNode node) {
        if(node==null || node.next==null){
            return node;
        }

        ListNode slow = node;
        ListNode fast = node;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // linkedList - fold
    // 1->2->3->4->5->6->7->8
    // 1->8->2->7->3->6->4->5

    public boolean isPallindromic(ListNode head){
        if(head == null || head.next==null){
            return true;
        }
        ListNode mid = middleNode(head);
        ListNode rev = reverse(mid);
        
        while(rev!=null){
            if(head.val!=rev.val) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode prev = null;
        ListNode curr = node;
        ListNode succ = node.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = succ;
            succ = curr.next;
        }
        return prev;
    }


}