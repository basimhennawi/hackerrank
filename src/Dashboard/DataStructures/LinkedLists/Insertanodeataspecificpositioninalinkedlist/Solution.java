Node InsertNth(Node head, int data, int position) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (position == 0) {
        newNode.next = head;
        return newNode;
    }
    
    Node n = head;
    int ctr = 0;
    while (n.next != null && ctr++ < position - 1) {
        n = n.next;
    }
    newNode.next = n.next;
    n.next = newNode;
    return head;
}
