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

    


}