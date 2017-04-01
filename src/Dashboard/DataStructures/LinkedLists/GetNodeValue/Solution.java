int GetNode(Node head, int n) {
    if (head == null) return 0;

    Node curr = head;
    Node runner = head;

    for (int i = 0; i < n; i++) {
        runner = runner.next;
    }
    
    while (runner.next != null) {
        curr = curr.next;
        runner = runner.next;
    }
    return curr.data;
}
