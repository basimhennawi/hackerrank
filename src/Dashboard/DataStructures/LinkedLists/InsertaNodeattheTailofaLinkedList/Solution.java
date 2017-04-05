Node Insert(Node head,int data) {
    Node newNode = new Node();
    newNode.data = data;
    if (head == null) {
        return newNode; 
    }
    Node n = head;
    while (n.next != null) {
        n = n.next;
    }
    n.next = newNode;
    return head;
}
