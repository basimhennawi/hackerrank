Node Reverse(Node head) {
    if (head == null || head.next == null) {
        return head;
    } else {
        Node next = null;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
