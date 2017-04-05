Node Delete(Node head, int position) {
    if (head == null) return head;
    if (position == 0) return head.next;

    int ctr = 0;
    Node curr = head;
    while (curr.next != null && ctr++ < position - 1) {
        curr = curr.next;
    }
    curr.next = curr.next != null ? curr.next.next : null;
    return head;
}
