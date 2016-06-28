public void deleteNode(ListNode node) {
// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
// Since we do not have access to the node before the one we want to delete, we cannot modify the next pointer of that node in any way. 

        // Instead, we have to replace the value of the node we want to delete with the value in the node after it, 
        node.val = node.next.val;
        
        // and then delete the node after it.
        node.next = node.next.next;
    }
public ListNode reverseList(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;
        
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        // find first non-val
        while (head != null && head.val == val) head = head.next;
        ListNode prev = head;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next; // delete: move previous node pointer to next node, don't update prev
            else prev = curr; // keep: just update prev
            curr = curr.next; // any case: update curr to next node
        }
        
        return head;
    }
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Traverse list A and store the address / reference to each node in a hash set. 
        Map<Integer, Integer> map = new HashMap();
        
        while (headA != null) {
            map.put(headA.val, 0);
            headA = headA.next;
        }
        
        // Then check every node bi in list B: if bi appears in the hash set, then bi is the intersection node.
        while (headB != null && !map.containsKey(headB.val)) headB = headB.next;
        
        return headB;
}
public ListNode deleteDuplicates(ListNode head) {
// Because the input list is sorted, we can determine if a node is a duplicate by comparing its value to the node after it in the list. 
// If it is a duplicate, we change the next pointer of the current node so that it skips the next node 
// and points directly to the one after the next node.
        Listnode curr = head;
        while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) curr.next = curr.next.next;
                else curr = curr.next;
        }
        return head;
}
